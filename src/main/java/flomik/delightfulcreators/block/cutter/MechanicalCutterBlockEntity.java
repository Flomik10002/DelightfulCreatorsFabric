package flomik.delightfulcreators.block.cutter;

import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.press.PressingBehaviour;
import com.simibubi.create.content.kinetics.press.PressingBehaviour.Mode;
import com.simibubi.create.content.kinetics.press.PressingBehaviour.PressingBehaviourSpecifics;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.content.processing.basin.BasinOperatingBlockEntity;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipe;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.item.SmartInventory;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemHandlerHelper;
import io.github.fabricators_of_create.porting_lib.transfer.item.RecipeWrapper;
import flomik.delightfulcreators.config.DCServerConfig;
import flomik.delightfulcreators.init.ModBlockEntityTypesRegister;
import flomik.delightfulcreators.recipe.CuttingProcessingRecipe;
import flomik.delightfulcreators.recipe.DCRecipeTypes;
import flomik.delightfulcreators.recipe.KnifeCuttingRecipes;
import net.createmod.catnip.math.VecHelper;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Runs Farmer's Delight knife cutting recipes on belts, depots, loose items and Basins. It also
 * executes this mod's cutting processing step when the input is part of a Sequenced Assembly.
 */
public class MechanicalCutterBlockEntity extends BasinOperatingBlockEntity implements PressingBehaviourSpecifics {

    private static final Object CUTTING_RECIPES_KEY = new Object();
    private static final RecipeWrapper CUTTING_INVENTORY = new RecipeWrapper(new ItemStackHandler(1));

    private PressingBehaviour pressingBehaviour;

