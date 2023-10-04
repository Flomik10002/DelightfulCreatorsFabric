package flomik.delightfulcreators.init.utils.tags;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class ModTags {

    public static class ModBlockTags {
        public static @NotNull TagKey<Block> createBlockTag(String modFluidTagName) {
            return TagKey.of(Registries.BLOCK.getKey(), new Identifier(DelightfulCreatorsMod.MOD_ID, modFluidTagName));
        }

        public static @NotNull TagKey<Block> createBlockFluidTag(String modFluidTagName) {
            return TagKey.of(Registries.BLOCK.getKey(), new Identifier("c", modFluidTagName));
        }
    }

    public static class ModItemTags {
        public static final TagKey<Item> KNIVES = createCommonItemTag("tools/knives");
        public static final TagKey<Item> BALE = createCommonItemTag("bale");

        public static @NotNull TagKey<Item> createItemTag(String modFluidTagName) {
            return TagKey.of(Registries.ITEM.getKey(), new Identifier(DelightfulCreatorsMod.MOD_ID, modFluidTagName));
        }

        public static @NotNull TagKey<Item> createCommonItemTag(String modFluidTagName) {
            return TagKey.of(Registries.ITEM.getKey(), new Identifier("c", modFluidTagName));
        }
    }

    public static class ModFluidTags {

        public static @NotNull TagKey<Fluid> createFluidTag(String modFluidTagName) {
            return TagKey.of(Registries.FLUID.getKey(), new Identifier(DelightfulCreatorsMod.MOD_ID, modFluidTagName));
        }

        public static @NotNull TagKey<Fluid> createCommonFluidTag(String modFluidTagName) {
            return TagKey.of(Registries.FLUID.getKey(), new Identifier("c", modFluidTagName));
        }
    }

    public static void registerModTags(){
        DelightfulCreatorsMod.LOGGER.debug("Registering Mod Tags for " + DelightfulCreatorsMod.MOD_ID);
    }
}