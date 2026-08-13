package flomik.delightfulcreators.block.cutter;

import com.zurrtum.create.client.flywheel.lib.model.baked.PartialModel;
import flomik.delightfulcreators.DelightfulCreatorsMod;
import net.minecraft.resources.Identifier;

public final class ModPartialModels {

    public static final PartialModel MECHANICAL_CUTTER_HEAD =
            PartialModel.of(Identifier.fromNamespaceAndPath(
                    DelightfulCreatorsMod.MOD_ID,
                    "block/mechanical_cutter/head"));

    private ModPartialModels() {
    }

    public static void init() {
        // Forces the partial model to be registered for baking on the client.
    }
}
