package flomik.delightfulcreators.compat.jei;

import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedPress;
import com.simibubi.create.foundation.gui.AllGuiTextures;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotRichTooltipCallback;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.collection.DefaultedList;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;

/** Draws cutting-board outputs using Create's Mechanical Press animation. */
public final class MechanicalCuttingCategory extends CreateRecipeCategory<CuttingBoardRecipe> {

    private final AnimatedPress press = new AnimatedPress(false);

    public MechanicalCuttingCategory(Info<CuttingBoardRecipe> info) {
        super(info);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CuttingBoardRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 27, 51)
                .setBackground(getRenderedSlot(), -1, -1)
                .addIngredients(recipe.getIngredients().get(0));

        DefaultedList<ChanceResult> results = recipe.getRollableResults();
        for (int index = 0; index < results.size(); index++) {
            ChanceResult output = results.get(index);
            // Cutting-board recipes can expose up to four rollable outputs. Keep them inside
            // Create's 177x70 background instead of allowing the third slot to overflow.
            int x = 131 + 19 * (index % 2);
            int y = 31 + 19 * (index / 2);
            builder.addSlot(RecipeIngredientRole.OUTPUT, x, y)
                    .setBackground(getRenderedSlot(output.chance()), -1, -1)
                    .addItemStack(output.stack())
                    .addRichTooltipCallback(addChanceTooltip(output));
        }
    }

    @Override
    public void draw(
            CuttingBoardRecipe recipe,
            IRecipeSlotsView recipeSlotsView,
            DrawContext graphics,
            double mouseX,
            double mouseY) {
        AllGuiTextures.JEI_SHADOW.render(graphics, 61, 41);
        AllGuiTextures.JEI_LONG_ARROW.render(graphics, 52, 54);
        press.draw(graphics, getBackground().getWidth() / 2 - 17, 22);
    }

    private static IRecipeSlotRichTooltipCallback addChanceTooltip(ChanceResult output) {
        return (view, tooltip) -> {
            float chance = output.chance();
            if (chance != 1) {
                tooltip.add(Text.translatable(
                                "jei.farmersdelight.chance",
                                chance < 0.01 ? "<1" : (int) (chance * 100))
                        .formatted(Formatting.GOLD));
            }
        };
    }
}
