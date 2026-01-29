package flomik.delightfulcreators.init;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.fluids.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public class ModFluidsRegister {
    public static FlowingFluid STILL_TOMATO_SAUCE, STILL_HOT_COCOA, STILL_MELON_JUICE, STILL_APPLE_CIDER, STILL_BEETROOT_SOUP, STILL_CHICKEN_SOUP, STILL_NOODLE_SOUP, STILL_PUMPKIN_SOUP, STILL_VEGETABLE_SOUP, STILL_FISH_STEW, STILL_BEEF_STEW, STILL_RABBIT_STEW, STILL_MUSHROOM_STEW, STILL_GLOW_BERRY_CUSTARD, STILL_COOKED_RICE, STILL_BONE_BROTH, STILL_BAKED_COD_STEW, STILL_RATATOUILLE, STILL_DOG_FOOD;
    public static FlowingFluid FLOWING_TOMATO_SAUCE, FLOWING_HOT_COCOA, FLOWING_MELON_JUICE, FLOWING_APPLE_CIDER, FLOWING_BEETROOT_SOUP, FLOWING_CHICKEN_SOUP, FLOWING_NOODLE_SOUP, FLOWING_PUMPKIN_SOUP, FLOWING_VEGETABLE_SOUP, FLOWING_FISH_STEW, FLOWING_BEEF_STEW, FLOWING_RABBIT_STEW, FLOWING_MUSHROOM_STEW, FLOWING_GLOW_BERRY_CUSTARD, FLOWING_COOKED_RICE, FLOWING_BONE_BROTH, FLOWING_BAKED_COD_STEW, FLOWING_RATATOUILLE, FLOWING_DOG_FOOD;
    public static Block TOMATO_SAUCE_BLOCK, HOT_COCOA_BLOCK, MELON_JUICE_BLOCK, APPLE_CIDER_BLOCK, BEETROOT_SOUP_BLOCK, CHICKEN_SOUP_BLOCK, NOODLE_SOUP_BLOCK, PUMPKIN_SOUP_BLOCK, VEGETABLE_SOUP_BLOCK, FISH_STEW_BLOCK, BEEF_STEW_BLOCK, RABBIT_STEW_BLOCK, MUSHROOM_STEW_BLOCK, GLOW_BERRY_CUSTARD_BLOCK, COOKED_RICE_BLOCK, BONE_BROTH_BLOCK, BAKED_COD_STEW_BLOCK, RATATOUILLE_BLOCK, DOG_FOOD_BLOCK;
    public static Item TOMATO_SAUCE_BUCKET, HOT_COCOA_BUCKET, MELON_JUICE_BUCKET, APPLE_CIDER_BUCKET, BEETROOT_SOUP_BUCKET, CHICKEN_SOUP_BUCKET, NOODLE_SOUP_BUCKET, PUMPKIN_SOUP_BUCKET, VEGETABLE_SOUP_BUCKET, FISH_STEW_BUCKET, BEEF_STEW_BUCKET, RABBIT_STEW_BUCKET, MUSHROOM_STEW_BUCKET, GLOW_BERRY_CUSTARD_BUCKET, COOKED_RICE_BUCKET, BONE_BROTH_BUCKET, BAKED_COD_STEW_BUCKET, RATATOUILLE_BUCKET, DOG_FOOD_BUCKET;


    public static boolean isAppleCider(FluidState state) {
        return state.is(ModFluidsRegister.STILL_APPLE_CIDER) || state.is(ModFluidsRegister.FLOWING_APPLE_CIDER);
    }

    public static boolean isMelonJuice(FluidState state) {
        return state.is(ModFluidsRegister.STILL_MELON_JUICE) || state.is(ModFluidsRegister.FLOWING_MELON_JUICE);
    }

    public static boolean isTomatoSauce(FluidState state) {
        return state.is(ModFluidsRegister.STILL_TOMATO_SAUCE) || state.is(ModFluidsRegister.FLOWING_TOMATO_SAUCE);
    }

    public static boolean isHotCocoa(FluidState state) {
        return state.is(ModFluidsRegister.STILL_HOT_COCOA) || state.is(ModFluidsRegister.FLOWING_HOT_COCOA);
    }

    public static boolean isBeetrootSoup(FluidState state) {
        return state.is(ModFluidsRegister.STILL_BEETROOT_SOUP) || state.is(ModFluidsRegister.FLOWING_BEETROOT_SOUP);
    }

    public static boolean isChickenSoup(FluidState state) {
        return state.is(ModFluidsRegister.STILL_CHICKEN_SOUP) || state.is(ModFluidsRegister.FLOWING_CHICKEN_SOUP);
    }

    public static boolean isNoodleSoup(FluidState state) {
        return state.is(ModFluidsRegister.STILL_NOODLE_SOUP) || state.is(ModFluidsRegister.FLOWING_NOODLE_SOUP);
    }

    public static boolean isPumpkinSoup(FluidState state) {
        return state.is(ModFluidsRegister.STILL_PUMPKIN_SOUP) || state.is(ModFluidsRegister.FLOWING_PUMPKIN_SOUP);
    }

    public static boolean isVegetableSoup(FluidState state) {
        return state.is(ModFluidsRegister.STILL_VEGETABLE_SOUP) || state.is(ModFluidsRegister.FLOWING_VEGETABLE_SOUP);
    }

    public static boolean isFishStew(FluidState state) {
        return state.is(ModFluidsRegister.STILL_FISH_STEW) || state.is(ModFluidsRegister.FLOWING_FISH_STEW);
    }

    public static boolean isBeefStew(FluidState state) {
        return state.is(ModFluidsRegister.STILL_BEEF_STEW) || state.is(ModFluidsRegister.FLOWING_BEEF_STEW);
    }

    public static boolean isRabbitStew(FluidState state) {
        return state.is(ModFluidsRegister.STILL_RABBIT_STEW) || state.is(ModFluidsRegister.FLOWING_RABBIT_STEW);
    }

    public static boolean isMushroomStew(FluidState state) {
        return state.is(ModFluidsRegister.STILL_MUSHROOM_STEW) || state.is(ModFluidsRegister.FLOWING_MUSHROOM_STEW);
    }

    public static boolean isGlowBerryCustard(FluidState state) {
        return state.is(ModFluidsRegister.STILL_GLOW_BERRY_CUSTARD) || state.is(ModFluidsRegister.FLOWING_GLOW_BERRY_CUSTARD);
    }

    public static boolean isBoneBroth(FluidState state) {
        return state.is(ModFluidsRegister.STILL_BONE_BROTH) || state.is(ModFluidsRegister.FLOWING_BONE_BROTH);
    }

    public static boolean isCookedRice(FluidState state) {
        return state.is(ModFluidsRegister.STILL_COOKED_RICE) || state.is(ModFluidsRegister.FLOWING_COOKED_RICE);
    }

    public static boolean isBakedCodStew(FluidState state) {
        return state.is(ModFluidsRegister.STILL_BAKED_COD_STEW) || state.is(ModFluidsRegister.FLOWING_BAKED_COD_STEW);
    }

    public static boolean isRatatouille(FluidState state) {
        return state.is(ModFluidsRegister.STILL_RATATOUILLE) || state.is(ModFluidsRegister.FLOWING_RATATOUILLE);
    }

    public static boolean isDogFood(FluidState state) {
        return state.is(ModFluidsRegister.STILL_DOG_FOOD) || state.is(ModFluidsRegister.FLOWING_DOG_FOOD);
    }


    public static void register() {
        STILL_TOMATO_SAUCE = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "tomato_sauce"), new TomatoSauceFluid.Still());
        FLOWING_TOMATO_SAUCE = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_tomato_sauce"), new TomatoSauceFluid.Flowing());
        TOMATO_SAUCE_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "tomato_sauce_block"), ModFluidsRegister.STILL_TOMATO_SAUCE);
        TOMATO_SAUCE_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "tomato_sauce_bucket"), ModFluidsRegister.STILL_TOMATO_SAUCE);


        STILL_HOT_COCOA = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "hot_cocoa"), new HotCocoaFluid.Still());
        FLOWING_HOT_COCOA = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_hot_cocoa"), new HotCocoaFluid.Flowing());
        HOT_COCOA_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "hot_cocoa_block"), ModFluidsRegister.STILL_HOT_COCOA);
        HOT_COCOA_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "hot_cocoa_bucket"), ModFluidsRegister.STILL_HOT_COCOA);

        STILL_MELON_JUICE = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "melon_juice"), new MelonJuiceFluid.Still());
        FLOWING_MELON_JUICE = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_melon_juice"), new MelonJuiceFluid.Flowing());
        MELON_JUICE_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "melon_juice_block"), ModFluidsRegister.STILL_MELON_JUICE);
        MELON_JUICE_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "melon_juice_bucket"), ModFluidsRegister.STILL_MELON_JUICE);

        STILL_APPLE_CIDER = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "apple_cider"), new AppleCiderFluid.Still());
        FLOWING_APPLE_CIDER = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_apple_cider"), new AppleCiderFluid.Flowing());
        APPLE_CIDER_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "apple_cider_block"), ModFluidsRegister.STILL_APPLE_CIDER);
        APPLE_CIDER_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "apple_cider_bucket"), ModFluidsRegister.STILL_APPLE_CIDER);

        STILL_BEETROOT_SOUP = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "beetroot_soup"), new BeetrootSoupFluid.Still());
        FLOWING_BEETROOT_SOUP = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_beetroot_soup"), new BeetrootSoupFluid.Flowing());
        BEETROOT_SOUP_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "beetroot_soup_block"), ModFluidsRegister.STILL_BEETROOT_SOUP);
        BEETROOT_SOUP_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "beetroot_soup_bucket"), ModFluidsRegister.STILL_BEETROOT_SOUP);

        STILL_CHICKEN_SOUP = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "chicken_soup"), new ChickenSoupFluid.Still());
        FLOWING_CHICKEN_SOUP = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_chicken_soup"), new ChickenSoupFluid.Flowing());
        CHICKEN_SOUP_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "chicken_soup_block"), ModFluidsRegister.STILL_CHICKEN_SOUP);
        CHICKEN_SOUP_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "chicken_soup_bucket"), ModFluidsRegister.STILL_CHICKEN_SOUP);

        STILL_NOODLE_SOUP = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "noodle_soup"), new NoodleSoupFluid.Still());
        FLOWING_NOODLE_SOUP = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_noodle_soup"), new NoodleSoupFluid.Flowing());
        NOODLE_SOUP_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "noodle_soup_block"), ModFluidsRegister.STILL_NOODLE_SOUP);
        NOODLE_SOUP_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "noodle_soup_bucket"), ModFluidsRegister.STILL_NOODLE_SOUP);

        STILL_PUMPKIN_SOUP = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "pumpkin_soup"), new PumpkinSoupFluid.Still());
        FLOWING_PUMPKIN_SOUP = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_pumpkin_soup"), new PumpkinSoupFluid.Flowing());
        PUMPKIN_SOUP_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "pumpkin_soup_block"), ModFluidsRegister.STILL_PUMPKIN_SOUP);
        PUMPKIN_SOUP_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "pumpkin_soup_bucket"), ModFluidsRegister.STILL_PUMPKIN_SOUP);

        STILL_VEGETABLE_SOUP = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "vegetable_soup"), new VegetableSoupFluid.Still());
        FLOWING_VEGETABLE_SOUP = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_vegetable_soup"), new VegetableSoupFluid.Flowing());
        VEGETABLE_SOUP_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "vegetable_soup_block"), ModFluidsRegister.STILL_VEGETABLE_SOUP);
        VEGETABLE_SOUP_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "vegetable_soup_bucket"), ModFluidsRegister.STILL_VEGETABLE_SOUP);

        STILL_FISH_STEW = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "fish_stew"), new FishStewFluid.Still());
        FLOWING_FISH_STEW = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_fish_stew"), new FishStewFluid.Flowing());
        FISH_STEW_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "fish_stew_block"), ModFluidsRegister.STILL_FISH_STEW);
        FISH_STEW_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "fish_stew_bucket"), ModFluidsRegister.STILL_FISH_STEW);

        STILL_BEEF_STEW = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "beef_stew"), new BeefStewFluid.Still());
        FLOWING_BEEF_STEW = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_beef_stew"), new BeefStewFluid.Flowing());
        BEEF_STEW_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "beef_stew_block"), ModFluidsRegister.STILL_BEEF_STEW);
        BEEF_STEW_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "beef_stew_bucket"), ModFluidsRegister.STILL_BEEF_STEW);

        STILL_RABBIT_STEW = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "rabbit_stew"), new RabbitStewFluid.Still());
        FLOWING_RABBIT_STEW = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_rabbit_stew"), new RabbitStewFluid.Flowing());
        RABBIT_STEW_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "rabbit_stew_block"), ModFluidsRegister.STILL_RABBIT_STEW);
        RABBIT_STEW_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "rabbit_stew_bucket"), ModFluidsRegister.STILL_RABBIT_STEW);

        STILL_MUSHROOM_STEW = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "mushroom_stew"), new MushroomStewFluid.Still());
        FLOWING_MUSHROOM_STEW = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_mushroom_stew"), new MushroomStewFluid.Flowing());
        MUSHROOM_STEW_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "mushroom_stew_block"), ModFluidsRegister.STILL_MUSHROOM_STEW);
        MUSHROOM_STEW_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "mushroom_stew_bucket"), ModFluidsRegister.STILL_MUSHROOM_STEW);

        STILL_GLOW_BERRY_CUSTARD = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "glow_berry_custard"), new GlowBerryCustardFluid.Still());
        FLOWING_GLOW_BERRY_CUSTARD = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_glow_berry_custard"), new GlowBerryCustardFluid.Flowing());
        GLOW_BERRY_CUSTARD_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "glow_berry_custard_block"), ModFluidsRegister.STILL_GLOW_BERRY_CUSTARD);
        GLOW_BERRY_CUSTARD_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "glow_berry_custard_bucket"), ModFluidsRegister.STILL_GLOW_BERRY_CUSTARD);

        STILL_COOKED_RICE = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "cooked_rice"), new CookedRiceFluid.Still());
        FLOWING_COOKED_RICE = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_cooked_rice"), new CookedRiceFluid.Flowing());
        COOKED_RICE_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "cooked_rice_block"), ModFluidsRegister.STILL_COOKED_RICE);
        COOKED_RICE_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "cooked_rice_bucket"), ModFluidsRegister.STILL_COOKED_RICE);

        STILL_BONE_BROTH = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "bone_broth"), new BoneBrothFluid.Still());
        FLOWING_BONE_BROTH = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_bone_broth"), new BoneBrothFluid.Flowing());
        BONE_BROTH_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "bone_broth_block"), ModFluidsRegister.STILL_BONE_BROTH);
        BONE_BROTH_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "bone_broth_bucket"), ModFluidsRegister.STILL_BONE_BROTH);

        STILL_BAKED_COD_STEW = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "baked_cod_stew"), new BakedCodStewFluid.Still());
        FLOWING_BAKED_COD_STEW = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_baked_cod_stew"), new BakedCodStewFluid.Flowing());
        BAKED_COD_STEW_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "baked_cod_stew_block"), ModFluidsRegister.STILL_BAKED_COD_STEW);
        BAKED_COD_STEW_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "baked_cod_stew_bucket"), ModFluidsRegister.STILL_BAKED_COD_STEW);

        STILL_RATATOUILLE = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "ratatouille"), new RatatouilleFluid.Still());
        FLOWING_RATATOUILLE = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_ratatouille"), new RatatouilleFluid.Flowing());
        RATATOUILLE_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "ratatouille_block"), ModFluidsRegister.STILL_RATATOUILLE);
        RATATOUILLE_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "ratatouille_bucket"), ModFluidsRegister.STILL_RATATOUILLE);

        STILL_DOG_FOOD = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "dog_food"), new DogFoodFluid.Still());
        FLOWING_DOG_FOOD = Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "flowing_dog_food"), new DogFoodFluid.Flowing());
        DOG_FOOD_BLOCK = registerFlowableFluidBlock(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "dog_food_block"), ModFluidsRegister.STILL_DOG_FOOD);
        DOG_FOOD_BUCKET = registerFluidBucket(Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "dog_food_bucket"), ModFluidsRegister.STILL_DOG_FOOD);
    }

    private static Block registerFlowableFluidBlock(Identifier id, FlowingFluid fluid) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id);
        return Registry.register(BuiltInRegistries.BLOCK, id,
                new LiquidBlock(fluid, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).replaceable().setId(key)));
    }

    private static Item registerFluidBucket(Identifier id, Fluid fluid) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        return Registry.register(BuiltInRegistries.ITEM, id,
                new BucketItem(fluid, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).setId(key)));
    }

    public static void registerModFluids() {
        DelightfulCreatorsMod.LOGGER.debug("Registering Mod Fluids for " + DelightfulCreatorsMod.MOD_ID);
    }
}
