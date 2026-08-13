package flomik.delightfulcreators.item;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.init.ModItemsRegister;
import flomik.delightfulcreators.init.ModBlocksRegister;
import flomik.delightfulcreators.init.ModFluidsRegister;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemsGroup {
    public static final CreativeModeTab MAIN = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "main"),
            FabricItemGroup.builder().title(Component.translatable("itemgroup.main"))
                    .icon(() -> new ItemStack(ModBlocksRegister.MECHANICAL_CUTTER)).displayItems((displayContext, entries) -> {
                        entries.accept(ModBlocksRegister.MECHANICAL_CUTTER);
                        entries.accept(ModItemsRegister.INCOMPLETE_DUMPLINGS);
                        entries.accept(ModItemsRegister.INCOMPLETE_FRIED_RICE);
                        entries.accept(ModItemsRegister.INCOMPLETE_MUSHROOM_RICE);
                        entries.accept(ModItemsRegister.INCOMPLETE_SQUID_INK_PASTA);
                        entries.accept(ModItemsRegister.INCOMPLETE_VEGETABLE_NOODLES);
                        entries.accept(ModItemsRegister.INCOMPLETE_PASTA_DISH);
                        entries.accept(ModItemsRegister.INCOMPLETE_PASTA_WITH_MEATBALLS);
                        entries.accept(ModItemsRegister.INCOMPLETE_PASTA_WITH_MUTTON_CHOP);
                        entries.accept(ModItemsRegister.INCOMPLETE_EGG_SANDWICH);
                        entries.accept(ModItemsRegister.INCOMPLETE_CHICKEN_SANDWICH);
                        entries.accept(ModItemsRegister.INCOMPLETE_HAMBURGER);
                        entries.accept(ModItemsRegister.INCOMPLETE_BACON_SANDWICH);
                        entries.accept(ModItemsRegister.INCOMPLETE_MUTTON_WRAP);
                        entries.accept(ModItemsRegister.INCOMPLETE_PUMPKIN_PIE);
                        entries.accept(ModItemsRegister.INCOMPLETE_SWEET_BERRY_CHEESECAKE);
                        entries.accept(ModItemsRegister.INCOMPLETE_APPLE_PIE);
                        entries.accept(ModItemsRegister.INCOMPLETE_ROAST_CHICKEN);
                        entries.accept(ModItemsRegister.INCOMPLETE_STUFFED_PUMPKIN);
                        entries.accept(ModItemsRegister.INCOMPLETE_HONEY_GLAZED_HAM);
                        entries.accept(ModItemsRegister.INCOMPLETE_SHEPHERDS_PIE);
                        entries.accept(ModItemsRegister.INCOMPLETE_RICE_ROLL_MEDLEY);
                        entries.accept(ModItemsRegister.INCOMPLETE_FRUIT_SALAD);
                        entries.accept(ModItemsRegister.INCOMPLETE_MIXED_SALAD);
                        entries.accept(ModItemsRegister.INCOMPLETE_NETHER_SALAD);
                        entries.accept(ModItemsRegister.INCOMPLETE_BACON_AND_EGGS);
                        entries.accept(ModItemsRegister.INCOMPLETE_GRILLED_SALMON);
                        entries.accept(ModItemsRegister.INCOMPLETE_HORSE_FEED);
                        entries.accept(ModItemsRegister.INCOMPLETE_ROASTED_MUTTON_CHOPS);
                        entries.accept(ModItemsRegister.INCOMPLETE_STEAK_AND_POTATOES);
                        entries.accept(ModItemsRegister.INCOMPLETE_STUFFED_POTATO);
                        entries.accept(ModItemsRegister.PUMPKIN_PIE_SLICE);
                        entries.accept(ModFluidsRegister.TOMATO_SAUCE_BUCKET);
                        entries.accept(ModFluidsRegister.HOT_COCOA_BUCKET);
                        entries.accept(ModFluidsRegister.MELON_JUICE_BUCKET);
                        entries.accept(ModFluidsRegister.APPLE_CIDER_BUCKET);
                        entries.accept(ModFluidsRegister.BEETROOT_SOUP_BUCKET);
                        entries.accept(ModFluidsRegister.CHICKEN_SOUP_BUCKET);
                        entries.accept(ModFluidsRegister.NOODLE_SOUP_BUCKET);
                        entries.accept(ModFluidsRegister.PUMPKIN_SOUP_BUCKET);
                        entries.accept(ModFluidsRegister.VEGETABLE_SOUP_BUCKET);
                        entries.accept(ModFluidsRegister.FISH_STEW_BUCKET);
                        entries.accept(ModFluidsRegister.BEEF_STEW_BUCKET);
                        entries.accept(ModFluidsRegister.RABBIT_STEW_BUCKET);
                        entries.accept(ModFluidsRegister.MUSHROOM_STEW_BUCKET);
                        entries.accept(ModFluidsRegister.GLOW_BERRY_CUSTARD_BUCKET);
                        entries.accept(ModFluidsRegister.RATATOUILLE_BUCKET);
                        entries.accept(ModFluidsRegister.DOG_FOOD_BUCKET);
                        entries.accept(ModFluidsRegister.BAKED_COD_STEW_BUCKET);
                        entries.accept(ModFluidsRegister.BONE_BROTH_BUCKET);
                        entries.accept(ModFluidsRegister.COOKED_RICE_BUCKET);

    }).build());

    public static void registerModItemGroup(){
        DelightfulCreatorsMod.LOGGER.debug("Registering Mod Item Group for " + DelightfulCreatorsMod.MOD_ID);
    }
}
