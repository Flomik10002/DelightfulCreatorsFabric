package flomik.delightfulcreators.block.cutter;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import flomik.delightfulcreators.DelightfulCreatorsMod;
import net.minecraft.util.Identifier;

public final class ModPartialModels {

    public static final PartialModel MECHANICAL_CUTTER_HEAD =
            PartialModel.of(new Identifier(
                    DelightfulCreatorsMod.MOD_ID,
                    "block/mechanical_cutter/head"));

    private ModPartialModels() {
    }

    public static void init() {
        // Forces the partial model to be registered for baking on the client.
    }
}
