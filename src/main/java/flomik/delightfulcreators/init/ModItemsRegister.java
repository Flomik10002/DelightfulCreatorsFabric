package flomik.delightfulcreators.init;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.item.ModItemsGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItemsRegister {
    public static final Item INCOMPLETE_PASTA_WITH_MEATBALLS = registerItem("incomplete_pasta_with_meatballs",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_PASTA_WITH_MUTTON_CHOP = registerItem("incomplete_pasta_with_mutton_chop",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_EGG_SANDWICH = registerItem("incomplete_egg_sandwich",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_CHICKEN_SANDWICH = registerItem("incomplete_chicken_sandwich",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_HAMBURGER = registerItem("incomplete_hamburger",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_BACON_SANDWICH = registerItem("incomplete_bacon_sandwich",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_MUTTON_WRAP = registerItem("incomplete_mutton_wrap",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_PUMPKIN_PIE = registerItem("incomplete_pumpkin_pie",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_SWEET_BERRY_CHEESECAKE = registerItem("incomplete_sweet_berry_cheesecake",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_APPLE_PIE = registerItem("incomplete_apple_pie",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_ROAST_CHICKEN = registerItem("incomplete_roast_chicken",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_STUFFED_PUMPKIN = registerItem("incomplete_stuffed_pumpkin",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_HONEY_GLAZED_HAM = registerItem("incomplete_honey_glazed_ham",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_SHEPHERDS_PIE = registerItem("incomplete_shepherds_pie",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_RICE_ROLL_MEDLEY = registerItem("incomplete_rice_roll_medley",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_FRUIT_SALAD = registerItem("incomplete_fruit_salad",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_MIXED_SALAD = registerItem("incomplete_mixed_salad",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_NETHER_SALAD = registerItem("incomplete_nether_salad",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_BACON_AND_EGGS = registerItem("incomplete_bacon_and_eggs",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_GRILLED_SALMON = registerItem("incomplete_grilled_salmon",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_HORSE_FEED = registerItem("incomplete_horse_feed",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_ROASTED_MUTTON_CHOPS = registerItem("incomplete_roasted_mutton_chops",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_STEAK_AND_POTATOES = registerItem("incomplete_steak_and_potatoes",
            new Item(new FabricItemSettings().recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item PUMPKIN_PIE_SLICE = registerItem("pumpkin_pie_slice",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DelightfulCreatorsMod.LOGGER.debug("Registering Mod Items for " + DelightfulCreatorsMod.MOD_ID);
    }
}
