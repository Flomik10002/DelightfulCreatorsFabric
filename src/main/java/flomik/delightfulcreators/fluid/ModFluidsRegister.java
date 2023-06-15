package flomik.delightfulcreators.fluid;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.item.ModItemsGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluidsRegister {
    public static FlowableFluid STILL_TOMATO_SAUCE;
    public static FlowableFluid FLOWING_TOMATO_SAUCE;
    public static Block TOMATO_SAUCE_BLOCK;
    public static Item TOMATO_SAUCE_BUCKET;
    public static FlowableFluid STILL_APPLE_CIDER;
    public static FlowableFluid FLOWING_APPLE_CIDER;
    public static Block APPLE_CIDER_BLOCK;
    public static Item APPLE_CIDER_BUCKET;
    public static FlowableFluid STILL_HOT_COCOA;
    public static FlowableFluid FLOWING_HOT_COCOA;
    public static Block HOT_COCOA_BLOCK;
    public static Item HOT_COCOA_BUCKET;
    public static FlowableFluid STILL_MELON_JUICE;
    public static FlowableFluid FLOWING_MELON_JUICE;
    public static Block MELON_JUICE_BLOCK;
    public static Item MELON_JUICE_BUCKET;

    public static void register() {
        STILL_TOMATO_SAUCE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "tomato_sauce"), new TomatoSauceFluid.Still());
        FLOWING_TOMATO_SAUCE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_tomato_sauce"), new TomatoSauceFluid.Flowing());
        TOMATO_SAUCE_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "tomato_sauce_block"),
                new FluidBlock(ModFluidsRegister.STILL_TOMATO_SAUCE, FabricBlockSettings.copyOf(Blocks.WATER)));
        TOMATO_SAUCE_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "tomato_sauce_bucket"),
                new BucketItem(ModFluidsRegister.STILL_TOMATO_SAUCE, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_HOT_COCOA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "hot_cocoa"), new HotCocoaFluid.Still());
        FLOWING_HOT_COCOA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_hot_cocoa"), new HotCocoaFluid.Flowing());
        HOT_COCOA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "hot_cocoa_block"),
                new FluidBlock(ModFluidsRegister.STILL_HOT_COCOA, FabricBlockSettings.copyOf(Blocks.WATER)));
        HOT_COCOA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "hot_cocoa_bucket"),
                new BucketItem(ModFluidsRegister.STILL_HOT_COCOA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_MELON_JUICE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "melon_juice"), new MelonJuiceFluid.Still());
        FLOWING_MELON_JUICE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_melon_juice"), new MelonJuiceFluid.Flowing());
        MELON_JUICE_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "melon_juice_block"),
                new FluidBlock(ModFluidsRegister.STILL_MELON_JUICE, FabricBlockSettings.copyOf(Blocks.WATER)));
        MELON_JUICE_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "melon_juice_bucket"),
                new BucketItem(ModFluidsRegister.STILL_MELON_JUICE, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_APPLE_CIDER = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "apple_cider"), new AppleCiderFluid.Still());
        FLOWING_APPLE_CIDER = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_apple_cider"), new AppleCiderFluid.Flowing());
        APPLE_CIDER_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "apple_cider_block"),
                new FluidBlock(ModFluidsRegister.STILL_APPLE_CIDER, FabricBlockSettings.copyOf(Blocks.WATER)));
        APPLE_CIDER_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "apple_cider_bucket"),
                new BucketItem(ModFluidsRegister.STILL_APPLE_CIDER, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
