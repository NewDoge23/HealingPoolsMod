package com.newdoge;

import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.item.Items.register;

public class HealingPools implements ModInitializer {
	public static final String MOD_ID = "healing_pools";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/*public static final Item HEALING_BUCKET;

    static {
        HEALING_BUCKET = register("HEALING_BUCKET", Item::new, new Item.Settings());
    }*/

    @Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//ModItems.initialize();

		LOGGER.info("Hello Fabric world!");
	}

}

