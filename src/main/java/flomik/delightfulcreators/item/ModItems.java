package flomik.delightfulcreators.item;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item PASTA_WITH_MEATBALLS_BILLET = registerItem("pasta_with_meatballs_billet",
            new Item(new FabricItemSettings().group(ModItemsGroup.main)));
    public static final Item PASTA_WITH_MUTTON_CHOP_BILLET = registerItem("pasta_with_mutton_chop_billet",
            new Item(new FabricItemSettings().group(ModItemsGroup.main)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DelightfulCreatorsMod.LOGGER.debug("Registering Mod Items for " + DelightfulCreatorsMod.MOD_ID);
    }
}
