package flomik.delightfulcreators.item;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.init.ModItemsRegister;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemsGroup {
    public static final ItemGroup main = FabricItemGroupBuilder.build(
            new Identifier(DelightfulCreatorsMod.MOD_ID, "main"), () -> new ItemStack(ModItemsRegister.PUMPKIN_PIE_SLICE));
}
