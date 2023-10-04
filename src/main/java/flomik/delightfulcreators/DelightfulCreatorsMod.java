package flomik.delightfulcreators;

import flomik.delightfulcreators.init.ModFluidsRegister;
import flomik.delightfulcreators.init.ModItemsRegister;
import flomik.delightfulcreators.item.ModItemsGroup;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelightfulCreatorsMod implements ModInitializer {
    public static final String MOD_ID = "delightfulcreators";
    public static final Logger LOGGER = LoggerFactory.getLogger("Delightful Creators");

    @Override
    public void onInitialize() {
        ModFluidsRegister.register();
        ModItemsRegister.registerModItems();
        ModItemsGroup.registerModItemGroup();
    }
}