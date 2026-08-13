package flomik.delightfulcreators.recipe;

import com.simibubi.create.compat.recipeViewerCommon.SequencedAssemblySubCategoryType;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder.ProcessingRecipeParams;
import com.simibubi.create.content.processing.sequenced.IAssemblyRecipe;
import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.init.ModBlocksRegister;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;
import java.util.Set;

/** A Mechanical Cutter step that can be embedded in Create Sequenced Assembly recipes. */
public class CuttingProcessingRecipe extends ProcessingRecipe<Inventory> implements IAssemblyRecipe {

    public CuttingProcessingRecipe(ProcessingRecipeParams params) {
        super(DCRecipeTypes.CUTTING_PROCESSING, params);
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return !inventory.isEmpty() && ingredients.get(0).test(inventory.getStack(0));
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 4;
    }

    @Override
    public void addAssemblyIngredients(List<Ingredient> ingredients) {
        // The transitional item itself is the only input.
    }

    @Override
    @Environment(EnvType.CLIENT)
    public Text getDescriptionForAssembly() {
        return Text.translatable(DelightfulCreatorsMod.MOD_ID + ".recipe.assembly.cutting");
    }

    @Override
    public void addRequiredMachines(Set<ItemConvertible> machines) {
        machines.add(ModBlocksRegister.MECHANICAL_CUTTER);
    }

    @Override
    public SequencedAssemblySubCategoryType getJEISubCategory() {
        // The Cutter shares the Mechanical Press's vertical processing layout in Create Fabric's
        // common JEI/REI/EMI abstraction.
        return SequencedAssemblySubCategoryType.PRESSING;
    }
}
