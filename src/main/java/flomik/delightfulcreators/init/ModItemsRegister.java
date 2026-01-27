package flomik.delightfulcreators.init;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ModItemsRegister {
    public static final Item INCOMPLETE_VEGETABLE_NOODLES = registerItem("incomplete_vegetable_noodles",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_SQUID_INK_PASTA = registerItem("incomplete_squid_ink_pasta",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_MUSHROOM_RICE = registerItem("incomplete_mushroom_rice",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_FRIED_RICE = registerItem("incomplete_fried_rice",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_DUMPLINGS = registerItem("incomplete_dumplings",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_PASTA_DISH = registerItem("incomplete_pasta_dish",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_PASTA_WITH_MEATBALLS = registerItem("incomplete_pasta_with_meatballs",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_PASTA_WITH_MUTTON_CHOP = registerItem("incomplete_pasta_with_mutton_chop",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_EGG_SANDWICH = registerItem("incomplete_egg_sandwich",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_CHICKEN_SANDWICH = registerItem("incomplete_chicken_sandwich",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_HAMBURGER = registerItem("incomplete_hamburger",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_BACON_SANDWICH = registerItem("incomplete_bacon_sandwich",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_MUTTON_WRAP = registerItem("incomplete_mutton_wrap",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_PUMPKIN_PIE = registerItem("incomplete_pumpkin_pie",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_SWEET_BERRY_CHEESECAKE = registerItem("incomplete_sweet_berry_cheesecake",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_APPLE_PIE = registerItem("incomplete_apple_pie",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_ROAST_CHICKEN = registerItem("incomplete_roast_chicken",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_STUFFED_PUMPKIN = registerItem("incomplete_stuffed_pumpkin",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_HONEY_GLAZED_HAM = registerItem("incomplete_honey_glazed_ham",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_SHEPHERDS_PIE = registerItem("incomplete_shepherds_pie",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_RICE_ROLL_MEDLEY = registerItem("incomplete_rice_roll_medley",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_FRUIT_SALAD = registerItem("incomplete_fruit_salad",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_MIXED_SALAD = registerItem("incomplete_mixed_salad",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_NETHER_SALAD = registerItem("incomplete_nether_salad",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_BACON_AND_EGGS = registerItem("incomplete_bacon_and_eggs",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_GRILLED_SALMON = registerItem("incomplete_grilled_salmon",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_HORSE_FEED = registerItem("incomplete_horse_feed",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_ROASTED_MUTTON_CHOPS = registerItem("incomplete_roasted_mutton_chops",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_STEAK_AND_POTATOES = registerItem("incomplete_steak_and_potatoes",
            settings -> new Item(settings.recipeRemainder(Items.BOWL).food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));
    public static final Item PUMPKIN_PIE_SLICE = registerItem("pumpkin_pie_slice",
            settings -> new Item(settings.food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build())));

    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        Identifier id = Identifier.of(DelightfulCreatorsMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        return Registry.register(Registries.ITEM, id,
                factory.apply(new Item.Settings().registryKey(key)));
    }

    public static void registerModItems() {
        DelightfulCreatorsMod.LOGGER.debug("Registering Mod Items for " + DelightfulCreatorsMod.MOD_ID);
    }
}
