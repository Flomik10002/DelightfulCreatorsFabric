package flomik.delightfulcreators.mixin;

import flomik.delightfulcreators.init.ModFluidsRegister;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.BackgroundRenderer.FogType;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.FluidState;

@Environment(EnvType.CLIENT)
@Mixin(BackgroundRenderer.class)
public abstract class BackgroundRendererMixin {
    @Shadow
    private static float red;

    @Shadow
    private static float green;

    @Shadow
    private static float blue;

    @ModifyArgs(method = "render", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;clearColor(FFFF)V", remap = false))
    private static void delightfulcreators$modifyFogColors(Args args, Camera camera, float partialTicks, ClientWorld level, int renderDistanceChunks, float bossColorModifier) {
        FluidState state = level.getFluidState(camera.getBlockPos());
        if (ModFluidsRegister.isAppleCider(state)) {
            red = (float) 211 / 255;
            green = (float) 152 / 255;
            blue = (float) 87 / 255;
        }
        if (ModFluidsRegister.isMelonJuice(state)) {
            red = (float) 196 / 255;
            green = (float) 47 / 255;
            blue = (float) 33 / 255;
        }
        if (ModFluidsRegister.isTomatoSauce(state)) {
            red = (float) 196 / 255;
            green = (float) 24 / 255;
            blue = (float) 16 / 255;
        }
        if (ModFluidsRegister.isHotCocoa(state)) {
            red = (float) 96 / 255;
            green = (float) 56 / 255;
            blue = (float) 36 / 255;
        }
        if (ModFluidsRegister.isBeetrootSoup(state)) {
            red = (float) 132 / 255;
            green = (float) 20 / 255;
            blue = (float) 12 / 255;
        }
        if (ModFluidsRegister.isChickenSoup(state)) {
            red = (float) 224 / 255;
            green = (float) 144 / 255;
            blue = (float) 88 / 255;
        }
        if (ModFluidsRegister.isNoodleSoup(state)) {
            red = (float) 236 / 255;
            green = (float) 180 / 255;
            blue = (float) 92 / 255;
        }
        if (ModFluidsRegister.isPumpkinSoup(state)) {
            red = (float) 252 / 255;
            green = (float) 140 / 255;
            blue = (float) 52 / 255;
        }
        if (ModFluidsRegister.isVegetableSoup(state)) {
            red = (float) 140 / 255;
            green = (float) 124 / 255;
            blue = (float) 36 / 255;
        }
        if (ModFluidsRegister.isFishStew(state)) {
            red = (float) 196 / 255;
            green = (float) 60 / 255;
            blue = (float) 36 / 255;
        }
        if (ModFluidsRegister.isBeefStew(state)) {
            red = (float) 255 / 255;
            green = (float) 140 / 255;
            blue = (float) 16 / 255;
        }
        if (ModFluidsRegister.isRabbitStew(state)) {
            red = (float) 212 / 255;
            green = (float) 124 / 255;
            blue = (float) 60 / 255;
        }
        if (ModFluidsRegister.isMushroomStew(state)) {
            red = (float) 212 / 255;
            green = (float) 140 / 255;
            blue = (float) 100 / 255;
        }
        if (ModFluidsRegister.isGlowBerryCustard(state)) {
            red = (float) 244 / 255;
            green = (float) 212 / 255;
            blue = (float) 140 / 255;
        }
        if (ModFluidsRegister.isRatatouille(state)) {
            red = (float) 204 / 255;
            green = (float) 76 / 255;
            blue = (float) 58 / 255;
        }
        if (ModFluidsRegister.isCookedRice(state)) {
            red = (float) 193 / 255;
            green = (float) 185 / 255;
            blue = (float) 174 / 255;
        }
        if (ModFluidsRegister.isDogFood(state)) {
            red = (float) 91 / 255;
            green = (float) 41 / 255;
            blue = (float) 15 / 255;
        }
        if (ModFluidsRegister.isBoneBroth(state)) {
            red = (float) 170 / 255;
            green = (float) 139 / 255;
            blue = (float) 68 / 255;
        }
        if (ModFluidsRegister.isBakedCodStew(state)) {
            red = (float) 192 / 255;
            green = (float) 149 / 255;
            blue = (float) 78 / 255;
        }
    }

    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void delightfulcreators$applyFog(Camera camera, FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        assert MinecraftClient.getInstance().world != null;
        FluidState state = MinecraftClient.getInstance().world.getFluidState(camera.getBlockPos());
        if (ModFluidsRegister.isTomatoSauce(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isHotCocoa(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isBeetrootSoup(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isChickenSoup(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isNoodleSoup(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isPumpkinSoup(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isVegetableSoup(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isFishStew(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isBeefStew(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isRabbitStew(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isMushroomStew(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isGlowBerryCustard(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isRatatouille(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isCookedRice(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isDogFood(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isBoneBroth(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
        if (ModFluidsRegister.isBakedCodStew(state)) {
            RenderSystem.setShaderFogStart(-8);
            RenderSystem.setShaderFogEnd(5);
            ci.cancel();
        }
    }
}