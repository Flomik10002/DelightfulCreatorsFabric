package flomik.delightfulcreators.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import flomik.delightfulcreators.recipe.CookingPotFallbackRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.SortedMap;

/**
 * Adds the synthetic fallback recipes to the freshly parsed recipes of every reload, before the
 * recipe map is built. Nothing generated here survives into the next reload.
 */
@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin {

    @Shadow
    @Final
    private HolderLookup.Provider registries;

    @Inject(
            method = "prepare(Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)Lnet/minecraft/world/item/crafting/RecipeMap;",
            at = @At(value = "INVOKE", target = "Ljava/util/SortedMap;size()I"))
    private void delightfulcreators$injectFallbackRecipes(
            ResourceManager resourceManager,
            ProfilerFiller profiler,
            CallbackInfoReturnable<RecipeMap> callback,
            @Local SortedMap<Identifier, Recipe<?>> recipes) {
        CookingPotFallbackRecipes.withFallbacks(recipes, registries);
    }
}
