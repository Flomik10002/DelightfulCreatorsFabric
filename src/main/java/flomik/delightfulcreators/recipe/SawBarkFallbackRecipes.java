package flomik.delightfulcreators.recipe;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.registry.ModItems;

/** Decides the Farmer's Delight bonus a Mechanical Saw stripping result should carry. */
public final class SawBarkFallbackRecipes {

    private SawBarkFallbackRecipes() {
    }

    /**
     * The bark or straw that belongs to a stripping result, or an empty stack for every other Saw
     * output. Rejects the planks/stairs/slabs recipes, exactly like the Forge edition's JSON patch:
     * only results whose id says "stripped" qualify.
     */
    public static ItemStack strippingBonusFor(ItemStack output) {
        if (output.isEmpty()) {
            return ItemStack.EMPTY;
        }

        Identifier outputId = BuiltInRegistries.ITEM.getKey(output.getItem());
        String path = outputId.getPath();
        if (!path.contains("stripped")) {
            return ItemStack.EMPTY;
        }

        // Bamboo blocks shed straw, every other log or stem sheds bark.
        return new ItemStack(
                path.contains("block") ? ModItems.STRAW.get() : ModItems.TREE_BARK.get(),
                output.getCount());
    }
}
