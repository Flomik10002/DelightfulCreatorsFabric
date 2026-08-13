package flomik.delightfulcreators.compat.ponder;

import com.zurrtum.create.client.ponder.api.registration.PonderPlugin;
import com.zurrtum.create.client.ponder.api.registration.PonderSceneRegistrationHelper;
import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.init.ModBlocksRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

/** Registers the in-game tutorial for the Mechanical Cutter. */
public final class DelightfulCreatorsPonderPlugin implements PonderPlugin {

    @Override
    public String getModId() {
        return DelightfulCreatorsMod.MOD_ID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<Identifier> helper) {
        Identifier cutter = BuiltInRegistries.BLOCK.getKey(ModBlocksRegister.MECHANICAL_CUTTER);
        helper.forComponents(cutter).addStoryBoard(
                Identifier.fromNamespaceAndPath("create", "mechanical_press/pressing"),
                CutterScenes::cutting);
    }
}
