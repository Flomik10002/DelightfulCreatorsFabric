package flomik.delightfulcreators.compat.jei;

import com.simibubi.create.compat.jei.EmptyBackground;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.init.ModBlocksRegister;
import flomik.delightfulcreators.recipe.KnifeCuttingRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;

import java.util.List;

/** Exposes knife-compatible Farmer's Delight cutting recipes as Mechanical Cutter recipes. */
@JeiPlugin
public final class DelightfulCreatorsJeiPlugin implements IModPlugin {

    private static final Identifier PLUGIN_UID =
            new Identifier(DelightfulCreatorsMod.MOD_ID, "jei_plugin");

    public static final RecipeType<CuttingBoardRecipe> MECHANICAL_CUTTING = RecipeType.create(
            DelightfulCreatorsMod.MOD_ID,
            "mechanical_cutting",
            CuttingBoardRecipe.class);

    @Override
    public Identifier getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        CreateRecipeCategory.Info<CuttingBoardRecipe> info = new CreateRecipeCategory.Info<>(
                MECHANICAL_CUTTING,
                Text.translatable("jei.delightfulcreators.mechanical_cutting"),
                new EmptyBackground(177, 70),
                registration.getJeiHelpers().getGuiHelper().createDrawableIngredient(
                        VanillaTypes.ITEM_STACK,
                        new ItemStack(ModBlocksRegister.MECHANICAL_CUTTER)),
                DelightfulCreatorsJeiPlugin::getCuttingRecipes,
                List.of(() -> new ItemStack(ModBlocksRegister.MECHANICAL_CUTTER)));
        registration.addRecipeCategories(new MechanicalCuttingCategory(info));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(MECHANICAL_CUTTING, getCuttingRecipes());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(
                new ItemStack(ModBlocksRegister.MECHANICAL_CUTTER),
                MECHANICAL_CUTTING);
    }

    private static List<CuttingBoardRecipe> getCuttingRecipes() {
        ClientWorld world = MinecraftClient.getInstance().world;
        if (world == null) {
            return List.of();
        }
        return world.getRecipeManager()
                .listAllOfType(ModRecipeTypes.CUTTING.get())
                .stream()
                .filter(KnifeCuttingRecipes::isKnifeRecipe)
                .toList();
    }
}
