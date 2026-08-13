package flomik.delightfulcreators.recipe;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;

/** Adds Farmer's Delight bark or straw only to Create's runtime-generated stripping recipes. */
public final class SawBarkFallbackRecipes {
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final String CUTTING_TYPE = "create:cutting";
    private static final String GENERATED_PATH_PREFIX = "cutting/runtime_generated/compat/";
    private static final String TREE_BARK = "farmersdelight:tree_bark";
    private static final String STRAW = "farmersdelight:straw";

    private SawBarkFallbackRecipes() {
    }

    public static Map<Identifier, JsonElement> withBarkBonus(Map<Identifier, JsonElement> original) {
        try {
            return apply(original);
        } catch (Exception exception) {
            LOGGER.error("Failed to add bark bonus to Mechanical Saw stripping recipes; keeping the unmodified map",
                    exception);
            return original;
        }
    }

    private static Map<Identifier, JsonElement> apply(Map<Identifier, JsonElement> original) {
        Map<Identifier, JsonElement> result = new HashMap<>(original);
        int patched = 0;

        for (Map.Entry<Identifier, JsonElement> entry : original.entrySet()) {
            Identifier id = entry.getKey();
            // Create currently owns these IDs, while the source namespace is embedded in the
            // path. Matching the distinctive generated path keeps compatibility with generators
            // that preserve the source namespace as the recipe namespace instead.
            if (!id.getPath().startsWith(GENERATED_PATH_PREFIX))
                continue;

            String bonus = strippingBonusItem(entry.getValue());
            if (bonus == null)
                continue;

            JsonObject patchedJson = entry.getValue().deepCopy().getAsJsonObject();
            JsonObject bonusOutput = new JsonObject();
            bonusOutput.addProperty("item", bonus);
            patchedJson.getAsJsonArray("results").add(bonusOutput);
            result.put(id, patchedJson);
            patched++;
            LOGGER.debug("Added {} to Mechanical Saw stripping recipe {}", bonus, id);
        }

        if (patched > 0)
            LOGGER.info("Added a bark/straw bonus to {} Mechanical Saw stripping recipe(s)", patched);

        return result;
    }

    /** Rejects the planks/stairs/slabs recipes emitted under the same runtime-generated prefix. */
    private static String strippingBonusItem(JsonElement element) {
        if (!element.isJsonObject())
            return null;
        JsonObject json = element.getAsJsonObject();
        JsonElement type = json.get("type");
        if (type == null || !type.isJsonPrimitive() || !CUTTING_TYPE.equals(type.getAsString()))
            return null;

        JsonElement ingredientElement = json.get("ingredients");
        JsonElement resultElement = json.get("results");
        if (ingredientElement == null || !ingredientElement.isJsonArray()
                || resultElement == null || !resultElement.isJsonArray())
            return null;

        JsonArray ingredients = ingredientElement.getAsJsonArray();
        JsonArray results = resultElement.getAsJsonArray();
        // The size check also makes this operation idempotent if it is ever applied twice to one map.
        if (ingredients.size() != 1 || results.size() != 1)
            return null;

        JsonElement soleResult = results.get(0);
        if (!soleResult.isJsonObject() || !soleResult.getAsJsonObject().has("item"))
            return null;

        Identifier outputId = Identifier.tryParse(soleResult.getAsJsonObject().get("item").getAsString());
        if (outputId == null || !outputId.getPath().contains("stripped"))
            return null;

        return outputId.getPath().contains("block") ? STRAW : TREE_BARK;
    }
}
