package flomik.delightfulcreators.init;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.block.cutter.MechanicalCutterBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModBlockEntityTypesRegister {

    public static BlockEntityType<MechanicalCutterBlockEntity> MECHANICAL_CUTTER;

    private ModBlockEntityTypesRegister() {
    }

    public static void register() {
        MECHANICAL_CUTTER = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                new Identifier(DelightfulCreatorsMod.MOD_ID, "mechanical_cutter"),
                FabricBlockEntityTypeBuilder.create(
                        MechanicalCutterBlockEntity::new,
                        ModBlocksRegister.MECHANICAL_CUTTER).build());
    }
}
