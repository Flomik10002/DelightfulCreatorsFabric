package flomik.delightfulcreators.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;

/** Food profiles shared by transitional recipe items. */
public final class ModFoods {

    public static final FoodProperties INCOMPLETE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3f)
            .build();

    /**
     * Eating profile for in-progress Sequenced Assembly stacks: the normal food animation and
     * sound, but none of the consume effects belonging to the finished dish.
     */
    public static final Consumable INCOMPLETE_CONSUMABLE = Consumables.defaultFood().build();

    private ModFoods() {
    }
}
