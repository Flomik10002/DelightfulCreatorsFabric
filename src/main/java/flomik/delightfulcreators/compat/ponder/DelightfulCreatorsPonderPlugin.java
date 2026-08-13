package flomik.delightfulcreators.compat.ponder;

import flomik.delightfulcreators.DelightfulCreatorsMod;
import flomik.delightfulcreators.init.ModBlocksRegister;
import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

/** Registers the in-game tutorial for the Mechanical Cutter. */
public final class DelightfulCreatorsPonderPlugin implements PonderPlugin {

    @Override
    public String getModId() {
        return DelightfulCreatorsMod.MOD_ID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<Identifier> helper) {
        Identifier cutter = Registries.BLOCK.getId(ModBlocksRegister.MECHANICAL_CUTTER);
        helper.forComponents(cutter).addStoryBoard(
                new Identifier("create", "mechanical_press/pressing"),
                CutterScenes::cutting);
    }
}
