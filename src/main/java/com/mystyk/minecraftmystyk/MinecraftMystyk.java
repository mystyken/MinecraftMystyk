package com.mystyk.minecraftmystyk;

import com.mystyk.minecraftmystyk.block.ModBlocks;
import com.mystyk.minecraftmystyk.component.ModDataComponentTypes;
import com.mystyk.minecraftmystyk.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftMystyk implements ModInitializer {
	public static final String MOD_ID = "minecraftmystyk";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();
	}
}