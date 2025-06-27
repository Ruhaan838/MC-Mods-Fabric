package net.silentthor.modttday01.Item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.silentthor.modttday01.TutorialMod;

public class ModItems {

    static Item pink_garnet_settings = new Item(new Item.Settings());
    public static final Item PINK_GARNET = registerItem("pink_garnet", pink_garnet_settings);

    static Item raw_garnet_settings = new Item(new Item.Settings());
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", raw_garnet_settings);

    private static Item registerItem(String name, Item item) {
        Identifier idt = Identifier.of(TutorialMod.MOD_ID, name);
        return Registry.register(Registries.ITEM, idt, item);
    }

    public static void registerItems() {
    //TutorialMod.LOGGER.info("Registering Items for " + TutorialMod.MOD_ID);

        //ItemGropEvents.modifyEntriersEvent allow to change the existent inventory in creative mod
        RegistryKey<ItemGroup> item_type = ItemGroups.INGREDIENTS;

        ItemGroupEvents.modifyEntriesEvent(item_type).register(
                entires -> {
                    entires.add(PINK_GARNET);
                    entires.add(raw_garnet_settings);
                }
        );
    }
}