    public MechanicalCutterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypesRegister.MECHANICAL_CUTTER, pos, state);
    }

    @Override
    protected Box createRenderBoundingBox() {
        return new Box(pos).stretch(0, -1.5, 0).stretch(0, 1, 0);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
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
        ItemStack input = itemEntity.getStack();

        Optional<CuttingProcessingRecipe> assemblyRecipe = SequencedAssemblyRecipe.getRecipe(
                world, input, DCRecipeTypes.CUTTING_PROCESSING.getType(), CuttingProcessingRecipe.class);
        if (assemblyRecipe.isPresent()) {
            if (simulate) {
                return true;
            }
            pressingBehaviour.particleItems.add(input.copy());
            applyAssemblyRecipeInWorld(itemEntity, assemblyRecipe.get());
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
                itemEntity.setStack(results.remove(0));
                results.forEach(result -> spawnResultEntity(itemEntity, result));
            }
        } else {
            rollRecipeResults(recipe.get(), 1).forEach(result -> spawnResultEntity(itemEntity, result));
            input.decrement(1);
        }

        return true;
    }

    @Override
    public boolean tryProcessOnBelt(TransportedItemStack input, List<ItemStack> outputList, boolean simulate) {
        Optional<CuttingProcessingRecipe> assemblyRecipe = SequencedAssemblyRecipe.getRecipe(
                world, input.stack, DCRecipeTypes.CUTTING_PROCESSING.getType(), CuttingProcessingRecipe.class);
        if (assemblyRecipe.isPresent()) {
            if (simulate) {
                return true;
            }
            pressingBehaviour.particleItems.add(input.stack.copy());
            outputList.addAll(RecipeApplier.applyRecipeOn(
                    world,
                    ItemHandlerHelper.copyStackWithSize(input.stack, 1),
                    assemblyRecipe.get(),
                    true));
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

    private void applyAssemblyRecipeInWorld(ItemEntity itemEntity, CuttingProcessingRecipe recipe) {
        ItemStack input = itemEntity.getStack();
        List<ItemStack> results = RecipeApplier.applyRecipeOn(
                world, ItemHandlerHelper.copyStackWithSize(input, 1), recipe, true);

        if (input.getCount() == 1) {
            if (results.isEmpty()) {
                itemEntity.discard();
                return;
            }
            itemEntity.setStack(results.remove(0));
        } else {
            input.decrement(1);
        }

        results.forEach(result -> spawnResultEntity(itemEntity, result));
    }

    /**
     * Uses every possible output for the capacity check. This is deliberately conservative: once
     * an animation starts, any chance-result combination can then be committed without losing the
     * input or getting stuck with an uninsertable secondary result.
     */
    private boolean canApplyInBasin(BasinBlockEntity basin, CuttingBoardRecipe recipe) {
        List<ItemStack> possibleOutputs = recipe.getResults().stream()
                .filter(stack -> !stack.isEmpty())
                .map(ItemStack::copy)
                .toList();
        return transferBasinRecipe(basin, recipe, possibleOutputs, false);
    }

    private boolean applyInBasin(BasinBlockEntity basin, CuttingBoardRecipe recipe) {
        List<ItemStack> outputs = rollRecipeResults(recipe, 1);
        return transferBasinRecipe(basin, recipe, outputs, true);
    }

    private boolean transferBasinRecipe(
            BasinBlockEntity basin,
            CuttingBoardRecipe recipe,
            List<ItemStack> outputs,
            boolean commit) {
        if (recipe.getIngredients().isEmpty()) {
            return false;
        }

        SmartInventory inputs = basin.getInputInventory();
        try (Transaction transaction = Transaction.openOuter()) {
            for (StorageView<ItemVariant> view : inputs.nonEmptyViews()) {
                ItemVariant variant = view.getResource();
                ItemStack input = variant.toStack();
                if (!recipe.getIngredients().get(0).test(input)) {
                    continue;
                }
                if (view.extract(variant, 1, transaction) != 1) {
                    continue;
                }
                if (!basin.acceptOutputs(outputs, Collections.emptyList(), transaction)) {
                    return false;
                }

                if (commit) {
                    transaction.commit();
                    pressingBehaviour.particleItems.add(input);
                    basin.notifyChangeOfContents();
                }
                return true;
            }
        }
        return false;
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
    protected <C extends Inventory> boolean matchBasinRecipe(Recipe<C> candidate) {
        if (!(candidate instanceof CuttingBoardRecipe recipe)
                || !DCServerConfig.SERVER.mechanicalCutterBasinProcessing.get()
                || !KnifeCuttingRecipes.isKnifeRecipe(recipe)
                || !super.matchBasinRecipe(candidate)) {
            return false;
        }
        return getBasin().filter(basin -> canApplyInBasin(basin, recipe)).isPresent();
    }

    @Override
    protected <C extends Inventory> boolean matchStaticFilters(Recipe<C> candidate) {
        return DCServerConfig.SERVER.mechanicalCutterBasinProcessing.get()
                && candidate.getType() == ModRecipeTypes.CUTTING.get()
                && candidate instanceof CuttingBoardRecipe recipe
                && KnifeCuttingRecipes.isKnifeRecipe(recipe);
    }

    @Override
    protected Object getRecipeCacheKey() {
        return CUTTING_RECIPES_KEY;
    }

    private void spawnResultEntity(ItemEntity source, ItemStack stack) {
        ItemEntity result = new ItemEntity(world, source.getX(), source.getY(), source.getZ(), stack);
        result.setToDefaultPickupDelay();
        result.setVelocity(VecHelper.offsetRandomly(Vec3d.ZERO, world.random, .05f));
        world.spawnEntity(result);
    }

    private List<ItemStack> rollRecipeResults(CuttingBoardRecipe recipe, int count) {
        List<ItemStack> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            for (ItemStack rolled : recipe.rollResults(world.random, 0)) {
                if (rolled.isEmpty()) {
                    continue;
                }

                ItemStack remaining = rolled.copy();
                for (ItemStack existing : results) {
                    if (remaining.isEmpty() || !ItemStack.canCombine(remaining, existing)) {
                        continue;
                    }
                    int mergeAmount = Math.min(existing.getMaxCount() - existing.getCount(), remaining.getCount());
                    existing.increment(mergeAmount);
                    remaining.decrement(mergeAmount);
                }

                if (!remaining.isEmpty()) {
                    results.add(remaining);
                }
            }
        }
        return results;
    }

    public Optional<CuttingBoardRecipe> getRecipe(ItemStack input) {
        CUTTING_INVENTORY.setStack(0, input);
        // CuttingBoardRecipe#matches checks only the input. Inspect every input match before
        // choosing the knife subset, otherwise an axe/shovel recipe for the same item can mask it.
        // Resolving from the current RecipeManager each time also makes datapack reloads safe.
        return world.getRecipeManager()
                .getAllMatches(ModRecipeTypes.CUTTING.get(), CUTTING_INVENTORY, world)
                .stream()
                .filter(KnifeCuttingRecipes::isKnifeRecipe)
                .findFirst();
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
