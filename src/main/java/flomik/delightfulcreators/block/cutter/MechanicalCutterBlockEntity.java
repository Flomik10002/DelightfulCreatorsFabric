package flomik.delightfulcreators.block.cutter;

import com.zurrtum.create.api.behaviour.BlockEntityBehaviour;
import com.zurrtum.create.catnip.math.VecHelper;
import com.zurrtum.create.content.kinetics.belt.transport.TransportedItemStack;
import com.zurrtum.create.content.kinetics.press.PressingBehaviour;
import com.zurrtum.create.content.kinetics.press.PressingBehaviour.Mode;
import com.zurrtum.create.content.kinetics.press.PressingBehaviour.PressingBehaviourSpecifics;
import com.zurrtum.create.content.processing.basin.BasinBlockEntity;
import com.zurrtum.create.content.processing.basin.BasinInventory;
import com.zurrtum.create.content.processing.basin.BasinOperatingBlockEntity;
import com.zurrtum.create.foundation.recipe.RecipeApplier;
import flomik.delightfulcreators.config.DCServerConfig;
import flomik.delightfulcreators.init.ModBlockEntityTypesRegister;
import flomik.delightfulcreators.recipe.CuttingProcessingRecipe;
import flomik.delightfulcreators.recipe.DCRecipeTypes;
import flomik.delightfulcreators.recipe.KnifeCuttingRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipeInput;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Runs Farmer's Delight knife cutting recipes on belts, depots, loose items and Basins. It also
 * executes this mod's cutting processing step when the input is part of a Sequenced Assembly.
 */
public class MechanicalCutterBlockEntity extends BasinOperatingBlockEntity implements PressingBehaviourSpecifics {

    private static final Object CUTTING_RECIPES_KEY = new Object();

    public PressingBehaviour pressingBehaviour;

