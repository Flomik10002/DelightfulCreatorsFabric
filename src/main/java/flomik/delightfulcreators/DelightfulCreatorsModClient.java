package flomik.delightfulcreators;

import flomik.delightfulcreators.init.ModFluidsRegister;
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
            registry.register(new Identifier("delightfulcreators:fluid/hot_cocoa_still"));
            registry.register(new Identifier("delightfulcreators:fluid/hot_cocoa_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/beetroot_soup_still"));
            registry.register(new Identifier("delightfulcreators:fluid/beetroot_soup_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/chicken_soup_still"));
            registry.register(new Identifier("delightfulcreators:fluid/chicken_soup_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/noodle_soup_still"));
            registry.register(new Identifier("delightfulcreators:fluid/noodle_soup_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/pumpkin_soup_still"));
            registry.register(new Identifier("delightfulcreators:fluid/pumpkin_soup_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/vegetable_soup_still"));
            registry.register(new Identifier("delightfulcreators:fluid/vegetable_soup_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/fish_stew_still"));
            registry.register(new Identifier("delightfulcreators:fluid/fish_stew_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/beef_stew_still"));
            registry.register(new Identifier("delightfulcreators:fluid/beef_stew_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/rabbit_stew_still"));
            registry.register(new Identifier("delightfulcreators:fluid/rabbit_stew_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/mushroom_stew_still"));
            registry.register(new Identifier("delightfulcreators:fluid/mushroom_stew_flow"));
            registry.register(new Identifier("delightfulcreators:fluid/glow_berry_custard_still"));
            registry.register(new Identifier("delightfulcreators:fluid/glow_berry_custard_flow"));
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

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_BEETROOT_SOUP, ModFluidsRegister.FLOWING_BEETROOT_SOUP, new SimpleFluidRenderHandler(
                new Identifier("delightfulcreators:fluid/beetroot_soup_still"),
                new Identifier("delightfulcreators:fluid/beetroot_soup_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_CHICKEN_SOUP, ModFluidsRegister.FLOWING_CHICKEN_SOUP, new SimpleFluidRenderHandler(
                new Identifier("delightfulcreators:fluid/chicken_soup_still"),
                new Identifier("delightfulcreators:fluid/chicken_soup_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_NOODLE_SOUP, ModFluidsRegister.FLOWING_NOODLE_SOUP, new SimpleFluidRenderHandler(
                new Identifier("delightfulcreators:fluid/noodle_soup_still"),
                new Identifier("delightfulcreators:fluid/noodle_soup_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_PUMPKIN_SOUP, ModFluidsRegister.FLOWING_PUMPKIN_SOUP, new SimpleFluidRenderHandler(
                new Identifier("delightfulcreators:fluid/pumpkin_soup_still"),
                new Identifier("delightfulcreators:fluid/pumpkin_soup_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_VEGETABLE_SOUP, ModFluidsRegister.FLOWING_VEGETABLE_SOUP, new SimpleFluidRenderHandler(
                new Identifier("delightfulcreators:fluid/vegetable_soup_still"),
                new Identifier("delightfulcreators:fluid/vegetable_soup_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_FISH_STEW, ModFluidsRegister.FLOWING_FISH_STEW, new SimpleFluidRenderHandler(
                new Identifier("delightfulcreators:fluid/fish_stew_still"),
                new Identifier("delightfulcreators:fluid/fish_stew_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_BEEF_STEW, ModFluidsRegister.FLOWING_BEEF_STEW, new SimpleFluidRenderHandler(
                new Identifier("delightfulcreators:fluid/beef_stew_still"),
                new Identifier("delightfulcreators:fluid/beef_stew_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_RABBIT_STEW, ModFluidsRegister.FLOWING_RABBIT_STEW, new SimpleFluidRenderHandler(
                new Identifier("delightfulcreators:fluid/rabbit_stew_still"),
                new Identifier("delightfulcreators:fluid/rabbit_stew_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_MUSHROOM_STEW, ModFluidsRegister.FLOWING_MUSHROOM_STEW, new SimpleFluidRenderHandler(
                new Identifier("delightfulcreators:fluid/mushroom_stew_still"),
                new Identifier("delightfulcreators:fluid/mushroom_stew_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_GLOW_BERRY_CUSTARD, ModFluidsRegister.FLOWING_GLOW_BERRY_CUSTARD, new SimpleFluidRenderHandler(
                new Identifier("delightfulcreators:fluid/glow_berry_custard_still"),
                new Identifier("delightfulcreators:fluid/glow_berry_custard_flow")
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_TOMATO_SAUCE, ModFluidsRegister.FLOWING_TOMATO_SAUCE);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_APPLE_CIDER, ModFluidsRegister.FLOWING_APPLE_CIDER);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_MELON_JUICE, ModFluidsRegister.FLOWING_MELON_JUICE);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_HOT_COCOA, ModFluidsRegister.FLOWING_HOT_COCOA);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_BEETROOT_SOUP, ModFluidsRegister.FLOWING_BEETROOT_SOUP);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_CHICKEN_SOUP, ModFluidsRegister.FLOWING_CHICKEN_SOUP);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_NOODLE_SOUP, ModFluidsRegister.FLOWING_NOODLE_SOUP);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_PUMPKIN_SOUP, ModFluidsRegister.FLOWING_PUMPKIN_SOUP);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_VEGETABLE_SOUP, ModFluidsRegister.FLOWING_VEGETABLE_SOUP);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_FISH_STEW, ModFluidsRegister.FLOWING_FISH_STEW);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_BEEF_STEW, ModFluidsRegister.FLOWING_BEEF_STEW);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_RABBIT_STEW, ModFluidsRegister.FLOWING_RABBIT_STEW);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_MUSHROOM_STEW, ModFluidsRegister.FLOWING_MUSHROOM_STEW);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluidsRegister.STILL_GLOW_BERRY_CUSTARD, ModFluidsRegister.FLOWING_GLOW_BERRY_CUSTARD);
    }
}