package flomik.delightfulcreators.fluids;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.fluids.farmersdelightfluids.*;
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
    public static FlowableFluid STILL_TOMATO_SAUCE, STILL_HOT_COCOA, STILL_MELON_JUICE, STILL_APPLE_CIDER, STILL_BEETROOT_SOUP, STILL_CHICKEN_SOUP, STILL_NOODLE_SOUP, STILL_PUMPKIN_SOUP, STILL_VEGETABLE_SOUP, STILL_FISH_STEW, STILL_BEEF_STEW, STILL_RABBIT_STEW, STILL_MUSHROOM_STEW, STILL_GLOW_BERRY_CUSTARD, STILL_SWEET_BERRY_STUFFING;
    public static FlowableFluid FLOWING_TOMATO_SAUCE, FLOWING_HOT_COCOA, FLOWING_MELON_JUICE, FLOWING_APPLE_CIDER, FLOWING_BEETROOT_SOUP, FLOWING_CHICKEN_SOUP, FLOWING_NOODLE_SOUP, FLOWING_PUMPKIN_SOUP, FLOWING_VEGETABLE_SOUP, FLOWING_FISH_STEW, FLOWING_BEEF_STEW, FLOWING_RABBIT_STEW, FLOWING_MUSHROOM_STEW, FLOWING_GLOW_BERRY_CUSTARD, FLOWING_SWEET_BERRY_STUFFING;
    public static Block TOMATO_SAUCE_BLOCK, HOT_COCOA_BLOCK, MELON_JUICE_BLOCK, APPLE_CIDER_BLOCK, BEETROOT_SOUP_BLOCK, CHICKEN_SOUP_BLOCK, NOODLE_SOUP_BLOCK, PUMPKIN_SOUP_BLOCK, VEGETABLE_SOUP_BLOCK, FISH_STEW_BLOCK, BEEF_STEW_BLOCK, RABBIT_STEW_BLOCK, MUSHROOM_STEW_BLOCK, GLOW_BERRY_CUSTARD_BLOCK, SWEET_BERRY_STUFFING_BLOCK;
    public static Item TOMATO_SAUCE_BUCKET, HOT_COCOA_BUCKET, MELON_JUICE_BUCKET, APPLE_CIDER_BUCKET, BEETROOT_SOUP_BUCKET, CHICKEN_SOUP_BUCKET, NOODLE_SOUP_BUCKET, PUMPKIN_SOUP_BUCKET, VEGETABLE_SOUP_BUCKET, FISH_STEW_BUCKET, BEEF_STEW_BUCKET, RABBIT_STEW_BUCKET, MUSHROOM_STEW_BUCKET, GLOW_BERRY_CUSTARD_BUCKET, SWEET_BERRY_STUFFING_BUCKET;

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

        STILL_BEETROOT_SOUP = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "beetroot_soup"), new BeetrootSoupFluid.Still());
        FLOWING_BEETROOT_SOUP = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_beetroot_soup"), new BeetrootSoupFluid.Flowing());
        BEETROOT_SOUP_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "beetroot_soup_block"),
                new FluidBlock(ModFluidsRegister.STILL_BEETROOT_SOUP, FabricBlockSettings.copyOf(Blocks.WATER)));
        BEETROOT_SOUP_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "beetroot_soup_bucket"),
                new BucketItem(ModFluidsRegister.STILL_BEETROOT_SOUP, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_CHICKEN_SOUP = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "chicken_soup"), new ChickenSoupFluid.Still());
        FLOWING_CHICKEN_SOUP = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_chicken_soup"), new ChickenSoupFluid.Flowing());
        CHICKEN_SOUP_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "chicken_soup_block"),
                new FluidBlock(ModFluidsRegister.STILL_CHICKEN_SOUP, FabricBlockSettings.copyOf(Blocks.WATER)));
        CHICKEN_SOUP_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "chicken_soup_bucket"),
                new BucketItem(ModFluidsRegister.STILL_CHICKEN_SOUP, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_NOODLE_SOUP = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "noodle_soup"), new NoodleSoupFluid.Still());
        FLOWING_NOODLE_SOUP = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_noodle_soup"), new NoodleSoupFluid.Flowing());
        NOODLE_SOUP_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "noodle_soup_block"),
                new FluidBlock(ModFluidsRegister.STILL_NOODLE_SOUP, FabricBlockSettings.copyOf(Blocks.WATER)));
        NOODLE_SOUP_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "noodle_soup_bucket"),
                new BucketItem(ModFluidsRegister.STILL_NOODLE_SOUP, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_PUMPKIN_SOUP = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "pumpkin_soup"), new PumpkinSoupFluid.Still());
        FLOWING_PUMPKIN_SOUP = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_pumpkin_soup"), new PumpkinSoupFluid.Flowing());
        PUMPKIN_SOUP_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "pumpkin_soup_block"),
                new FluidBlock(ModFluidsRegister.STILL_PUMPKIN_SOUP, FabricBlockSettings.copyOf(Blocks.WATER)));
        PUMPKIN_SOUP_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "pumpkin_soup_bucket"),
                new BucketItem(ModFluidsRegister.STILL_PUMPKIN_SOUP, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_VEGETABLE_SOUP = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "vegetable_soup"), new VegetableSoupFluid.Still());
        FLOWING_VEGETABLE_SOUP = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_vegetable_soup"), new VegetableSoupFluid.Flowing());
        VEGETABLE_SOUP_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "vegetable_soup_block"),
                new FluidBlock(ModFluidsRegister.STILL_VEGETABLE_SOUP, FabricBlockSettings.copyOf(Blocks.WATER)));
        VEGETABLE_SOUP_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "vegetable_soup_bucket"),
                new BucketItem(ModFluidsRegister.STILL_VEGETABLE_SOUP, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_FISH_STEW = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "fish_stew"), new FishStewFluid.Still());
        FLOWING_FISH_STEW = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_fish_stew"), new FishStewFluid.Flowing());
        FISH_STEW_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "fish_stew_block"),
                new FluidBlock(ModFluidsRegister.STILL_FISH_STEW, FabricBlockSettings.copyOf(Blocks.WATER)));
        FISH_STEW_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "fish_stew_bucket"),
                new BucketItem(ModFluidsRegister.STILL_FISH_STEW, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_BEEF_STEW = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "beef_stew"), new BeefStewFluid.Still());
        FLOWING_BEEF_STEW = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_beef_stew"), new BeefStewFluid.Flowing());
        BEEF_STEW_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "beef_stew_block"),
                new FluidBlock(ModFluidsRegister.STILL_BEEF_STEW, FabricBlockSettings.copyOf(Blocks.WATER)));
        BEEF_STEW_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "beef_stew_bucket"),
                new BucketItem(ModFluidsRegister.STILL_BEEF_STEW, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_RABBIT_STEW = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "rabbit_stew"), new RabbitStewFluid.Still());
        FLOWING_RABBIT_STEW = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_rabbit_stew"), new RabbitStewFluid.Flowing());
        RABBIT_STEW_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "rabbit_stew_block"),
                new FluidBlock(ModFluidsRegister.STILL_RABBIT_STEW, FabricBlockSettings.copyOf(Blocks.WATER)));
        RABBIT_STEW_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "rabbit_stew_bucket"),
                new BucketItem(ModFluidsRegister.STILL_RABBIT_STEW, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_MUSHROOM_STEW = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "mushroom_stew"), new MushroomStewFluid.Still());
        FLOWING_MUSHROOM_STEW = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_mushroom_stew"), new MushroomStewFluid.Flowing());
        MUSHROOM_STEW_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "mushroom_stew_block"),
                new FluidBlock(ModFluidsRegister.STILL_MUSHROOM_STEW, FabricBlockSettings.copyOf(Blocks.WATER)));
        MUSHROOM_STEW_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "mushroom_stew_bucket"),
                new BucketItem(ModFluidsRegister.STILL_MUSHROOM_STEW, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_GLOW_BERRY_CUSTARD = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "glow_berry_custard"), new GlowBerryCustardFluid.Still());
        FLOWING_GLOW_BERRY_CUSTARD = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_glow_berry_custard"), new GlowBerryCustardFluid.Flowing());
        GLOW_BERRY_CUSTARD_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "glow_berry_custard_block"),
                new FluidBlock(ModFluidsRegister.STILL_GLOW_BERRY_CUSTARD, FabricBlockSettings.copyOf(Blocks.WATER)));
        GLOW_BERRY_CUSTARD_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "glow_berry_custard_bucket"),
                new BucketItem(ModFluidsRegister.STILL_GLOW_BERRY_CUSTARD, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_SWEET_BERRY_STUFFING = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "sweet_berry_stuffing"), new SweetBerryStuffingFluid.Still());
        FLOWING_SWEET_BERRY_STUFFING = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_sweet_berry_stuffing"), new SweetBerryStuffingFluid.Flowing());
        SWEET_BERRY_STUFFING_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "sweet_berry_stuffing_block"),
                new FluidBlock(ModFluidsRegister.STILL_SWEET_BERRY_STUFFING, FabricBlockSettings.copyOf(Blocks.WATER)));
        SWEET_BERRY_STUFFING_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "sweet_berry_stuffing_bucket"),
                new BucketItem(ModFluidsRegister.STILL_SWEET_BERRY_STUFFING, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

    }
}
