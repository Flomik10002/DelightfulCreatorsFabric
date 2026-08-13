package flomik.delightfulcreators.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import flomik.delightfulcreators.init.ModFluidsRegister;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.BackgroundRenderer.FogType;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

/** Applies each food fluid's underwater tint and visibility range on Fabric. */
@Environment(EnvType.CLIENT)
@Mixin(BackgroundRenderer.class)
public abstract class BackgroundRendererMixin {

    @ModifyArgs(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/blaze3d/systems/RenderSystem;clearColor(FFFF)V",
                    remap = false))
    private static void delightfulcreators$modifyFogColors(
            Args args,
            Camera camera,
            float tickDelta,
            ClientWorld world,
            int viewDistance,
            float skyDarkness) {
        FluidState state = world.getFluidState(camera.getBlockPos());

        if (ModFluidsRegister.isAppleCider(state)) {
            setColor(args, 211, 152, 87);
        } else if (ModFluidsRegister.isMelonJuice(state)) {
            setColor(args, 196, 47, 33);
        } else if (ModFluidsRegister.isTomatoSauce(state)) {
            setColor(args, 196, 24, 16);
        } else if (ModFluidsRegister.isHotCocoa(state)) {
            setColor(args, 96, 56, 36);
        } else if (ModFluidsRegister.isBeetrootSoup(state)) {
            setColor(args, 132, 20, 12);
        } else if (ModFluidsRegister.isChickenSoup(state)) {
            setColor(args, 224, 144, 88);
        } else if (ModFluidsRegister.isNoodleSoup(state)) {
            setColor(args, 236, 180, 92);
        } else if (ModFluidsRegister.isPumpkinSoup(state)) {
            setColor(args, 252, 140, 52);
        } else if (ModFluidsRegister.isVegetableSoup(state)) {
            setColor(args, 140, 124, 36);
        } else if (ModFluidsRegister.isFishStew(state)) {
            setColor(args, 196, 60, 36);
        } else if (ModFluidsRegister.isBeefStew(state)) {
            setColor(args, 255, 140, 16);
        } else if (ModFluidsRegister.isRabbitStew(state)) {
            setColor(args, 212, 124, 60);
        } else if (ModFluidsRegister.isMushroomStew(state)) {
            setColor(args, 212, 140, 100);
        } else if (ModFluidsRegister.isGlowBerryCustard(state)) {
            setColor(args, 244, 212, 140);
        } else if (ModFluidsRegister.isRatatouille(state)) {
            setColor(args, 204, 76, 58);
        } else if (ModFluidsRegister.isCookedRice(state)) {
            setColor(args, 193, 185, 174);
        } else if (ModFluidsRegister.isDogFood(state)) {
            setColor(args, 91, 41, 15);
        } else if (ModFluidsRegister.isBoneBroth(state)) {
            setColor(args, 170, 139, 68);
        } else if (ModFluidsRegister.isBakedCodStew(state)) {
            setColor(args, 192, 149, 78);
        }
    }

    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void delightfulcreators$applyFog(
            Camera camera,
            FogType fogType,
            float viewDistance,
            boolean thickFog,
            float tickDelta,
            CallbackInfo callback) {
        ClientWorld world = MinecraftClient.getInstance().world;
        if (world == null || !isFoodFluid(world.getFluidState(camera.getBlockPos()))) {
            return;
        }

        RenderSystem.setShaderFogStart(-8);
        RenderSystem.setShaderFogEnd(5);
        callback.cancel();
    }

    private static void setColor(Args args, int red, int green, int blue) {
        args.set(0, red / 255.0F);
        args.set(1, green / 255.0F);
        args.set(2, blue / 255.0F);
    }

    private static boolean isFoodFluid(FluidState state) {
        return ModFluidsRegister.isAppleCider(state)
                || ModFluidsRegister.isMelonJuice(state)
                || ModFluidsRegister.isTomatoSauce(state)
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
}
