package flomik.delightfulcreators.recipe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;

/**
 * Generates Create fallbacks for Cooking Pot recipes that are not already covered by a manually
 * authored Create recipe. The input map always comes from the current resource reload, so generated
 * entries never leak into the next reload.
 */
public final class CookingPotFallbackRecipes {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final String MOD_ID = "delightfulcreators";

    private static final String COOKING_TYPE = "farmersdelight:cooking";
    private static final String SEQUENCED_ASSEMBLY_TYPE = "create:sequenced_assembly";
    private static final String DEPLOYING_TYPE = "create:deploying";
    private static final String FILLING_TYPE = "create:filling";
    private static final String EMPTYING_TYPE = "create:emptying";

    // Fabric Transfer API represents one bucket as 81,000 droplets.
    private static final long QUARTER_BUCKET = 20_250L;

    private static final Set<String> HANDLED_BY_TYPES = Set.of(
            SEQUENCED_ASSEMBLY_TYPE,
            FILLING_TYPE,
            "create:compacting",
            DEPLOYING_TYPE);

    // FDRF uses c:milks for the item ingredient. Milk Lib exposes the matching fluid as c:milk.
    // Accept c:milk as an item tag as well for compatibility with other Fabric datapacks.
    private static final Map<String, String> ITEM_TAG_TO_FLUID_TAG = Map.of(
            "c:milk", "c:milk",
            "c:milks", "c:milk");

    private static final Set<String> SERVING_CONTAINERS = Set.of(
            "minecraft:bowl",
            "minecraft:glass_bottle",
            "minecraft:bucket");

    private CookingPotFallbackRecipes() {
    }

    public static Map<Identifier, JsonElement> withFallbacks(Map<Identifier, JsonElement> original) {
        try {
            return generate(original);
        } catch (Exception exception) {
            LOGGER.error("Failed to generate fallback cooking recipes; keeping the unmodified recipe map",
                    exception);
            return original;
        }
    }

    private static Map<Identifier, JsonElement> generate(Map<Identifier, JsonElement> original) {
        Set<String> handledResults = collectHandledResults(original);
        Map<String, FluidSource> itemFluids = collectItemFluids(original);
        Map<Identifier, JsonElement> result = new HashMap<>(original);
        int generated = 0;

        for (Map.Entry<Identifier, JsonElement> entry : original.entrySet()) {
            JsonObject cookingRecipe = asCookingRecipe(entry.getValue());
            if (cookingRecipe == null)
                continue;

            JsonObject resultItem = objectMember(cookingRecipe, "result");
            if (resultItem == null || !resultItem.has("item")) {
                LOGGER.debug("Skipping fallback for {}: no simple item result", entry.getKey());
                continue;
            }

            String resultId = resultItem.get("item").getAsString();
            if (handledResults.contains(resultId)) {
                LOGGER.debug("Skipping fallback for {}: result {} is already handled", entry.getKey(), resultId);
                continue;
            }

            JsonArray ingredients = effectiveIngredients(cookingRecipe, resultItem);
            if (ingredients.size() < 2) {
                LOGGER.debug("Skipping fallback for {}: fewer than two effective ingredients", entry.getKey());
                continue;
            }

            Identifier originalId = entry.getKey();
            Identifier fallbackId = new Identifier(MOD_ID,
                    "cooking_fallback/" + originalId.getNamespace() + "/" + originalId.getPath());
            if (result.containsKey(fallbackId)) {
                LOGGER.debug("Skipping fallback for {}: {} already exists", originalId, fallbackId);
                continue;
            }

            JsonObject generatedRecipe = ingredients.size() == 2
                    ? buildSingleStep(ingredients.get(0), ingredients.get(1), resultItem, itemFluids)
                    : buildSequencedAssembly(ingredients, resultItem, itemFluids);
            result.put(fallbackId, generatedRecipe);
            generated++;
            LOGGER.debug("Generated fallback recipe {} for {}", fallbackId, originalId);
        }

        if (generated > 0)
            LOGGER.info("Generated {} fallback Cooking Pot recipe(s)", generated);

        return result;
    }

