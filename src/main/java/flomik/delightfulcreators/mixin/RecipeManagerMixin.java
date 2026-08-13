package flomik.delightfulcreators.mixin;

import java.util.Map;

import com.google.gson.JsonElement;

import flomik.delightfulcreators.recipe.CookingPotFallbackRecipes;
import flomik.delightfulcreators.recipe.SawBarkFallbackRecipes;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/** Adds synthetic recipes to the fresh JSON map before vanilla deserializes it. */
@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin {
    @ModifyVariable(method = "apply", at = @At("HEAD"), argsOnly = true)
    private Map<Identifier, JsonElement> delightfulcreators$injectFallbackRecipes(
            Map<Identifier, JsonElement> recipes) {
        Map<Identifier, JsonElement> withCookingFallbacks = CookingPotFallbackRecipes.withFallbacks(recipes);
        return SawBarkFallbackRecipes.withBarkBonus(withCookingFallbacks);
    }
}
