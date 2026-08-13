package flomik.delightfulcreators.mixin;

import flomik.delightfulcreators.item.ModFoods;
import net.fabricmc.fabric.api.item.v1.FabricItemStack;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.StewItem;
import net.minecraft.nbt.NbtElement;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Fabric has no stack-aware food-properties hook. Intercept the vanilla stack consumption choke
 * point instead: a Create transitional stack receives only the incomplete food profile, while all
 * effects and custom consumption behavior belonging to the finished dish are deliberately skipped.
 */
@Mixin(ItemStack.class)
public abstract class FoodPropertiesFallbackMixin {
    private static final String SEQUENCED_ASSEMBLY_KEY = "SequencedAssembly";

    @Shadow
    public abstract boolean hasNbt();

    @Shadow
    public abstract net.minecraft.nbt.NbtCompound getNbt();

    @Shadow
    public abstract Item getItem();

    @Shadow
    public abstract boolean isEmpty();

    @Shadow
    public abstract void decrement(int amount);

    @Inject(method = "finishUsing", at = @At("HEAD"), cancellable = true)
    private void delightfulcreators$finishIncompleteFood(World world, LivingEntity consumer,
            CallbackInfoReturnable<ItemStack> callback) {
        if (!delightfulcreators$isIncompleteAssemblyStack())
            return;

        ItemStack self = (ItemStack) (Object) this;
        // StewItem returns its bowl from its own finishUsing override, which this mixin replaces.
        // Preserve that behavior explicitly; other container foods can use Fabric's stack-aware
        // recipe remainder hook.
        ItemStack remainder = getItem() instanceof StewItem
                ? new ItemStack(Items.BOWL)
                : ((FabricItemStack) (Object) this).getRecipeRemainder();

        if (consumer instanceof PlayerEntity player) {
            player.getHungerManager().add(
                    ModFoods.INCOMPLETE.getHunger(),
                    ModFoods.INCOMPLETE.getSaturationModifier());
            player.incrementStat(Stats.USED.getOrCreateStat(getItem()));

            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5f,
                    world.random.nextFloat() * 0.1f + 0.9f);
            if (player instanceof ServerPlayerEntity serverPlayer)
                Criteria.CONSUME_ITEM.trigger(serverPlayer, self);
        }

        world.playSound(null, consumer.getX(), consumer.getY(), consumer.getZ(),
                consumer.getEatSound(self), SoundCategory.NEUTRAL, 1.0f,
                1.0f + (world.random.nextFloat() - world.random.nextFloat()) * 0.4f);

        if (!(consumer instanceof PlayerEntity player) || !player.getAbilities().creativeMode)
            decrement(1);
        consumer.emitGameEvent(GameEvent.EAT);

        if (isEmpty()) {
            callback.setReturnValue(remainder);
            return;
        }

        if (consumer instanceof PlayerEntity player && !player.getAbilities().creativeMode
                && !remainder.isEmpty() && !player.getInventory().insertStack(remainder))
            player.dropItem(remainder, false);

        callback.setReturnValue(self);
    }

    private boolean delightfulcreators$isIncompleteAssemblyStack() {
        return getItem().isFood()
                && hasNbt()
                && getNbt() != null
                && getNbt().contains(SEQUENCED_ASSEMBLY_KEY, NbtElement.COMPOUND_TYPE);
    }
}
