package flomik.delightfulcreators.compat.jei;

import mezz.jei.common.Internal;
import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.init.ModBlocksRegister;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;

/** Exposes knife-compatible Farmer's Delight cutting recipes as Mechanical Cutter recipes. */
@JeiPlugin
public final class DelightfulCreatorsJeiPlugin implements IModPlugin {

    private static final Identifier PLUGIN_UID =
            Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "jei_plugin");

    @SuppressWarnings("unchecked")
    public static final IRecipeType<RecipeHolder<CuttingBoardRecipe>> MECHANICAL_CUTTING =
            (IRecipeType<RecipeHolder<CuttingBoardRecipe>>) (IRecipeType<?>) IRecipeType.create(
                    Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "mechanical_cutting"),
                    RecipeHolder.class);

    @Override
    @NotNull
    public Identifier getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new MechanicalCuttingCategory());
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeMap preparedRecipes = Internal.getClientSyncedRecipes();
        registration.addRecipes(MECHANICAL_CUTTING, MechanicalCuttingCategory.getRecipes(preparedRecipes));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(MECHANICAL_CUTTING, ModBlocksRegister.MECHANICAL_CUTTER_ITEM);
    }
}
