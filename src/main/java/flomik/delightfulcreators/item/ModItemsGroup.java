package flomik.delightfulcreators.item;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.init.ModItemsRegister;
import flomik.delightfulcreators.init.ModFluidsRegister;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroup {
    public static final ItemGroup MAIN = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DelightfulCreatorsMod.MOD_ID, "main"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.main"))
                    .icon(() -> new ItemStack(ModItemsRegister.PUMPKIN_PIE_SLICE)).entries((displayContext, entries) -> {
                        entries.add(ModItemsRegister.INCOMPLETE_PASTA_DISH);
                        entries.add(ModItemsRegister.INCOMPLETE_PASTA_WITH_MEATBALLS);
                        entries.add(ModItemsRegister.INCOMPLETE_PASTA_WITH_MUTTON_CHOP);
                        entries.add(ModItemsRegister.INCOMPLETE_EGG_SANDWICH);
                        entries.add(ModItemsRegister.INCOMPLETE_CHICKEN_SANDWICH);
                        entries.add(ModItemsRegister.INCOMPLETE_HAMBURGER);
                        entries.add(ModItemsRegister.INCOMPLETE_BACON_SANDWICH);
                        entries.add(ModItemsRegister.INCOMPLETE_MUTTON_WRAP);
                        entries.add(ModItemsRegister.INCOMPLETE_PUMPKIN_PIE);
                        entries.add(ModItemsRegister.INCOMPLETE_SWEET_BERRY_CHEESECAKE);
                        entries.add(ModItemsRegister.INCOMPLETE_APPLE_PIE);
                        entries.add(ModItemsRegister.INCOMPLETE_ROAST_CHICKEN);
                        entries.add(ModItemsRegister.INCOMPLETE_STUFFED_PUMPKIN);
                        entries.add(ModItemsRegister.INCOMPLETE_HONEY_GLAZED_HAM);
                        entries.add(ModItemsRegister.INCOMPLETE_SHEPHERDS_PIE);
                        entries.add(ModItemsRegister.INCOMPLETE_RICE_ROLL_MEDLEY);
                        entries.add(ModItemsRegister.INCOMPLETE_FRUIT_SALAD);
                        entries.add(ModItemsRegister.INCOMPLETE_MIXED_SALAD);
                        entries.add(ModItemsRegister.INCOMPLETE_NETHER_SALAD);
                        entries.add(ModItemsRegister.INCOMPLETE_BACON_AND_EGGS);
                        entries.add(ModItemsRegister.INCOMPLETE_GRILLED_SALMON);
                        entries.add(ModItemsRegister.INCOMPLETE_HORSE_FEED);
                        entries.add(ModItemsRegister.INCOMPLETE_ROASTED_MUTTON_CHOPS);
                        entries.add(ModItemsRegister.INCOMPLETE_STEAK_AND_POTATOES);
                        entries.add(ModItemsRegister.PUMPKIN_PIE_SLICE);
                        entries.add(ModFluidsRegister.TOMATO_SAUCE_BUCKET);
                        entries.add(ModFluidsRegister.HOT_COCOA_BUCKET);
                        entries.add(ModFluidsRegister.MELON_JUICE_BUCKET);
                        entries.add(ModFluidsRegister.APPLE_CIDER_BUCKET);
                        entries.add(ModFluidsRegister.BEETROOT_SOUP_BUCKET);
                        entries.add(ModFluidsRegister.CHICKEN_SOUP_BUCKET);
                        entries.add(ModFluidsRegister.NOODLE_SOUP_BUCKET);
                        entries.add(ModFluidsRegister.PUMPKIN_SOUP_BUCKET);
                        entries.add(ModFluidsRegister.VEGETABLE_SOUP_BUCKET);
                        entries.add(ModFluidsRegister.FISH_STEW_BUCKET);
                        entries.add(ModFluidsRegister.BEEF_STEW_BUCKET);
                        entries.add(ModFluidsRegister.RABBIT_STEW_BUCKET);
                        entries.add(ModFluidsRegister.MUSHROOM_STEW_BUCKET);
                        entries.add(ModFluidsRegister.GLOW_BERRY_CUSTARD_BUCKET);

    }).build());

    public static void registerModItemGroup(){
        DelightfulCreatorsMod.LOGGER.debug("Registering Mod Item Group for " + DelightfulCreatorsMod.MOD_ID);
    }
}
