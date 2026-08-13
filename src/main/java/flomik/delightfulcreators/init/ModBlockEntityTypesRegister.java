package flomik.delightfulcreators.init;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.block.cutter.MechanicalCutterBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.world.level.block.entity.BlockEntityType;

public final class ModBlockEntityTypesRegister {

    public static BlockEntityType<MechanicalCutterBlockEntity> MECHANICAL_CUTTER;

    private ModBlockEntityTypesRegister() {
    }

    public static void register() {
        MECHANICAL_CUTTER = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(DelightfulCreatorsMod.MOD_ID, "mechanical_cutter"),
                FabricBlockEntityTypeBuilder.create(
                        MechanicalCutterBlockEntity::new,
                        ModBlocksRegister.MECHANICAL_CUTTER).build());
    }
}