    public MechanicalCutterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypesRegister.MECHANICAL_CUTTER, pos, state);
    }

    @Override
    protected AABB createRenderBoundingBox() {
        return new AABB(worldPosition).expandTowards(0, -1.5, 0).expandTowards(0, 1, 0);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour<?>> behaviours) {
        super.addBehaviours(behaviours);
        pressingBehaviour = new PressingBehaviour(this);
        behaviours.add(pressingBehaviour);
    }

    public PressingBehaviour getPressingBehaviour() {
        return pressingBehaviour;
    }

    @Override
    public boolean tryProcessInBasin(boolean simulate) {
        if (!DCServerConfig.SERVER.mechanicalCutterBasinProcessing.get()
                || !(currentRecipe instanceof CuttingBoardRecipe recipe)) {
            return false;
        }

        Optional<BasinBlockEntity> optionalBasin = getBasin();
        if (optionalBasin.isEmpty()) {
            return false;
        }

        if (simulate) {
            return canApplyInBasin(optionalBasin.get(), recipe);
        }

        return applyInBasin(optionalBasin.get(), recipe);
    }

    @Override
    public boolean tryProcessInWorld(ItemEntity itemEntity, boolean simulate) {
        ItemStack input = itemEntity.getItem();
        SingleRecipeInput assemblyInput = new SingleRecipeInput(input);

        Optional<RecipeHolder<CuttingProcessingRecipe>> assemblyRecipe = getAssemblyRecipe(assemblyInput);
        if (assemblyRecipe.isPresent()) {
            if (simulate) {
                return true;
            }
            pressingBehaviour.particleItems.add(input.copy());
            applyAssemblyRecipeInWorld(itemEntity, assemblyInput, assemblyRecipe.get());
            return true;
        }

        Optional<CuttingBoardRecipe> recipe = getRecipe(input);
        if (recipe.isEmpty()) {
            return false;
        }
        if (simulate) {
            return true;
        }

        pressingBehaviour.particleItems.add(input.copy());
        if (input.getCount() == 1) {
            List<ItemStack> results = rollRecipeResults(recipe.get(), 1);
            if (results.isEmpty()) {
                itemEntity.discard();
            } else {
                itemEntity.setItem(results.removeFirst());
                results.forEach(result -> spawnResultEntity(itemEntity, result));
            }
        } else {
            rollRecipeResults(recipe.get(), 1).forEach(result -> spawnResultEntity(itemEntity, result));
            input.shrink(1);
        }

        return true;
    }

    @Override
    public boolean tryProcessOnBelt(TransportedItemStack input, List<ItemStack> outputList, boolean simulate) {
        SingleRecipeInput assemblyInput = new SingleRecipeInput(input.stack);

        Optional<RecipeHolder<CuttingProcessingRecipe>> assemblyRecipe = getAssemblyRecipe(assemblyInput);
        if (assemblyRecipe.isPresent()) {
            if (simulate) {
                return true;
            }
            pressingBehaviour.particleItems.add(input.stack.copy());
            outputList.addAll(RecipeApplier.applyCreateRecipeOn(
                    level, 1, assemblyInput, assemblyRecipe.get().value(), true));
            return true;
        }

        Optional<CuttingBoardRecipe> recipe = getRecipe(input.stack);
        if (recipe.isEmpty()) {
            return false;
        }
        if (simulate) {
            return true;
        }

        pressingBehaviour.particleItems.add(input.stack.copy());
        outputList.addAll(rollRecipeResults(recipe.get(), 1));
        return true;
    }

    @Override
    public void onPressingCompleted() {
        if (pressingBehaviour.onBasin()
                && matchBasinRecipe(currentRecipe)
                && getBasin().filter(BasinBlockEntity::canContinueProcessing).isPresent()) {
            startProcessingBasin();
        } else {
            basinChecker.scheduleUpdate();
        }
    }

    private void applyAssemblyRecipeInWorld(
            ItemEntity itemEntity,
            SingleRecipeInput input,
            RecipeHolder<CuttingProcessingRecipe> recipe) {
        ItemStack stack = itemEntity.getItem();

        if (stack.getCount() == 1) {
            RecipeApplier.applyCreateRecipeOn(itemEntity, input, recipe.value(), true);
            return;
        }

        List<ItemStack> results = RecipeApplier.applyCreateRecipeOn(level, 1, input, recipe.value(), true);
        stack.shrink(1);
        results.forEach(result -> spawnResultEntity(itemEntity, result));
    }

    /**
     * Uses every possible output for the capacity check. This is deliberately conservative: once
     * an animation starts, any chance-result combination can then be committed without losing the
     * input or getting stuck with an uninsertable secondary result.
     */
    private boolean canApplyInBasin(BasinBlockEntity basin, CuttingBoardRecipe recipe) {
        if (findBasinInputSlot(basin, recipe) < 0) {
            return false;
        }

        List<ItemStack> possibleOutputs = recipe.getResults().stream()
                .filter(stack -> !stack.isEmpty())
                .map(ItemStack::copy)
                .toList();
        return basin.acceptOutputs(possibleOutputs, List.of(), true);
    }

    private boolean applyInBasin(BasinBlockEntity basin, CuttingBoardRecipe recipe) {
        int slot = findBasinInputSlot(basin, recipe);
        if (slot < 0) {
            return false;
        }

        List<ItemStack> outputs = rollRecipeResults(recipe, 1);
        if (!basin.acceptOutputs(outputs, List.of(), true)) {
            return false;
        }

        ItemStack processed = basin.itemCapability.getItem(slot).copy();
        basin.itemCapability.removeItem(slot, 1);
        basin.acceptOutputs(outputs, List.of(), false);

        pressingBehaviour.particleItems.add(processed);
        basin.notifyChangeOfContents();
        return true;
    }

    private int findBasinInputSlot(BasinBlockEntity basin, CuttingBoardRecipe recipe) {
        BasinInventory inputs = basin.itemCapability;
        for (int slot = 0; slot < 9; slot++) {
            ItemStack stack = inputs.getItem(slot);
            if (!stack.isEmpty() && recipe.getInput().test(stack)) {
                return slot;
            }
        }
        return -1;
    }

    @Override
    protected boolean isRunning() {
        return pressingBehaviour.running;
    }

    @Override
    protected void onBasinRemoved() {
        pressingBehaviour.particleItems.clear();
        pressingBehaviour.running = false;
        pressingBehaviour.runningTicks = 0;
        currentRecipe = null;
        sendData();
    }

    @Override
    public void startProcessingBasin() {
        if (pressingBehaviour.running && pressingBehaviour.runningTicks <= PressingBehaviour.CYCLE / 2) {
            return;
        }
        super.startProcessingBasin();
        pressingBehaviour.start(Mode.BASIN);
    }

    @Override
    protected boolean matchBasinRecipe(Recipe<?> candidate) {
        if (!(candidate instanceof CuttingBoardRecipe recipe)
                || !DCServerConfig.SERVER.mechanicalCutterBasinProcessing.get()
                || !KnifeCuttingRecipes.isKnifeRecipe(recipe)
                || !super.matchBasinRecipe(candidate)) {
            return false;
        }
        return getBasin().filter(basin -> canApplyInBasin(basin, recipe)).isPresent();
    }

    @Override
    protected boolean matchStaticFilters(RecipeHolder<? extends Recipe<?>> candidate) {
        return DCServerConfig.SERVER.mechanicalCutterBasinProcessing.get()
                && candidate.value().getType() == ModRecipeTypes.CUTTING.get()
                && candidate.value() instanceof CuttingBoardRecipe recipe
                && KnifeCuttingRecipes.isKnifeRecipe(recipe);
    }

    @Override
    protected Object getRecipeCacheKey() {
        return CUTTING_RECIPES_KEY;
    }

    private void spawnResultEntity(ItemEntity source, ItemStack stack) {
        ItemEntity result = new ItemEntity(level, source.getX(), source.getY(), source.getZ(), stack);
        result.setDefaultPickUpDelay();
        result.setDeltaMovement(VecHelper.offsetRandomly(Vec3.ZERO, level.random, .05f));
        level.addFreshEntity(result);
    }

    private List<ItemStack> rollRecipeResults(CuttingBoardRecipe recipe, int count) {
        List<ItemStack> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            for (ItemStack rolled : recipe.rollResults(level.random, 0)) {
                if (rolled.isEmpty()) {
                    continue;
                }

                ItemStack remaining = rolled.copy();
                for (ItemStack existing : results) {
                    if (remaining.isEmpty() || !ItemStack.isSameItemSameComponents(remaining, existing)) {
                        continue;
                    }
                    int mergeAmount = Math.min(existing.getMaxStackSize() - existing.getCount(), remaining.getCount());
                    existing.grow(mergeAmount);
                    remaining.shrink(mergeAmount);
                }

                if (!remaining.isEmpty()) {
                    results.add(remaining);
                }
            }
        }
        return results;
    }

    private Optional<RecipeHolder<CuttingProcessingRecipe>> getAssemblyRecipe(SingleRecipeInput input) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return Optional.empty();
        }
        return serverLevel.recipeAccess().getRecipeFor(DCRecipeTypes.CUTTING_PROCESSING, input, level);
    }

    /**
     * Farmer's Delight matches the tool as part of the recipe input, so passing an iron knife
     * stand-in restricts the Cutter to the knife subset of cutting board recipes. Resolving from
     * the server's recipe manager each time also keeps datapack reloads safe.
     */
    public Optional<CuttingBoardRecipe> getRecipe(ItemStack input) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return Optional.empty();
        }
        CuttingBoardRecipeInput recipeInput =
                new CuttingBoardRecipeInput(input, new ItemStack(ModItems.IRON_KNIFE.get()));
        return serverLevel.recipeAccess()
                .getRecipeFor(ModRecipeTypes.CUTTING.get(), recipeInput, level)
                .map(RecipeHolder::value);
    }

    @Override
    public float getKineticSpeed() {
        return getSpeed();
    }

    @Override
    public boolean canProcessInBulk() {
        return false;
    }

    @Override
    public int getParticleAmount() {
        return 15;
    }
}
