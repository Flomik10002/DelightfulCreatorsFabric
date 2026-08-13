package flomik.delightfulcreators.mixin;

import com.zurrtum.create.AllDataComponents;
import flomik.delightfulcreators.item.ModFoods;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Downgrades in-progress Sequenced Assembly stacks to the incomplete food profile.
 *
 * <p>The generated Cooking Pot fallbacks use the finished dish itself as the transitional item and
 * already carry the incomplete components. This covers the same case for stacks produced by other
 * datapacks, which is what the Forge edition's {@code getFoodProperties} patch did.
 */
@Mixin(DataComponentHolder.class)
public interface FoodPropertiesFallbackMixin {

    @Inject(method = "get", at = @At("HEAD"), cancellable = true)
    private <T> void delightfulcreators$incompleteFood(
            DataComponentType<? extends T> type,
            CallbackInfoReturnable<T> callback) {
        if (type != DataComponents.FOOD && type != DataComponents.CONSUMABLE) {
            return;
        }
        if (!((Object) this instanceof ItemStack stack)) {
            return;
        }

        // Read through the component map directly: going through the holder would re-enter this
        // injector. A stack that is not food at all must stay inedible.
        if (!stack.getComponents().has(DataComponents.FOOD)
                || !stack.getComponents().has(AllDataComponents.SEQUENCED_ASSEMBLY_PROGRESS)) {
            return;
        }

        @SuppressWarnings("unchecked")
        T replacement = (T) (type == DataComponents.FOOD
                ? ModFoods.INCOMPLETE
                : ModFoods.INCOMPLETE_CONSUMABLE);
        callback.setReturnValue(replacement);
    }
}
