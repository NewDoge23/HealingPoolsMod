package com.newdoge.healingpools.item;


import com.newdoge.healingpools.HealingPools;


import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import static net.minecraft.item.Items.register;


public class ModItems {
    public static final Item HEALING_BUCKET = register("healing_bucket", Item::new,new Item.Settings());





    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(HealingPools.MOD_ID, name), item);
    }

    public static void registerModItems() {
        HealingPools.LOGGER.info("Registering Mod Items for " + HealingPools.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(HEALING_BUCKET);
        });
    }



}

