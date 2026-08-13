package flomik.delightfulcreators.recipe;

import com.zurrtum.create.AllAssemblyRecipeNames;
import flomik.delightfulcreators.DelightfulCreatorsMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

/** Recipe types owned by Delightful Creators and usable as Create Sequenced Assembly steps. */
public final class DCRecipeTypes {

    private static final Identifier CUTTING_PROCESSING_ID =
            Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "cutting_processing");

    public static final RecipeType<CuttingProcessingRecipe> CUTTING_PROCESSING =
            simpleType(CUTTING_PROCESSING_ID);
    public static final RecipeSerializer<CuttingProcessingRecipe> CUTTING_PROCESSING_SERIALIZER =
            new CuttingProcessingRecipe.Serializer();

    private static boolean registered;

    private DCRecipeTypes() {
    }

    /** Must be called once from the Fabric common initializer before recipes are loaded. */
    public static void register() {
        if (registered) {
            return;
        }
        Registry.register(BuiltInRegistries.RECIPE_TYPE, CUTTING_PROCESSING_ID, CUTTING_PROCESSING);
        Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, CUTTING_PROCESSING_ID, CUTTING_PROCESSING_SERIALIZER);
        // Names the step in Create's Sequenced Assembly tooltips, the way IAssemblyRecipe
        // #getDescriptionForAssembly did before Create 6 replaced it with this registry.
        AllAssemblyRecipeNames.register(
                CUTTING_PROCESSING,
                (ops, json) -> Component.translatable(DelightfulCreatorsMod.MOD_ID + ".recipe.assembly.cutting"));
        registered = true;
    }

    private static <T extends net.minecraft.world.item.crafting.Recipe<?>> RecipeType<T> simpleType(Identifier id) {
        String stringId = id.toString();
        return new RecipeType<>() {
            @Override
            public String toString() {
                return stringId;
            }
        };
    }
}
