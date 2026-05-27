package flomik.delightfulcreators;

import flomik.delightfulcreators.init.ModFluidsRegister;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.resources.Identifier;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.api.ClientModInitializer;

public class DelightfulCreatorsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_TOMATO_SAUCE, ModFluidsRegister.FLOWING_TOMATO_SAUCE, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/tomato_sauce_still"),
                Identifier.parse("delightfulcreators:block/tomato_sauce_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_APPLE_CIDER, ModFluidsRegister.FLOWING_APPLE_CIDER, new SimpleFluidRenderHandler(
                Identifier.parse("minecraft:block/water_still"),
                Identifier.parse("minecraft:block/water_flow"),
                0xd5864d
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_MELON_JUICE, ModFluidsRegister.FLOWING_MELON_JUICE, new SimpleFluidRenderHandler(
                Identifier.parse("minecraft:block/water_still"),
                Identifier.parse("minecraft:block/water_flow"),
                0xda5548
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_HOT_COCOA, ModFluidsRegister.FLOWING_HOT_COCOA, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/hot_cocoa_still"),
                Identifier.parse("delightfulcreators:block/hot_cocoa_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_BEETROOT_SOUP, ModFluidsRegister.FLOWING_BEETROOT_SOUP, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/beetroot_soup_still"),
                Identifier.parse("delightfulcreators:block/beetroot_soup_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_CHICKEN_SOUP, ModFluidsRegister.FLOWING_CHICKEN_SOUP, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/chicken_soup_still"),
                Identifier.parse("delightfulcreators:block/chicken_soup_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_NOODLE_SOUP, ModFluidsRegister.FLOWING_NOODLE_SOUP, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/noodle_soup_still"),
                Identifier.parse("delightfulcreators:block/noodle_soup_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_PUMPKIN_SOUP, ModFluidsRegister.FLOWING_PUMPKIN_SOUP, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/pumpkin_soup_still"),
                Identifier.parse("delightfulcreators:block/pumpkin_soup_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_VEGETABLE_SOUP, ModFluidsRegister.FLOWING_VEGETABLE_SOUP, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/vegetable_soup_still"),
                Identifier.parse("delightfulcreators:block/vegetable_soup_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_FISH_STEW, ModFluidsRegister.FLOWING_FISH_STEW, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/fish_stew_still"),
                Identifier.parse("delightfulcreators:block/fish_stew_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_BEEF_STEW, ModFluidsRegister.FLOWING_BEEF_STEW, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/beef_stew_still"),
                Identifier.parse("delightfulcreators:block/beef_stew_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_RABBIT_STEW, ModFluidsRegister.FLOWING_RABBIT_STEW, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/rabbit_stew_still"),
                Identifier.parse("delightfulcreators:block/rabbit_stew_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_MUSHROOM_STEW, ModFluidsRegister.FLOWING_MUSHROOM_STEW, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/mushroom_stew_still"),
                Identifier.parse("delightfulcreators:block/mushroom_stew_flow")
        ));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_GLOW_BERRY_CUSTARD, ModFluidsRegister.FLOWING_GLOW_BERRY_CUSTARD, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/glow_berry_custard_still"),
                Identifier.parse("delightfulcreators:block/glow_berry_custard_flow")
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_RATATOUILLE, ModFluidsRegister.FLOWING_RATATOUILLE, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/ratatouille_still"),
                Identifier.parse("delightfulcreators:block/ratatouille_flow")
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_DOG_FOOD, ModFluidsRegister.FLOWING_DOG_FOOD, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/dog_food_still"),
                Identifier.parse("delightfulcreators:block/dog_food_flow")
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_BAKED_COD_STEW, ModFluidsRegister.FLOWING_BAKED_COD_STEW, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/baked_cod_stew_still"),
                Identifier.parse("delightfulcreators:block/baked_cod_stew_flow")
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_BONE_BROTH, ModFluidsRegister.FLOWING_BONE_BROTH, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/bone_broth_still"),
                Identifier.parse("delightfulcreators:block/bone_broth_flow")
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluidsRegister.STILL_COOKED_RICE, ModFluidsRegister.FLOWING_COOKED_RICE, new SimpleFluidRenderHandler(
                Identifier.parse("delightfulcreators:block/cooked_rice_still"),
                Identifier.parse("delightfulcreators:block/cooked_rice_flow")
        ));

        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_TOMATO_SAUCE, ModFluidsRegister.FLOWING_TOMATO_SAUCE);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_APPLE_CIDER, ModFluidsRegister.FLOWING_APPLE_CIDER);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_MELON_JUICE, ModFluidsRegister.FLOWING_MELON_JUICE);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_HOT_COCOA, ModFluidsRegister.FLOWING_HOT_COCOA);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_BEETROOT_SOUP, ModFluidsRegister.FLOWING_BEETROOT_SOUP);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_CHICKEN_SOUP, ModFluidsRegister.FLOWING_CHICKEN_SOUP);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_NOODLE_SOUP, ModFluidsRegister.FLOWING_NOODLE_SOUP);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_PUMPKIN_SOUP, ModFluidsRegister.FLOWING_PUMPKIN_SOUP);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_VEGETABLE_SOUP, ModFluidsRegister.FLOWING_VEGETABLE_SOUP);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_FISH_STEW, ModFluidsRegister.FLOWING_FISH_STEW);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_BEEF_STEW, ModFluidsRegister.FLOWING_BEEF_STEW);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_RABBIT_STEW, ModFluidsRegister.FLOWING_RABBIT_STEW);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_MUSHROOM_STEW, ModFluidsRegister.FLOWING_MUSHROOM_STEW);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_GLOW_BERRY_CUSTARD, ModFluidsRegister.FLOWING_GLOW_BERRY_CUSTARD);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_RATATOUILLE, ModFluidsRegister.FLOWING_RATATOUILLE);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_DOG_FOOD, ModFluidsRegister.FLOWING_DOG_FOOD);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_BAKED_COD_STEW, ModFluidsRegister.FLOWING_BAKED_COD_STEW);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_BONE_BROTH, ModFluidsRegister.FLOWING_BONE_BROTH);
        BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, ModFluidsRegister.STILL_COOKED_RICE, ModFluidsRegister.FLOWING_COOKED_RICE);
    }
}