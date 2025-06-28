package com.newdoge.healingpools;

import com.newdoge.healingpools.block.ModBlocks;
import com.newdoge.healingpools.fluid.ModFluids;
import com.newdoge.healingpools.fluid.HealingWater;
import com.newdoge.healingpools.item.ModItems;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HealingPools implements ModInitializer {
	public static final String MOD_ID = "healing_pools";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static FlowableFluid STILL_HEALING_WATER;
	public static FlowableFluid FLOWING_HEALING_WATER;
	public static Item HEALING_BUCKET;
	public static Block HEALING_BLOCK1;



    @Override
	public void onInitialize() {
		STILL_HEALING_WATER = Registry.register(Registries.FLUID, Identifier.of(MOD_ID, "healing_water"), new HealingWater.Still());
		FLOWING_HEALING_WATER = Registry.register(Registries.FLUID, Identifier.of(MOD_ID, "flowing_healing_water"), new HealingWater.Flowing());
		HEALING_BUCKET = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "healing_bucket"),
				new BucketItem(STILL_HEALING_WATER, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)
						.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "healing_bucket1")))));
		HEALING_BLOCK1 = Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "healing_block1"),
				new FluidBlock(STILL_HEALING_WATER, AbstractBlock.Settings.copy(Blocks.WATER)
						.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "healing_block2")))){});



		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		ModFluids.registerModFluids();


		LOGGER.info("Hello Fabric world!");
	}

}

