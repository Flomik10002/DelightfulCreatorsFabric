package flomik.delightfulcreators.recipe;

import net.minecraft.item.ItemStack;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.registry.ModItems;

/** Filters cutting-board recipes to the knife subset that the Mechanical Cutter can automate. */
public final class KnifeCuttingRecipes {

    private static final ItemStack KNIFE_STAND_IN = new ItemStack(ModItems.IRON_KNIFE.get());

    private KnifeCuttingRecipes() {
    }

    public static boolean isKnifeRecipe(CuttingBoardRecipe recipe) {
        return recipe.getTool().test(KNIFE_STAND_IN);
    }
}
