package flomik.delightfulcreators.item;

import net.minecraft.item.FoodComponent;

/** Food profiles shared by transitional recipe items. */
public final class ModFoods {
    public static final FoodComponent INCOMPLETE = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.3f)
            .snack()
            .build();

    private ModFoods() {
    }
}
