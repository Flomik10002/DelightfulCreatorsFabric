package flomik.delightfulcreators.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import com.zurrtum.create.AllRecipeTypes;
import com.zurrtum.create.content.fluids.transfer.EmptyingRecipe;
import com.zurrtum.create.content.fluids.transfer.FillingRecipe;
import com.zurrtum.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.zurrtum.create.content.kinetics.mixer.CompactingRecipe;
import com.zurrtum.create.content.processing.sequenced.SequencedAssemblyRecipe;
import com.zurrtum.create.foundation.fluid.FluidIngredient;
import com.zurrtum.create.foundation.fluid.FluidStackIngredient;
import com.zurrtum.create.foundation.fluid.FluidTagIngredient;
import com.zurrtum.create.infrastructure.fluids.FluidStack;
import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.item.ModFoods;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.material.Fluid;
import org.slf4j.Logger;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * Generates Create fallbacks for Cooking Pot recipes that are not already covered by a manually
 * authored Create recipe. Everything is derived from the recipes of the current reload, so
 * generated entries never leak into the next one.
 */
public final class CookingPotFallbackRecipes {

    private static final Logger LOGGER = LogUtils.getLogger();

    /** One quarter of a bucket, the amount Create itself uses for milk-based filling recipes. */
    private static final int QUARTER_BUCKET = 20_250;

    // FDRF uses c:milks for the item ingredient. The matching fluid tag is c:milk. Accept both
    // item tags for compatibility with other Fabric datapacks.
    private static final Map<String, String> ITEM_TAG_TO_FLUID_TAG = Map.of(
            "c:milk", "c:milk",
            "c:milks", "c:milk");

    private static final Set<Identifier> SERVING_CONTAINERS = Set.of(
            Identifier.withDefaultNamespace("bowl"),
            Identifier.withDefaultNamespace("glass_bottle"),
            Identifier.withDefaultNamespace("bucket"));

    private CookingPotFallbackRecipes() {
    }

    public static void withFallbacks(SortedMap<Identifier, Recipe<?>> recipes, HolderLookup.Provider registries) {
        try {
            generate(recipes, registries);
        } catch (Exception exception) {
            LOGGER.error("Failed to generate fallback cooking recipes; keeping the unmodified recipe map",
                    exception);
        }
    }

    private static void generate(SortedMap<Identifier, Recipe<?>> recipes, HolderLookup.Provider registries) {
        RegistryOps ops = new RegistryOps(registries);
        Set<Identifier> handledResults = collectHandledResults(recipes);
        Map<Identifier, FluidSource> itemFluids = collectItemFluids(recipes);
        Map<Identifier, Recipe<?>> generated = new HashMap<>();

        for (Map.Entry<Identifier, Recipe<?>> entry : recipes.entrySet()) {
            if (!(entry.getValue() instanceof CookingPotRecipe cookingRecipe)) {
                continue;
            }

            ItemStack result = cookingRecipe.result();
            if (result.isEmpty()) {
                continue;
            }

            Identifier resultId = BuiltInRegistries.ITEM.getKey(result.getItem());
            if (handledResults.contains(resultId)) {
                LOGGER.debug("Skipping fallback for {}: result {} is already handled", entry.getKey(), resultId);
                continue;
            }

            List<Ingredient> ingredients = effectiveIngredients(cookingRecipe);
            if (ingredients.size() < 2) {
                LOGGER.debug("Skipping fallback for {}: fewer than two effective ingredients", entry.getKey());
                continue;
            }

            Identifier originalId = entry.getKey();
            Identifier fallbackId = Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID,
                    "cooking_fallback/" + originalId.getNamespace() + "/" + originalId.getPath());
            if (recipes.containsKey(fallbackId) || generated.containsKey(fallbackId)) {
                LOGGER.debug("Skipping fallback for {}: {} already exists", originalId, fallbackId);
                continue;
            }

            Recipe<?> fallback = ingredients.size() == 2
                    ? buildSingleStep(ingredients.get(0), ingredients.get(1), result, itemFluids, ops)
                    : buildSequencedAssembly(ingredients, result, itemFluids, ops, fallbackId);
            if (fallback == null) {
                continue;
            }

            generated.put(fallbackId, fallback);
            LOGGER.debug("Generated fallback recipe {} for {}", fallbackId, originalId);
        }

