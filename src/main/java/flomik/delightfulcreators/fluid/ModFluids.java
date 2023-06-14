package flomik.delightfulcreators.fluid;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.item.ModItemsGroup;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRenderHandler;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributeHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.item.FluidModificationItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {

    public static FlowableFluid STILL_TOMATO_SAUCE;
    public static FlowableFluid FLOWING_TOMATO_SAUCE;
    public static Block TOMATO_SAUCE_BLOCK;
    public static Item TOMATO_SAUCE_BUCKET;
    public static FlowableFluid STILL_APPLE_CIDER;
    public static FlowableFluid FLOWING_APPLE_CIDER;
    public static Block APPLE_CIDER_BLOCK;
    public static Item APPLE_CIDER_BUCKET;

    public static boolean isTomato_Sauce(FluidState state) {
        return state.isOf(ModFluids.STILL_TOMATO_SAUCE) || state.isOf(ModFluids.FLOWING_TOMATO_SAUCE);
    }


    public static void register() {
        STILL_TOMATO_SAUCE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "tomato_sauce"), new TomatoSauceFluid.Still());
        FLOWING_TOMATO_SAUCE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_tomato_sauce"), new TomatoSauceFluid.Flowing());
        TOMATO_SAUCE_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "tomato_sauce_block"),
                new FluidBlock(ModFluids.STILL_TOMATO_SAUCE, FabricBlockSettings.copyOf(Blocks.WATER)));
        TOMATO_SAUCE_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "tomato_sauce_bucket"),
                new BucketItem(ModFluids.STILL_TOMATO_SAUCE, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_APPLE_CIDER = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "apple_cider"), new AppleCiderFluid.Still());
        FLOWING_APPLE_CIDER = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_apple_cider"), new AppleCiderFluid.Flowing());
        APPLE_CIDER_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "apple_cider_block"),
                new FluidBlock(ModFluids.STILL_APPLE_CIDER, FabricBlockSettings.copyOf(Blocks.WATER)));
        APPLE_CIDER_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "apple_cider_bucket"),
                new BucketItem(ModFluids.STILL_APPLE_CIDER, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
