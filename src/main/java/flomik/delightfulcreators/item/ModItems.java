package flomik.delightfulcreators.item;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item INCOMPLETE_PASTA_WITH_MEATBALLS = registerItem("incomplete_pasta_with_meatballs",
            new Item(new FabricItemSettings().group(ModItemsGroup.main).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_PASTA_WITH_MUTTON_CHOP = registerItem("incomplete_pasta_with_mutton_chop",
            new Item(new FabricItemSettings().group(ModItemsGroup.main).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_EGG_SANDWICH = registerItem("incomplete_egg_sandwich",
            new Item(new FabricItemSettings().group(ModItemsGroup.main).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_CHICKEN_SANDWICH = registerItem("incomplete_chicken_sandwich",
            new Item(new FabricItemSettings().group(ModItemsGroup.main).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_HAMBURGER = registerItem("incomplete_hamburger",
            new Item(new FabricItemSettings().group(ModItemsGroup.main).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_BACON_SANDWICH = registerItem("incomplete_bacon_sandwich",
            new Item(new FabricItemSettings().group(ModItemsGroup.main).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_MUTTON_WRAP = registerItem("incomplete_mutton_wrap",
            new Item(new FabricItemSettings().group(ModItemsGroup.main).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_PUMPKIN_PIE = registerItem("incomplete_pumpkin_pie",
            new Item(new FabricItemSettings().group(ModItemsGroup.main).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_SWEET_BERRY_CHEESECAKE = registerItem("incomplete_sweet_berry_cheesecake",
            new Item(new FabricItemSettings().group(ModItemsGroup.main).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item INCOMPLETE_APPLE_PIE = registerItem("incomplete_apple_pie",
            new Item(new FabricItemSettings().group(ModItemsGroup.main).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    public static final Item PUMPKIN_PIE_SLICE = registerItem("pumpkin_pie_slice",
            new Item(new FabricItemSettings().group(ModItemsGroup.main).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(DelightfulCreatorsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DelightfulCreatorsMod.LOGGER.debug("Registering Mod Items for " + DelightfulCreatorsMod.MOD_ID);
    }
}
