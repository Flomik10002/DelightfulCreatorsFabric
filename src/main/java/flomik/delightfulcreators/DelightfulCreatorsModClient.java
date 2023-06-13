package flomik.delightfulcreators;

import flomik.delightfulcreators.fluid.ModFluids;
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
        });

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_TOMATO_SAUCE, ModFluids.FLOWING_TOMATO_SAUCE,
                new SimpleFluidRenderHandler(
                        new Identifier("delightfulcreators:fluid/tomato_sauce_still"),
                        new Identifier("delightfulcreators:fluid/tomato_sauce_flow")
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_TOMATO_SAUCE, ModFluids.FLOWING_TOMATO_SAUCE);
    }
}