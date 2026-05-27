package flomik.delightfulcreators.mixin;

import flomik.delightfulcreators.init.ModFluidsRegister;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.world.level.material.FluidState;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Environment(EnvType.CLIENT)
@Mixin(FogRenderer.class)
public abstract class FogRendererMixin {
    @Unique
    private static final float FOG_START = -8.0F;
    @Unique
    private static final float FOG_END = 5.0F;

    @ModifyArgs(
        method = "applyFog*",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/fog/FogRenderer;applyFog(Ljava/nio/ByteBuffer;ILorg/joml/Vector4f;FFFFFF)V"
        )
    )
    private void delightfulcreators$applyFluidFog(
        Args args,
        Camera camera,
        int viewDistance,
        DeltaTracker renderTickCounter,
        float skyDarkness,
        ClientLevel clientWorld
    ) {
        FluidState state = clientWorld.getFluidState(camera.blockPosition());
        Vector4f fogColor = args.get(2);
        if (fogColor != null) {
            delightfulcreators$applyFogColor(state, fogColor);
        }

        if (delightfulcreators$usesThickFog(state)) {
            args.set(3, FOG_START);
            args.set(4, FOG_END);
            args.set(7, FOG_END);
            args.set(8, FOG_END);
        }
    }

    @Unique
    private static boolean delightfulcreators$usesThickFog(FluidState state) {
        return ModFluidsRegister.isTomatoSauce(state)
            || ModFluidsRegister.isHotCocoa(state)
            || ModFluidsRegister.isBeetrootSoup(state)
            || ModFluidsRegister.isChickenSoup(state)
            || ModFluidsRegister.isNoodleSoup(state)
            || ModFluidsRegister.isPumpkinSoup(state)
            || ModFluidsRegister.isVegetableSoup(state)
            || ModFluidsRegister.isFishStew(state)
            || ModFluidsRegister.isBeefStew(state)
            || ModFluidsRegister.isRabbitStew(state)
            || ModFluidsRegister.isMushroomStew(state)
            || ModFluidsRegister.isGlowBerryCustard(state)
            || ModFluidsRegister.isRatatouille(state)
            || ModFluidsRegister.isCookedRice(state)
            || ModFluidsRegister.isDogFood(state)
            || ModFluidsRegister.isBoneBroth(state)
            || ModFluidsRegister.isBakedCodStew(state);
    }

    @Unique
    private static void delightfulcreators$applyFogColor(FluidState state, Vector4f fogColor) {
        if (ModFluidsRegister.isAppleCider(state)) {
            delightfulcreators$setFogColor(fogColor, 211, 152, 87);
        } else if (ModFluidsRegister.isMelonJuice(state)) {
            delightfulcreators$setFogColor(fogColor, 196, 47, 33);
        } else if (ModFluidsRegister.isTomatoSauce(state)) {
            delightfulcreators$setFogColor(fogColor, 196, 24, 16);
        } else if (ModFluidsRegister.isHotCocoa(state)) {
            delightfulcreators$setFogColor(fogColor, 96, 56, 36);
        } else if (ModFluidsRegister.isBeetrootSoup(state)) {
            delightfulcreators$setFogColor(fogColor, 132, 20, 12);
        } else if (ModFluidsRegister.isChickenSoup(state)) {
            delightfulcreators$setFogColor(fogColor, 224, 144, 88);
        } else if (ModFluidsRegister.isNoodleSoup(state)) {
            delightfulcreators$setFogColor(fogColor, 236, 180, 92);
        } else if (ModFluidsRegister.isPumpkinSoup(state)) {
            delightfulcreators$setFogColor(fogColor, 252, 140, 52);
        } else if (ModFluidsRegister.isVegetableSoup(state)) {
            delightfulcreators$setFogColor(fogColor, 140, 124, 36);
        } else if (ModFluidsRegister.isFishStew(state)) {
            delightfulcreators$setFogColor(fogColor, 196, 60, 36);
        } else if (ModFluidsRegister.isBeefStew(state)) {
            delightfulcreators$setFogColor(fogColor, 255, 140, 16);
        } else if (ModFluidsRegister.isRabbitStew(state)) {
            delightfulcreators$setFogColor(fogColor, 212, 124, 60);
        } else if (ModFluidsRegister.isMushroomStew(state)) {
            delightfulcreators$setFogColor(fogColor, 212, 140, 100);
        } else if (ModFluidsRegister.isGlowBerryCustard(state)) {
            delightfulcreators$setFogColor(fogColor, 244, 212, 140);
        } else if (ModFluidsRegister.isRatatouille(state)) {
            delightfulcreators$setFogColor(fogColor, 204, 76, 58);
        } else if (ModFluidsRegister.isCookedRice(state)) {
            delightfulcreators$setFogColor(fogColor, 193, 185, 174);
        } else if (ModFluidsRegister.isDogFood(state)) {
            delightfulcreators$setFogColor(fogColor, 91, 41, 15);
        } else if (ModFluidsRegister.isBoneBroth(state)) {
            delightfulcreators$setFogColor(fogColor, 170, 139, 68);
        } else if (ModFluidsRegister.isBakedCodStew(state)) {
            delightfulcreators$setFogColor(fogColor, 192, 149, 78);
        }
    }

    @Unique
    private static void delightfulcreators$setFogColor(Vector4f fogColor, int red, int green, int blue) {
        fogColor.set(red / 255.0F, green / 255.0F, blue / 255.0F, 1.0F);
    }
}