    /**
     * Farmer's Delight omits the serving bowl from many recipe JSONs and infers it from the result
     * item's recipe remainder. Reproduce that rule before deciding how many Create steps are needed.
     */
    private static JsonArray effectiveIngredients(JsonObject cookingRecipe, JsonObject resultItem) {
        JsonArray ingredients = arrayMember(cookingRecipe, "ingredients");
        if (ingredients == null)
            return new JsonArray();

        JsonObject container = objectMember(cookingRecipe, "container");
        if (container == null || !container.has("item"))
            container = impliedContainer(resultItem);
        if (container == null)
            return ingredients;

        JsonArray withContainer = new JsonArray();
        withContainer.add(container);
        ingredients.forEach(withContainer::add);
        return withContainer;
    }

    private static JsonObject impliedContainer(JsonObject resultItem) {
        if (resultItem == null || !resultItem.has("item"))
            return null;

        Identifier resultId = Identifier.tryParse(resultItem.get("item").getAsString());
        if (resultId == null || !Registries.ITEM.containsId(resultId))
            return null;

        Item item = Registries.ITEM.get(resultId);
        if (!item.hasRecipeRemainder())
            return null;

        Identifier remainderId = Registries.ITEM.getId(item.getRecipeRemainder());
        if (!SERVING_CONTAINERS.contains(remainderId.toString()))
            return null;

        JsonObject json = new JsonObject();
        json.addProperty("item", remainderId.toString());
        return json;
    }

    private static JsonObject asCookingRecipe(JsonElement element) {
        if (!element.isJsonObject())
            return null;
        JsonObject json = element.getAsJsonObject();
        JsonElement type = json.get("type");
        if (type == null || !type.isJsonPrimitive() || !COOKING_TYPE.equals(type.getAsString()))
            return null;
        return json;
    }

    private static Set<String> collectHandledResults(Map<Identifier, JsonElement> recipes) {
        Set<String> handled = new HashSet<>();
        for (JsonElement element : recipes.values()) {
            if (!element.isJsonObject())
                continue;

            JsonObject json = element.getAsJsonObject();
            JsonElement type = json.get("type");
            if (type == null || !type.isJsonPrimitive() || !HANDLED_BY_TYPES.contains(type.getAsString()))
                continue;

            JsonArray results = arrayMember(json, "results");
            if (results == null)
                continue;
            for (JsonElement result : results) {
                if (result.isJsonObject() && result.getAsJsonObject().has("item"))
                    handled.add(result.getAsJsonObject().get("item").getAsString());
            }
        }
        return handled;
    }

    /** Maps dish items to fluids using the mod's existing Create emptying recipes. */
    private static Map<String, FluidSource> collectItemFluids(Map<Identifier, JsonElement> recipes) {
        Map<String, FluidSource> itemFluids = new HashMap<>();
        for (JsonElement element : recipes.values()) {
            if (!element.isJsonObject())
                continue;

            JsonObject json = element.getAsJsonObject();
            JsonElement type = json.get("type");
            if (type == null || !type.isJsonPrimitive() || !EMPTYING_TYPE.equals(type.getAsString()))
                continue;

            JsonArray ingredients = arrayMember(json, "ingredients");
            JsonArray results = arrayMember(json, "results");
            if (ingredients == null || ingredients.size() != 1 || results == null)
                continue;

            JsonElement ingredient = ingredients.get(0);
            if (!ingredient.isJsonObject() || !ingredient.getAsJsonObject().has("item"))
                continue;

            for (JsonElement resultEntry : results) {
                if (!resultEntry.isJsonObject())
                    continue;
                JsonObject resultObject = resultEntry.getAsJsonObject();
                if (!resultObject.has("fluid"))
                    continue;

                String itemId = ingredient.getAsJsonObject().get("item").getAsString();
                String fluidId = resultObject.get("fluid").getAsString();
                long amount = resultObject.has("amount")
                        ? resultObject.get("amount").getAsLong()
                        : QUARTER_BUCKET;
                itemFluids.put(itemId, new FluidSource(fluidId, amount));
                break;
            }
        }
        return itemFluids;
    }

