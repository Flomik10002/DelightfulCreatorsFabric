package flomik.delightfulcreators.mixin;

import com.zurrtum.create.content.kinetics.saw.SawBlockEntity;
import com.zurrtum.create.content.processing.recipe.ProcessingInventory;
import flomik.delightfulcreators.recipe.SawBarkFallbackRecipes;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Gives the Mechanical Saw the bark or straw a real Cutting Board drops when stripping a log.
 *
 * <p>The Forge edition patched Create's stripping recipes to carry a second output. Create 6's
 * {@code create:cutting} recipe holds a single result, and the Saw only ever accepts its own
 * recipe type, so the bonus has to be appended after the recipe has been applied.
 */
@Mixin(SawBlockEntity.class)
public abstract class SawBarkBonusMixin {

    @Shadow
    public ProcessingInventory inventory;

    @Inject(method = "applyRecipe", at = @At("TAIL"))
    private void delightfulcreators$addBarkBonus(CallbackInfo callback) {
        ItemStack primaryOutput = inventory.getItem(1);
        ItemStack bonus = SawBarkFallbackRecipes.strippingBonusFor(primaryOutput);
        if (bonus.isEmpty()) {
            return;
        }

        for (int slot = 2, size = inventory.getContainerSize(); slot < size; slot++) {
            ItemStack stackInSlot = inventory.getItem(slot);
            if (stackInSlot.isEmpty()) {
                inventory.setItem(slot, bonus);
                return;
            }
            if (ItemStack.isSameItemSameComponents(stackInSlot, bonus)
                    && stackInSlot.getCount() + bonus.getCount() <= stackInSlot.getMaxStackSize()) {
                stackInSlot.grow(bonus.getCount());
                return;
            }
        }
    }
}
