package flomik.delightfulcreators;

import flomik.delightfulcreators.fluid.ModFluidsRegister;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

public class DelightfulCreatorsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier("delightfulcreators:fluid/tomato_sauce_still"));
            registry.register(new Identifier("delightfulcreators:fluid/tomato_sauce_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/apple_cider_still"));
            registry.register(new Identifier("delightfulcreators:fluid/apple_cider_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/melon_juice_still"));
            registry.register(new Identifier("delightfulcreators:fluid/melon_juice_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/hot_cocoa_still"));
            registry.register(new Identifier("delightfulcreators:fluid/hot_cocoa_flow"));
        });

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_TOMATO_SAUCE, ModFluidsRegister.FLOWING_TOMATO_SAUCE,
                new SimpleFluidRenderHandler(
                        new Identifier("delightfulcreators:fluid/tomato_sauce_still"),
                        new Identifier("delightfulcreators:fluid/tomato_sauce_flow")
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_APPLE_CIDER, ModFluidsRegister.FLOWING_APPLE_CIDER, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0xd5864d
            ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_MELON_JUICE, ModFluidsRegister.FLOWING_MELON_JUICE, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0xda5548
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_HOT_COCOA, ModFluidsRegister.FLOWING_HOT_COCOA, new SimpleFluidRenderHandler(
                new Identifier("delightfulcreators:fluid/hot_cocoa_still"),
                new Identifier("delightfulcreators:fluid/hot_cocoa_flow")
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_TOMATO_SAUCE, ModFluidsRegister.FLOWING_TOMATO_SAUCE);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_APPLE_CIDER, ModFluidsRegister.FLOWING_APPLE_CIDER);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_MELON_JUICE, ModFluidsRegister.FLOWING_MELON_JUICE);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_HOT_COCOA, ModFluidsRegister.FLOWING_HOT_COCOA);

    }
}