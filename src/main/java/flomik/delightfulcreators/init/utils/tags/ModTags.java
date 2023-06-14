package flomik.delightfulcreators.init.utils.tags;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;

public class ModTags {

    public static class ModBlockTags {
        public static @NotNull TagKey<Block> createBlockTag(String modFluidTagName) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(DelightfulCreatorsMod.MOD_ID, modFluidTagName));
        }

        public static @NotNull TagKey<Block> createBlockFluidTag(String modFluidTagName) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", modFluidTagName));
        }
    }

    public static class ModItemTags {
        public static @NotNull TagKey<Item> createItemTag(String modFluidTagName) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(DelightfulCreatorsMod.MOD_ID, modFluidTagName));
        }

        public static @NotNull TagKey<Item> createCommonItemTag(String modFluidTagName) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", modFluidTagName));
        }
    }

    public static class ModFluidTags {

        public static final TagKey<Fluid> TOMATO_SAUCE = createCommonFluidTag("tomato_sauce");
        public static final TagKey<Fluid> APPLE_CIDER = createCommonFluidTag("apple_cider");


        public static @NotNull TagKey<Fluid> createFluidTag(String modFluidTagName) {
            return TagKey.of(Registry.FLUID_KEY, new Identifier(DelightfulCreatorsMod.MOD_ID, modFluidTagName));
        }

        public static @NotNull TagKey<Fluid> createCommonFluidTag(String modFluidTagName) {
            return TagKey.of(Registry.FLUID_KEY, new Identifier("c", modFluidTagName));
        }
    }
}