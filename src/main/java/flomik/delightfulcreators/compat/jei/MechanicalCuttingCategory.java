package flomik.delightfulcreators.compat.jei;

import com.zurrtum.create.client.compat.jei.CreateCategory;
import com.zurrtum.create.client.compat.jei.renderer.IconRenderer;
import com.zurrtum.create.client.foundation.gui.AllGuiTextures;
import com.zurrtum.create.client.foundation.gui.render.PressRenderState;
import flomik.delightfulcreators.init.ModBlocksRegister;
import flomik.delightfulcreators.recipe.KnifeCuttingRecipes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotRichTooltipCallback;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3x2f;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;

import java.util.List;

/** Draws cutting-board outputs using Create's Mechanical Press animation. */
public final class MechanicalCuttingCategory extends CreateCategory<RecipeHolder<CuttingBoardRecipe>> {

    public static List<RecipeHolder<CuttingBoardRecipe>> getRecipes(RecipeMap preparedRecipes) {
        return preparedRecipes.byType(ModRecipeTypes.CUTTING.get()).stream()
                .filter(entry -> KnifeCuttingRecipes.isKnifeRecipe(entry.value()))
                .toList();
    }

    @Override
    @NotNull
    public IRecipeType<RecipeHolder<CuttingBoardRecipe>> getRecipeType() {
        return DelightfulCreatorsJeiPlugin.MECHANICAL_CUTTING;
    }

    @Override
    @NotNull
    public Component getTitle() {
        return Component.translatable("jei.delightfulcreators.mechanical_cutting");
    }

    @Override
    public IDrawable getIcon() {
        return new IconRenderer(ModBlocksRegister.MECHANICAL_CUTTER_ITEM);
    }

    @Override
    public int getHeight() {
        return 70;
    }

    @Override
    public void setRecipe(
            IRecipeLayoutBuilder builder,
            RecipeHolder<CuttingBoardRecipe> entry,
            IFocusGroup focuses) {
        CuttingBoardRecipe recipe = entry.value();
        builder.addInputSlot(27, 51).setBackground(SLOT, -1, -1).add(recipe.getInput());

        List<ChanceResult> results = recipe.getRollableResults();
        for (int index = 0; index < results.size(); index++) {
            ChanceResult output = results.get(index);
            // Cutting-board recipes can expose up to four rollable outputs. Keep them inside
            // Create's 177x70 background instead of allowing the third slot to overflow.
            int x = 131 + 19 * (index % 2);
            int y = 31 + 19 * (index / 2);
            builder.addOutputSlot(x, y)
                    .setBackground(output.chance() == 1 ? SLOT : CHANCE_SLOT, -1, -1)
                    .add(output.stack())
                    .addRichTooltipCallback(addChanceTooltip(output));
        }
    }

    @Override
    public void draw(
            RecipeHolder<CuttingBoardRecipe> entry,
            IRecipeSlotsView recipeSlotsView,
            GuiGraphics graphics,
            double mouseX,
            double mouseY) {
        AllGuiTextures.JEI_SHADOW.render(graphics, 61, 41);
        AllGuiTextures.JEI_LONG_ARROW.render(graphics, 52, 54);
        graphics.guiRenderState.submitPicturesInPictureState(new PressRenderState(new Matrix3x2f(graphics.pose()), 73, -16));
    }

    private static IRecipeSlotRichTooltipCallback addChanceTooltip(ChanceResult output) {
        return (view, tooltip) -> {
            float chance = output.chance();
            if (chance != 1) {
                tooltip.add(Component.translatable(
                                "jei.farmersdelight.chance",
                                chance < 0.01 ? "<1" : (int) (chance * 100))
                        .withStyle(ChatFormatting.GOLD));
            }
        };
    }
}
