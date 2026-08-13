package flomik.delightfulcreators.init;

import com.zurrtum.create.content.processing.AssemblyOperatorBlockItem;
import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.block.cutter.MechanicalCutterBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public final class ModBlocksRegister {

    private static final Identifier MECHANICAL_CUTTER_ID =
            Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "mechanical_cutter");

    public static final MechanicalCutterBlock MECHANICAL_CUTTER = new MechanicalCutterBlock(
            BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, MECHANICAL_CUTTER_ID))
                    .mapColor(MapColor.PODZOL)
                    .sound(SoundType.WOOD)
                    .strength(1.5F, 6.0F)
                    .noOcclusion());

    public static final Item MECHANICAL_CUTTER_ITEM = new AssemblyOperatorBlockItem(
            MECHANICAL_CUTTER,
            new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, MECHANICAL_CUTTER_ID))
                    .useBlockDescriptionPrefix());

    private ModBlocksRegister() {
    }

    public static void register() {
        Registry.register(BuiltInRegistries.BLOCK, MECHANICAL_CUTTER_ID, MECHANICAL_CUTTER);
        Registry.register(BuiltInRegistries.ITEM, MECHANICAL_CUTTER_ID, MECHANICAL_CUTTER_ITEM);
    }
}
