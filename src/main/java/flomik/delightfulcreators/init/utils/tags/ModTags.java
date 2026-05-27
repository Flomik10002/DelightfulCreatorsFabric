package flomik.delightfulcreators.init.utils.tags;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

public class ModTags {

    public static class ModBlockTags {
        public static @NotNull TagKey<Block> createBlockTag(String modBlockTagName) {
            return TagKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, modBlockTagName));
        }

        public static @NotNull TagKey<Block> createBlockFluidTag(String modBlockTagName) {
            return TagKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath("c", modBlockTagName));
        }
    }

    public static class ModItemTags {
        public static final TagKey<Item> KNIVES = createCommonItemTag("tools/knives");
        public static final TagKey<Item> BALE = createCommonItemTag("bale");
        public static final TagKey<Item> BONE_BROTH_INGREDIENTS = createCommonItemTag("bone_broth_ingredients");
        public static final TagKey<Item> DUMPLINGS_INGREDIENTS = createCommonItemTag("dumplings_ingredients");
        public static final TagKey<Item> MUSHROOM_RICE_INGREDIENTS = createCommonItemTag("mushroom_rice_ingredients");

        public static @NotNull TagKey<Item> createItemTag(String modItemTagName) {
            return TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, modItemTagName));
        }

        public static @NotNull TagKey<Item> createCommonItemTag(String modItemTagName) {
            return TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath("c", modItemTagName));
        }
    }

    public static class ModFluidTags {

        public static @NotNull TagKey<Fluid> createFluidTag(String modFluidTagName) {
            return TagKey.create(BuiltInRegistries.FLUID.key(), Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, modFluidTagName));
        }

        public static @NotNull TagKey<Fluid> createCommonFluidTag(String modFluidTagName) {
            return TagKey.create(BuiltInRegistries.FLUID.key(), Identifier.fromNamespaceAndPath("c", modFluidTagName));
        }
    }

    public static void registerModTags(){
        DelightfulCreatorsMod.LOGGER.debug("Registering Mod Tags for " + DelightfulCreatorsMod.MOD_ID);
    }
}