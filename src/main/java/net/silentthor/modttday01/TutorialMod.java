package net.silentthor.modttday01;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.silentthor.modttday01.Item.ModItemGroups;
import net.silentthor.modttday01.Item.ModItems;
import net.silentthor.modttday01.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "modttday01";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

	}
}