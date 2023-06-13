package flomik.delightfulcreators.item;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.fluid.ModFluids;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemsGroup {
    public static final ItemGroup delightfulcreators = FabricItemGroupBuilder.build(
            new Identifier(DelightfulCreatorsMod.MOD_ID, "delightfulcreators"), () -> new ItemStack(ModFluids.TOMATO_SAUCE_BUCKET));
}
