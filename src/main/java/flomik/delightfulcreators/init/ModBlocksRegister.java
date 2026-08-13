package flomik.delightfulcreators.init;

import com.simibubi.create.content.processing.AssemblyOperatorBlockItem;
import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.block.cutter.MechanicalCutterBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public final class ModBlocksRegister {

    public static final MechanicalCutterBlock MECHANICAL_CUTTER = new MechanicalCutterBlock(
            FabricBlockSettings.create()
                    .mapColor(MapColor.SPRUCE_BROWN)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(1.5F, 6.0F)
                    .nonOpaque());

    public static final Item MECHANICAL_CUTTER_ITEM = new AssemblyOperatorBlockItem(
            MECHANICAL_CUTTER, new Item.Settings());

    private ModBlocksRegister() {
    }

    public static void register() {
        Identifier id = new Identifier(DelightfulCreatorsMod.MOD_ID, "mechanical_cutter");
        Registry.register(Registries.BLOCK, id, MECHANICAL_CUTTER);
        Registry.register(Registries.ITEM, id, MECHANICAL_CUTTER_ITEM);
    }
}
