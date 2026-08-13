package flomik.delightfulcreators.recipe;

import com.google.gson.JsonElement;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import com.zurrtum.create.foundation.fluid.FluidIngredient;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.Nullable;

/**
 * Registry-aware JSON helpers shared by the fallback recipe generators. Sequenced assembly is only
 * reachable through its codec, so the generators have to speak JSON for those parts.
 */
final class RegistryOps {

    /** Placeholders Create's sequenced assembly codec substitutes per step. */
    static final String PLACEHOLDER_INGREDIENT = "$ingredient";
    static final String PLACEHOLDER_RESULT = "$result";

    private final DynamicOps<JsonElement> ops;

    RegistryOps(HolderLookup.Provider registries) {
        this.ops = registries.createSerializationContext(JsonOps.INSTANCE);
    }

    DynamicOps<JsonElement> ops() {
        return ops;
    }

    JsonElement encodeIngredient(Ingredient ingredient) {
        return Ingredient.CODEC.encodeStart(ops, ingredient).getOrThrow();
    }

    JsonElement encodeStack(ItemStack stack) {
        return ItemStack.CODEC.encodeStart(ops, stack).getOrThrow();
    }

    JsonElement encodeFluidIngredient(FluidIngredient ingredient) {
        return FluidIngredient.CODEC.encodeStart(ops, ingredient).getOrThrow();
    }

    Recipe<?> parseRecipe(JsonElement json, Identifier id) {
        return Recipe.CODEC.parse(ops, json)
                .getOrThrow(error -> new IllegalStateException("Invalid generated recipe " + id + ": " + error));
    }

    /**
     * The item tag an ingredient is built from, or null when it lists items directly. Ingredients
     * serialise to either "#namespace:tag" or a plain item id, which is the only public way to tell
     * the two apart on this version.
     */
    @Nullable
    String tagIdOf(Ingredient ingredient) {
        JsonElement json = encodeIngredient(ingredient);
        if (!json.isJsonPrimitive()) {
            return null;
        }
        String value = json.getAsString();
        return value.startsWith("#") ? value.substring(1) : null;
    }

    static TagKey<net.minecraft.world.level.material.Fluid> fluidTag(String id) {
        return TagKey.create(Registries.FLUID, Identifier.parse(id));
    }
}
