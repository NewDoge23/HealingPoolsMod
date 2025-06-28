package com.newdoge;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.newdoge.HealingPools.MOD_ID;

public class ModItems {

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));

        Item HEALING_BUCKET = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, HEALING_BUCKET);

        return HEALING_BUCKET;

    }

   public static Item HEALING_BUCKET;

    public static void initialize() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
               .register((itemGroup) -> itemGroup.add(ModItems.HEALING_BUCKET));

    }

}

