package flomik.delightfulcreators;

import flomik.delightfulcreators.config.DCServerConfig;
import flomik.delightfulcreators.init.ModBlockEntityTypesRegister;
import flomik.delightfulcreators.init.ModBlocksRegister;
import flomik.delightfulcreators.init.ModFluidsRegister;
import flomik.delightfulcreators.init.ModItemsRegister;
import flomik.delightfulcreators.item.ModItemsGroup;
import flomik.delightfulcreators.recipe.DCRecipeTypes;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelightfulCreatorsMod implements ModInitializer {
    public static final String MOD_ID = "delightfulcreators";
    public static final Logger LOGGER = LoggerFactory.getLogger("Delightful Creators");

    @Override
    public void onInitialize() {
        DCServerConfig.register();
        DCRecipeTypes.register();
        ModFluidsRegister.register();
        ModItemsRegister.registerModItems();
        ModBlocksRegister.register();
        ModBlockEntityTypesRegister.register();
        ModItemsGroup.registerModItemGroup();
    }
}