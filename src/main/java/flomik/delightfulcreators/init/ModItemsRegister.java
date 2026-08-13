package flomik.delightfulcreators.init;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.item.ModFoods;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.StewItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItemsRegister {
    public static final Item INCOMPLETE_VEGETABLE_NOODLES = registerIncompleteBowl("incomplete_vegetable_noodles");
    public static final Item INCOMPLETE_SQUID_INK_PASTA = registerIncompleteBowl("incomplete_squid_ink_pasta");
    public static final Item INCOMPLETE_MUSHROOM_RICE = registerIncompleteBowl("incomplete_mushroom_rice");
    public static final Item INCOMPLETE_FRIED_RICE = registerIncompleteBowl("incomplete_fried_rice");
    public static final Item INCOMPLETE_DUMPLINGS = registerIncomplete("incomplete_dumplings");
    public static final Item INCOMPLETE_PASTA_DISH = registerIncompleteBowl("incomplete_pasta_dish");
    public static final Item INCOMPLETE_PASTA_WITH_MEATBALLS = registerIncompleteBowl("incomplete_pasta_with_meatballs");
    public static final Item INCOMPLETE_PASTA_WITH_MUTTON_CHOP = registerIncompleteBowl("incomplete_pasta_with_mutton_chop");
    public static final Item INCOMPLETE_EGG_SANDWICH = registerIncomplete("incomplete_egg_sandwich");
    public static final Item INCOMPLETE_CHICKEN_SANDWICH = registerIncomplete("incomplete_chicken_sandwich");
    public static final Item INCOMPLETE_HAMBURGER = registerIncomplete("incomplete_hamburger");
    public static final Item INCOMPLETE_BACON_SANDWICH = registerIncomplete("incomplete_bacon_sandwich");
    public static final Item INCOMPLETE_MUTTON_WRAP = registerIncompleteBowl("incomplete_mutton_wrap");
    public static final Item INCOMPLETE_PUMPKIN_PIE = registerIncomplete("incomplete_pumpkin_pie");
    public static final Item INCOMPLETE_SWEET_BERRY_CHEESECAKE = registerIncomplete("incomplete_sweet_berry_cheesecake");
    public static final Item INCOMPLETE_APPLE_PIE = registerIncomplete("incomplete_apple_pie");
    public static final Item INCOMPLETE_ROAST_CHICKEN = registerIncompleteBowl("incomplete_roast_chicken");
    public static final Item INCOMPLETE_STUFFED_PUMPKIN = registerIncomplete("incomplete_stuffed_pumpkin");
    public static final Item INCOMPLETE_HONEY_GLAZED_HAM = registerIncompleteBowl("incomplete_honey_glazed_ham");
    public static final Item INCOMPLETE_SHEPHERDS_PIE = registerIncompleteBowl("incomplete_shepherds_pie");
    public static final Item INCOMPLETE_RICE_ROLL_MEDLEY = registerIncompleteBowl("incomplete_rice_roll_medley");
    public static final Item INCOMPLETE_FRUIT_SALAD = registerIncompleteBowl("incomplete_fruit_salad");
    public static final Item INCOMPLETE_MIXED_SALAD = registerIncompleteBowl("incomplete_mixed_salad");
    public static final Item INCOMPLETE_NETHER_SALAD = registerIncompleteBowl("incomplete_nether_salad");
    public static final Item INCOMPLETE_BACON_AND_EGGS = registerIncompleteBowl("incomplete_bacon_and_eggs");
    public static final Item INCOMPLETE_GRILLED_SALMON = registerIncompleteBowl("incomplete_grilled_salmon");
    public static final Item INCOMPLETE_HORSE_FEED = registerIncomplete("incomplete_horse_feed");
    public static final Item INCOMPLETE_ROASTED_MUTTON_CHOPS = registerIncompleteBowl("incomplete_roasted_mutton_chops");
    public static final Item INCOMPLETE_STEAK_AND_POTATOES = registerIncompleteBowl("incomplete_steak_and_potatoes");
    public static final Item INCOMPLETE_STUFFED_POTATO = registerIncomplete("incomplete_stuffed_potato");
    public static final Item PUMPKIN_PIE_SLICE = registerItem("pumpkin_pie_slice",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder()
                    .hunger(3)
                    .saturationModifier(0.3f)
                    .build())));

    private static Item registerIncomplete(String name) {
        return registerItem(name, new Item(new FabricItemSettings().food(ModFoods.INCOMPLETE)));
    }

    private static Item registerIncompleteBowl(String name) {
        return registerItem(name, new StewItem(new FabricItemSettings().food(ModFoods.INCOMPLETE)));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DelightfulCreatorsMod.LOGGER.debug("Registering Mod Items for " + DelightfulCreatorsMod.MOD_ID);
    }
}