        if (!generated.isEmpty()) {
            recipes.putAll(generated);
            // Sequenced assembly synthesises the individual step recipes while it is parsed; they
            // have to reach the recipe manager as well or the machines find nothing to run.
            recipes.putAll(SequencedAssemblyRecipe.Serializer.GENERATE_RECIPES);
            LOGGER.info("Generated {} fallback Cooking Pot recipe(s)", generated.size());
        }
    }

    /**
     * Farmer's Delight omits the serving container from many recipe JSONs and infers it from the
     * result item's crafting remainder. Reproduce that rule before deciding how many Create steps
     * are needed.
     */
    private static List<Ingredient> effectiveIngredients(CookingPotRecipe recipe) {
        List<Ingredient> ingredients = new ArrayList<>(recipe.input());

        ItemStack container = recipe.container();
        if (container.isEmpty()) {
            container = impliedContainer(recipe.result());
        }
        if (!container.isEmpty()) {
            ingredients.addFirst(Ingredient.of(container.getItem()));
        }

        return ingredients;
    }

    private static ItemStack impliedContainer(ItemStack result) {
        ItemStack remainder = result.getItem().getCraftingRemainder();
        if (remainder.isEmpty()) {
            return ItemStack.EMPTY;
        }
        return SERVING_CONTAINERS.contains(BuiltInRegistries.ITEM.getKey(remainder.getItem()))
                ? remainder
                : ItemStack.EMPTY;
    }

    private static Set<Identifier> collectHandledResults(SortedMap<Identifier, Recipe<?>> recipes) {
        Set<Identifier> handled = new HashSet<>();
        for (Recipe<?> recipe : recipes.values()) {
            ItemStack result = switch (recipe) {
                case SequencedAssemblyRecipe assembly -> assembly.result().stack();
                case FillingRecipe filling -> filling.result();
                case DeployerApplicationRecipe deploying -> deploying.result();
                case CompactingRecipe compacting -> compacting.result();
                default -> ItemStack.EMPTY;
            };
            if (!result.isEmpty()) {
                handled.add(BuiltInRegistries.ITEM.getKey(result.getItem()));
            }
        }
        return handled;
    }

    /** Maps dish items to fluids using the mod's existing Create emptying recipes. */
    private static Map<Identifier, FluidSource> collectItemFluids(SortedMap<Identifier, Recipe<?>> recipes) {
        Map<Identifier, FluidSource> itemFluids = new HashMap<>();
        for (Recipe<?> recipe : recipes.values()) {
            if (!(recipe instanceof EmptyingRecipe emptying)) {
                continue;
            }

            FluidStack fluid = emptying.fluidResult();
            if (fluid.isEmpty()) {
                continue;
            }

            emptying.ingredient().items()
                    .map(holder -> BuiltInRegistries.ITEM.getKey(holder.value()))
                    .forEach(itemId -> itemFluids.putIfAbsent(
                            itemId,
                            new FluidSource(fluid.getFluid(), fluid.getAmount())));
        }
        return itemFluids;
    }

    private static Recipe<?> buildSingleStep(
            Ingredient first,
            Ingredient second,
            ItemStack result,
            Map<Identifier, FluidSource> itemFluids,
            RegistryOps ops) {
        FluidIngredient fluid = asFluidIngredient(second, itemFluids, ops);
        if (fluid != null) {
            return new FillingRecipe(result.copy(), first, fluid);
        }
        return new DeployerApplicationRecipe(result.copy(), false, first, second);
    }

    /**
     * Sequenced assembly builds its individual steps while its own codec runs, so this one has to
     * go through JSON rather than through the record constructor.
     */
    private static Recipe<?> buildSequencedAssembly(
            List<Ingredient> ingredients,
            ItemStack result,
            Map<Identifier, FluidSource> itemFluids,
            RegistryOps ops,
            Identifier fallbackId) {
        JsonObject recipe = new JsonObject();
        recipe.addProperty("type", AllRecipeTypes.SEQUENCED_ASSEMBLY.toString());
        recipe.add("ingredient", ops.encodeIngredient(ingredients.get(0)));
        recipe.add("transitional_item", ops.encodeStack(transitionalItem(result)));
        recipe.add("result", ops.encodeStack(result));
        recipe.addProperty("loops", 1);

        JsonArray sequence = new JsonArray();
        for (int index = 1; index < ingredients.size(); index++) {
            sequence.add(buildStep(ingredients.get(index), itemFluids, ops));
        }
        recipe.add("sequence", sequence);

        return ops.parseRecipe(recipe, fallbackId);
    }

    /**
     * The transitional item is the finished dish itself, so a half-assembled stack would otherwise
     * be edible for the full meal. Per-stack food components downgrade it to the incomplete profile
     * and drop the finished dish's consume effects.
     */
    private static ItemStack transitionalItem(ItemStack result) {
        ItemStack transitional = result.copyWithCount(1);
        if (transitional.has(DataComponents.FOOD)) {
            transitional.set(DataComponents.FOOD, ModFoods.INCOMPLETE);
            transitional.set(DataComponents.CONSUMABLE, ModFoods.INCOMPLETE_CONSUMABLE);
        }
        return transitional;
    }

    private static JsonObject buildStep(
            Ingredient ingredient,
            Map<Identifier, FluidSource> itemFluids,
            RegistryOps ops) {
        JsonObject step = new JsonObject();
        FluidIngredient fluid = asFluidIngredient(ingredient, itemFluids, ops);

        if (fluid != null) {
            step.addProperty("type", AllRecipeTypes.FILLING.toString());
            step.addProperty("ingredient", RegistryOps.PLACEHOLDER_INGREDIENT);
            step.add("fluid_ingredient", ops.encodeFluidIngredient(fluid));
        } else {
            step.addProperty("type", AllRecipeTypes.DEPLOYING.toString());
            step.addProperty("target", RegistryOps.PLACEHOLDER_INGREDIENT);
            step.add("ingredient", ops.encodeIngredient(ingredient));
        }

        step.addProperty("result", RegistryOps.PLACEHOLDER_RESULT);
        return step;
    }

    private static FluidIngredient asFluidIngredient(
            Ingredient ingredient,
            Map<Identifier, FluidSource> itemFluids,
            RegistryOps ops) {
        String itemTag = ops.tagIdOf(ingredient);
        if (itemTag != null) {
            String fluidTag = ITEM_TAG_TO_FLUID_TAG.get(itemTag);
            if (fluidTag != null) {
                return new FluidTagIngredient(RegistryOps.fluidTag(fluidTag), QUARTER_BUCKET);
            }
        }

        List<Identifier> items = ingredient.items()
                .map(holder -> BuiltInRegistries.ITEM.getKey(holder.value()))
                .toList();
        if (items.size() == 1) {
            FluidSource source = itemFluids.get(items.getFirst());
            if (source != null) {
                return new FluidStackIngredient(source.fluid(), DataComponentPatch.EMPTY, source.amount());
            }
        }

        return null;
    }

    private record FluidSource(Fluid fluid, int amount) {
    }
}