    private static JsonObject buildSequencedAssembly(JsonArray ingredients, JsonObject resultItem,
            Map<String, FluidSource> itemFluids) {
        JsonObject transitionalItem = new JsonObject();
        transitionalItem.addProperty("item", resultItem.get("item").getAsString());

        JsonObject recipe = new JsonObject();
        recipe.addProperty("type", SEQUENCED_ASSEMBLY_TYPE);
        recipe.add("ingredient", ingredients.get(0));
        recipe.addProperty("loops", 1);

        JsonArray results = new JsonArray();
        results.add(resultItem);
        recipe.add("results", results);
        recipe.add("transitionalItem", transitionalItem);

        JsonArray sequence = new JsonArray();
        for (int index = 1; index < ingredients.size(); index++)
            sequence.add(buildStep(transitionalItem, ingredients.get(index), transitionalItem, itemFluids));
        recipe.add("sequence", sequence);
        return recipe;
    }

    private static JsonObject buildSingleStep(JsonElement first, JsonElement second, JsonObject resultItem,
            Map<String, FluidSource> itemFluids) {
        FluidIngredient fluid = asFluidIngredient(second, itemFluids);
        JsonObject recipe = new JsonObject();

        JsonArray recipeIngredients = new JsonArray();
        recipeIngredients.add(first);
        if (fluid != null) {
            recipe.addProperty("type", FILLING_TYPE);
            recipeIngredients.add(fluid.toJson());
        } else {
            recipe.addProperty("type", DEPLOYING_TYPE);
            recipeIngredients.add(second);
        }
        recipe.add("ingredients", recipeIngredients);

        JsonArray results = new JsonArray();
        results.add(resultItem);
        recipe.add("results", results);
        return recipe;
    }

    private static JsonObject buildStep(JsonObject transitionalItem, JsonElement ingredient, JsonObject output,
            Map<String, FluidSource> itemFluids) {
        FluidIngredient fluid = asFluidIngredient(ingredient, itemFluids);
        JsonObject step = new JsonObject();
        JsonArray stepIngredients = new JsonArray();
        stepIngredients.add(transitionalItem);

        if (fluid != null) {
            step.addProperty("type", FILLING_TYPE);
            stepIngredients.add(fluid.toJson());
        } else {
            step.addProperty("type", DEPLOYING_TYPE);
            stepIngredients.add(ingredient);
        }
        step.add("ingredients", stepIngredients);

        JsonArray stepResults = new JsonArray();
        stepResults.add(output);
        step.add("results", stepResults);
        return step;
    }

    private static FluidIngredient asFluidIngredient(JsonElement ingredient,
            Map<String, FluidSource> itemFluids) {
        if (!ingredient.isJsonObject())
            return null;
        JsonObject json = ingredient.getAsJsonObject();

        if (json.has("tag")) {
            String fluidTag = ITEM_TAG_TO_FLUID_TAG.get(json.get("tag").getAsString());
            if (fluidTag != null)
                return FluidIngredient.tag(fluidTag, QUARTER_BUCKET);
        }

        if (json.has("item")) {
            FluidSource source = itemFluids.get(json.get("item").getAsString());
            if (source != null)
                return FluidIngredient.fluid(source.fluidId(), source.amount());
        }

        return null;
    }

    private static JsonObject objectMember(JsonObject json, String name) {
        JsonElement value = json.get(name);
        return value != null && value.isJsonObject() ? value.getAsJsonObject() : null;
    }

    private static JsonArray arrayMember(JsonObject json, String name) {
        JsonElement value = json.get(name);
        return value != null && value.isJsonArray() ? value.getAsJsonArray() : null;
    }

    private record FluidSource(String fluidId, long amount) {
    }

    private record FluidIngredient(String key, String value, long amount) {
        private static FluidIngredient tag(String fluidTag, long amount) {
            return new FluidIngredient("fluidTag", fluidTag, amount);
        }

        private static FluidIngredient fluid(String fluidId, long amount) {
            return new FluidIngredient("fluid", fluidId, amount);
        }

        private JsonObject toJson() {
            JsonObject json = new JsonObject();
            json.addProperty(key, value);
            json.addProperty("amount", amount);
            return json;
        }
    }
}
