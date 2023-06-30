package flomik.delightfulcreators.init;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.fluids.farmersdelightfluids.*;
import flomik.delightfulcreators.fluids.farmersrespite.*;
import flomik.delightfulcreators.item.ModItemsGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluidsRegister {
    public static FlowableFluid STILL_TOMATO_SAUCE, STILL_HOT_COCOA, STILL_MELON_JUICE, STILL_APPLE_CIDER, STILL_BEETROOT_SOUP, STILL_CHICKEN_SOUP, STILL_NOODLE_SOUP, STILL_PUMPKIN_SOUP, STILL_VEGETABLE_SOUP, STILL_FISH_STEW, STILL_BEEF_STEW, STILL_RABBIT_STEW, STILL_MUSHROOM_STEW, STILL_GLOW_BERRY_CUSTARD, STILL_PURULENT_TEA, STILL_DANDELION_TEA, STILL_ROSE_HIP_TEA, STILL_BLACK_TEA, STILL_YELLOW_TEA, STILL_GREEN_TEA, STILL_COFFEE, STILL_LONG_DANDELION_TEA, STILL_LONG_BLACK_TEA, STILL_LONG_YELLOW_TEA, STILL_LONG_GREEN_TEA, STILL_LONG_COFFEE, STILL_STRONG_PURULENT_TEA, STILL_STRONG_ROSE_HIP_TEA, STILL_STRONG_BLACK_TEA, STILL_STRONG_YELLOW_TEA, STILL_STRONG_GREEN_TEA, STILL_STRONG_COFFEE, STILL_ROSE_HIP_JAM;
    public static FlowableFluid FLOWING_TOMATO_SAUCE, FLOWING_HOT_COCOA, FLOWING_MELON_JUICE, FLOWING_APPLE_CIDER, FLOWING_BEETROOT_SOUP, FLOWING_CHICKEN_SOUP, FLOWING_NOODLE_SOUP, FLOWING_PUMPKIN_SOUP, FLOWING_VEGETABLE_SOUP, FLOWING_FISH_STEW, FLOWING_BEEF_STEW, FLOWING_RABBIT_STEW, FLOWING_MUSHROOM_STEW, FLOWING_GLOW_BERRY_CUSTARD, FLOWING_PURULENT_TEA, FLOWING_DANDELION_TEA, FLOWING_ROSE_HIP_TEA, FLOWING_BLACK_TEA, FLOWING_YELLOW_TEA, FLOWING_GREEN_TEA, FLOWING_COFFEE, FLOWING_LONG_DANDELION_TEA, FLOWING_LONG_BLACK_TEA, FLOWING_LONG_YELLOW_TEA, FLOWING_LONG_GREEN_TEA, FLOWING_LONG_COFFEE, FLOWING_STRONG_PURULENT_TEA, FLOWING_STRONG_ROSE_HIP_TEA, FLOWING_STRONG_BLACK_TEA, FLOWING_STRONG_YELLOW_TEA, FLOWING_STRONG_GREEN_TEA, FLOWING_STRONG_COFFEE, FLOWING_ROSE_HIP_JAM;
    public static Block TOMATO_SAUCE_BLOCK, HOT_COCOA_BLOCK, MELON_JUICE_BLOCK, APPLE_CIDER_BLOCK, BEETROOT_SOUP_BLOCK, CHICKEN_SOUP_BLOCK, NOODLE_SOUP_BLOCK, PUMPKIN_SOUP_BLOCK, VEGETABLE_SOUP_BLOCK, FISH_STEW_BLOCK, BEEF_STEW_BLOCK, RABBIT_STEW_BLOCK, MUSHROOM_STEW_BLOCK, GLOW_BERRY_CUSTARD_BLOCK, PURULENT_TEA_BLOCK, DANDELION_TEA_BLOCK, ROSE_HIP_TEA_BLOCK, BLACK_TEA_BLOCK, YELLOW_TEA_BLOCK, GREEN_TEA_BLOCK, COFFEE_BLOCK, LONG_DANDELION_TEA_BLOCK, LONG_BLACK_TEA_BLOCK, LONG_YELLOW_TEA_BLOCK, LONG_GREEN_TEA_BLOCK, LONG_COFFEE_BLOCK, STRONG_PURULENT_TEA_BLOCK, STRONG_ROSE_HIP_TEA_BLOCK, STRONG_BLACK_TEA_BLOCK, STRONG_YELLOW_TEA_BLOCK, STRONG_GREEN_TEA_BLOCK, STRONG_COFFEE_BLOCK, ROSE_HIP_JAM_BLOCK;
    public static Item TOMATO_SAUCE_BUCKET, HOT_COCOA_BUCKET, MELON_JUICE_BUCKET, APPLE_CIDER_BUCKET, BEETROOT_SOUP_BUCKET, CHICKEN_SOUP_BUCKET, NOODLE_SOUP_BUCKET, PUMPKIN_SOUP_BUCKET, VEGETABLE_SOUP_BUCKET, FISH_STEW_BUCKET, BEEF_STEW_BUCKET, RABBIT_STEW_BUCKET, MUSHROOM_STEW_BUCKET, GLOW_BERRY_CUSTARD_BUCKET, PURULENT_TEA_BUCKET, DANDELION_TEA_BUCKET, ROSE_HIP_TEA_BUCKET, BLACK_TEA_BUCKET, YELLOW_TEA_BUCKET, GREEN_TEA_BUCKET, COFFEE_BUCKET, LONG_DANDELION_TEA_BUCKET, LONG_BLACK_TEA_BUCKET, LONG_YELLOW_TEA_BUCKET, LONG_GREEN_TEA_BUCKET, LONG_COFFEE_BUCKET, STRONG_PURULENT_TEA_BUCKET, STRONG_ROSE_HIP_TEA_BUCKET, STRONG_BLACK_TEA_BUCKET, STRONG_YELLOW_TEA_BUCKET, STRONG_GREEN_TEA_BUCKET, STRONG_COFFEE_BUCKET, ROSE_HIP_JAM_BUCKET;


    public static boolean isAppleCider(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_APPLE_CIDER) || state.isOf(ModFluidsRegister.FLOWING_APPLE_CIDER);
    }

    public static boolean isMelonJuice(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_MELON_JUICE) || state.isOf(ModFluidsRegister.FLOWING_MELON_JUICE);
    }
    public static boolean isTomatoSauce(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_TOMATO_SAUCE) || state.isOf(ModFluidsRegister.FLOWING_TOMATO_SAUCE);
    }

    public static boolean isHotCocoa(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_HOT_COCOA) || state.isOf(ModFluidsRegister.FLOWING_HOT_COCOA);
    }

    public static boolean isBeetrootSoup(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_BEETROOT_SOUP) || state.isOf(ModFluidsRegister.FLOWING_BEETROOT_SOUP);
    }

    public static boolean isChickenSoup(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_CHICKEN_SOUP) || state.isOf(ModFluidsRegister.FLOWING_CHICKEN_SOUP);
    }

    public static boolean isNoodleSoup(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_NOODLE_SOUP) || state.isOf(ModFluidsRegister.FLOWING_NOODLE_SOUP);
    }

    public static boolean isPumpkinSoup(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_PUMPKIN_SOUP) || state.isOf(ModFluidsRegister.FLOWING_PUMPKIN_SOUP);
    }

    public static boolean isVegetableSoup(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_VEGETABLE_SOUP) || state.isOf(ModFluidsRegister.FLOWING_VEGETABLE_SOUP);
    }

    public static boolean isFishStew(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_FISH_STEW) || state.isOf(ModFluidsRegister.FLOWING_FISH_STEW);
    }

    public static boolean isBeefStew(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_BEEF_STEW) || state.isOf(ModFluidsRegister.FLOWING_BEEF_STEW);
    }

    public static boolean isRabbitStew(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_RABBIT_STEW) || state.isOf(ModFluidsRegister.FLOWING_RABBIT_STEW);
    }

    public static boolean isMushroomStew(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_MUSHROOM_STEW) || state.isOf(ModFluidsRegister.FLOWING_MUSHROOM_STEW);
    }

    public static boolean isGlowBerryCustard(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_GLOW_BERRY_CUSTARD) || state.isOf(ModFluidsRegister.FLOWING_GLOW_BERRY_CUSTARD);
    }

    public static boolean isCoffee(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_COFFEE) || state.isOf(ModFluidsRegister.FLOWING_COFFEE);
    }

    public static boolean isPurulentTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_PURULENT_TEA) || state.isOf(ModFluidsRegister.FLOWING_PURULENT_TEA);
    }

    public static boolean isDandelionTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_DANDELION_TEA) || state.isOf(ModFluidsRegister.FLOWING_DANDELION_TEA);
    }

    public static boolean isRoseHipTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_ROSE_HIP_TEA) || state.isOf(ModFluidsRegister.FLOWING_ROSE_HIP_TEA);
    }

    public static boolean isBlackTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_BLACK_TEA) || state.isOf(ModFluidsRegister.FLOWING_BLACK_TEA);
    }

    public static boolean isYellowTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_YELLOW_TEA) || state.isOf(ModFluidsRegister.FLOWING_YELLOW_TEA);
    }

    public static boolean isGreenTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_GREEN_TEA) || state.isOf(ModFluidsRegister.FLOWING_GREEN_TEA);
    }
    public static boolean isLongCoffee(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_LONG_COFFEE) || state.isOf(ModFluidsRegister.FLOWING_LONG_COFFEE);
    }

    public static boolean isLongDandelionTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_LONG_DANDELION_TEA) || state.isOf(ModFluidsRegister.FLOWING_LONG_DANDELION_TEA);
    }

    public static boolean isLongBlackTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_LONG_BLACK_TEA) || state.isOf(ModFluidsRegister.FLOWING_LONG_BLACK_TEA);
    }

    public static boolean isLongYellowTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_LONG_YELLOW_TEA) || state.isOf(ModFluidsRegister.FLOWING_LONG_YELLOW_TEA);
    }

    public static boolean isLongGreenTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_LONG_GREEN_TEA) || state.isOf(ModFluidsRegister.FLOWING_LONG_GREEN_TEA);
    }

    public static boolean isStrongCoffee(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_STRONG_COFFEE) || state.isOf(ModFluidsRegister.FLOWING_STRONG_COFFEE);
    }

    public static boolean isStrongPurulentTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_STRONG_PURULENT_TEA) || state.isOf(ModFluidsRegister.FLOWING_STRONG_PURULENT_TEA);
    }

    public static boolean isStrongRoseHipTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_STRONG_ROSE_HIP_TEA) || state.isOf(ModFluidsRegister.FLOWING_STRONG_ROSE_HIP_TEA);
    }

    public static boolean isStrongBlackTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_STRONG_BLACK_TEA) || state.isOf(ModFluidsRegister.FLOWING_STRONG_BLACK_TEA);
    }

    public static boolean isStrongYellowTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_STRONG_YELLOW_TEA) || state.isOf(ModFluidsRegister.FLOWING_STRONG_YELLOW_TEA);
    }

    public static boolean isStrongGreenTea(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_STRONG_GREEN_TEA) || state.isOf(ModFluidsRegister.FLOWING_STRONG_GREEN_TEA);
    }

    public static boolean isRoseHipJam(FluidState state) {
        return state.isOf(ModFluidsRegister.STILL_ROSE_HIP_JAM) || state.isOf(ModFluidsRegister.FLOWING_ROSE_HIP_JAM);
    }


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

        STILL_PURULENT_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "purulent_tea"), new PurulentTeaFluid.Still());
        FLOWING_PURULENT_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_purulent_tea"), new PurulentTeaFluid.Flowing());
        PURULENT_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "purulent_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_PURULENT_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        PURULENT_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "purulent_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_PURULENT_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_DANDELION_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "dandelion_tea"), new DandelionTeaFluid.Still());
        FLOWING_DANDELION_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_dandelion_tea"), new DandelionTeaFluid.Flowing());
        DANDELION_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "dandelion_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_DANDELION_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        DANDELION_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "dandelion_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_DANDELION_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_ROSE_HIP_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "rose_hip_tea"), new RoseHipTeaFluid.Still());
        FLOWING_ROSE_HIP_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_rose_hip_tea"), new RoseHipTeaFluid.Flowing());
        ROSE_HIP_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "rose_hip_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_ROSE_HIP_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        ROSE_HIP_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "rose_hip_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_ROSE_HIP_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_BLACK_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "black_tea"), new BlackTeaFluid.Still());
        FLOWING_BLACK_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_black_tea"), new BlackTeaFluid.Flowing());
        BLACK_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "black_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_BLACK_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        BLACK_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "black_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_BLACK_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_YELLOW_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "yellow_tea"), new YellowTeaFluid.Still());
        FLOWING_YELLOW_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_yellow_tea"), new YellowTeaFluid.Flowing());
        YELLOW_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "yellow_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_YELLOW_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        YELLOW_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "yellow_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_YELLOW_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_GREEN_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "green_tea"), new GreenTeaFluid.Still());
        FLOWING_GREEN_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_green_tea"), new GreenTeaFluid.Flowing());
        GREEN_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "green_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_GREEN_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        GREEN_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "green_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_GREEN_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_COFFEE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "coffee"), new CoffeeFluid.Still());
        FLOWING_COFFEE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_coffee"), new CoffeeFluid.Flowing());
        COFFEE_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "coffee_block"),
                new FluidBlock(ModFluidsRegister.STILL_COFFEE, FabricBlockSettings.copyOf(Blocks.WATER)));
        COFFEE_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "coffee_bucket"),
                new BucketItem(ModFluidsRegister.STILL_COFFEE, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_LONG_DANDELION_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "long_dandelion_tea"), new LongDandelionTeaFluid.Still());
        FLOWING_LONG_DANDELION_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_long_dandelion_tea"), new LongDandelionTeaFluid.Flowing());
        LONG_DANDELION_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "long_dandelion_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_DANDELION_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        LONG_DANDELION_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "long_dandelion_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_DANDELION_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_LONG_BLACK_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "long_black_tea"), new LongBlackTeaFluid.Still());
        FLOWING_LONG_BLACK_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_long_black_tea"), new LongBlackTeaFluid.Flowing());
        LONG_BLACK_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "long_black_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_LONG_BLACK_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        LONG_BLACK_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "long_black_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_LONG_BLACK_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_LONG_YELLOW_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "long_yellow_tea"), new LongYellowTeaFluid.Still());
        FLOWING_LONG_YELLOW_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_long_yellow_tea"), new LongYellowTeaFluid.Flowing());
        LONG_YELLOW_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "long_yellow_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_LONG_YELLOW_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        LONG_YELLOW_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "long_yellow_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_LONG_YELLOW_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_LONG_GREEN_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "long_green_tea"), new LongGreenTeaFluid.Still());
        FLOWING_LONG_GREEN_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_long_green_tea"), new LongGreenTeaFluid.Flowing());
        LONG_GREEN_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "long_green_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_LONG_GREEN_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        LONG_GREEN_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "long_green_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_LONG_GREEN_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_LONG_COFFEE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "long_coffee"), new LongCoffeeFluid.Still());
        FLOWING_LONG_COFFEE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_long_coffee"), new LongCoffeeFluid.Flowing());
        LONG_COFFEE_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "long_coffee_block"),
                new FluidBlock(ModFluidsRegister.STILL_LONG_COFFEE, FabricBlockSettings.copyOf(Blocks.WATER)));
        LONG_COFFEE_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "long_coffee_bucket"),
                new BucketItem(ModFluidsRegister.STILL_LONG_COFFEE, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_STRONG_PURULENT_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_purulent_tea"), new StrongPurulentTeaFluid.Still());
        FLOWING_STRONG_PURULENT_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_strong_purulent_tea"), new StrongPurulentTeaFluid.Flowing());
        STRONG_PURULENT_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_purulent_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_STRONG_PURULENT_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        STRONG_PURULENT_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_purulent_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_STRONG_PURULENT_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_STRONG_ROSE_HIP_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_rose_hip_tea"), new StrongRoseHipTeaFluid.Still());
        FLOWING_STRONG_ROSE_HIP_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_strong_rose_hip_tea"), new StrongRoseHipTeaFluid.Flowing());
        STRONG_ROSE_HIP_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_rose_hip_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_STRONG_ROSE_HIP_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        STRONG_ROSE_HIP_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_rose_hip_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_STRONG_ROSE_HIP_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_STRONG_BLACK_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_black_tea"), new StrongBlackTeaFluid.Still());
        FLOWING_STRONG_BLACK_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_strong_black_tea"), new StrongBlackTeaFluid.Flowing());
        STRONG_BLACK_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_black_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_STRONG_BLACK_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        STRONG_BLACK_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_black_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_STRONG_BLACK_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_STRONG_YELLOW_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_yellow_tea"), new StrongYellowTeaFluid.Still());
        FLOWING_STRONG_YELLOW_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_strong_yellow_tea"), new StrongYellowTeaFluid.Flowing());
        STRONG_YELLOW_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_yellow_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_STRONG_YELLOW_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        STRONG_YELLOW_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_yellow_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_STRONG_YELLOW_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_STRONG_GREEN_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_green_tea"), new StrongGreenTeaFluid.Still());
        FLOWING_STRONG_GREEN_TEA = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_strong_green_tea"), new StrongGreenTeaFluid.Flowing());
        STRONG_GREEN_TEA_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_green_tea_block"),
                new FluidBlock(ModFluidsRegister.STILL_STRONG_GREEN_TEA, FabricBlockSettings.copyOf(Blocks.WATER)));
        STRONG_GREEN_TEA_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_green_tea_bucket"),
                new BucketItem(ModFluidsRegister.STILL_STRONG_GREEN_TEA, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_STRONG_COFFEE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_coffee"), new StrongCoffeeFluid.Still());
        FLOWING_STRONG_COFFEE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_strong_coffee"), new StrongCoffeeFluid.Flowing());
        STRONG_COFFEE_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_coffee_block"),
                new FluidBlock(ModFluidsRegister.STILL_STRONG_COFFEE, FabricBlockSettings.copyOf(Blocks.WATER)));
        STRONG_COFFEE_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "strong_coffee_bucket"),
                new BucketItem(ModFluidsRegister.STILL_STRONG_COFFEE, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));

        STILL_ROSE_HIP_JAM = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "rose_hip_jam"), new RoseHipJamFluid.Still());
        FLOWING_ROSE_HIP_JAM = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_rose_hip_jam"), new RoseHipJamFluid.Flowing());
        ROSE_HIP_JAM_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "rose_hip_jam_block"),
                new FluidBlock(ModFluidsRegister.STILL_ROSE_HIP_JAM, FabricBlockSettings.copyOf(Blocks.WATER)));
        ROSE_HIP_JAM_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "rose_hip_jam_bucket"),
                new BucketItem(ModFluidsRegister.STILL_ROSE_HIP_JAM, new FabricItemSettings().group(ModItemsGroup.main).recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}