package flomik.delightfulcreators.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder.ProcessingRecipeFactory;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import flomik.delightfulcreators.DelightfulCreatorsMod;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/** Recipe types owned by Delightful Creators and backed by Create's processing serializer. */
public enum DCRecipeTypes implements IRecipeTypeInfo {

    CUTTING_PROCESSING(CuttingProcessingRecipe::new);

    private final Identifier id;
    private final RecipeSerializer<?> serializer;
    private final RecipeType<?> type;

    private static boolean registered;

    DCRecipeTypes(ProcessingRecipeFactory<?> factory) {
        String name = name().toLowerCase(java.util.Locale.ROOT);
        id = new Identifier(DelightfulCreatorsMod.MOD_ID, name);
        serializer = new ProcessingRecipeSerializer<>(factory);
        type = simpleType(id);
    }

    /** Must be called once from the Fabric common initializer before recipes are loaded. */
    public static void register() {
        if (registered) {
            return;
        }
        for (DCRecipeTypes recipeType : values()) {
            Registry.register(Registries.RECIPE_SERIALIZER, recipeType.id, recipeType.serializer);
            Registry.register(Registries.RECIPE_TYPE, recipeType.id, recipeType.type);
        }
        registered = true;
    }

    private static <T extends Recipe<?>> RecipeType<T> simpleType(Identifier id) {
        String stringId = id.toString();
        return new RecipeType<>() {
            @Override
            public String toString() {
                return stringId;
            }
        };
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) serializer;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends RecipeType<?>> T getType() {
        return (T) type;
    }
}
