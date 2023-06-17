package flomik.delightfulcreators;

import flomik.delightfulcreators.fluids.ModFluidsRegister;
import flomik.delightfulcreators.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelightfulCreatorsMod implements ModInitializer {
	public static final String MOD_ID = "delightfulcreators";
	public static final Logger LOGGER = LoggerFactory.getLogger("Delightful Creators");

	@Override
	public void onInitialize() {
		ModFluidsRegister.register();
		ModItems.registerModItems();
	}
}