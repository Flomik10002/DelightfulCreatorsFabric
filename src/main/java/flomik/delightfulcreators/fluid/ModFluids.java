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

public class ModFluids {

    public static FlowableFluid STILL_TOMATO_SAUCE;
    public static FlowableFluid FLOWING_TOMATO_SAUCE;
    public static Block TOMATO_SAUCE_BLOCK;
    public static Item TOMATO_SAUCE_BUCKET;

    public static void register() {
        STILL_TOMATO_SAUCE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "tomato_sauce"), new TomatoSauceFluid.Still());
        FLOWING_TOMATO_SAUCE = Registry.register(Registry.FLUID,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "flowing_tomato_sauce"), new TomatoSauceFluid.Flowing());

        TOMATO_SAUCE_BLOCK = Registry.register(Registry.BLOCK, new Identifier(DelightfulCreatorsMod.MOD_ID, "tomato_sauce_block"),
                new FluidBlock(ModFluids.STILL_TOMATO_SAUCE, FabricBlockSettings.copyOf(Blocks.WATER)));
        TOMATO_SAUCE_BUCKET = Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, "tomato_sauce_bucket"),
                new BucketItem(ModFluids.STILL_TOMATO_SAUCE, new FabricItemSettings().group(ModItemsGroup.delightfulcreators).recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
