package net.silentthor.modttday01.Item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.silentthor.modttday01.Item.custom.ChiselItem;
import net.silentthor.modttday01.TutorialMod;

import java.util.List;

public class ModItems {

    static Item pink_garnet_settings = new Item(new Item.Settings());
    public static final Item PINK_GARNET = registerItem("pink_garnet", pink_garnet_settings);

    static Item raw_garnet_settings = new Item(new Item.Settings());
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", raw_garnet_settings);

    static Item chisel_settings = new ChiselItem(new Item.Settings().maxDamage(32));
    public static final Item CHISEL = registerItem("chisel", chisel_settings);

    static Item cauliflower_settings = new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.modttday01.cauliflower"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    };
    public static final Item CAULIFLOWER = registerItem("cauliflower", cauliflower_settings);

    static Item starlight_settings = new Item(new Item.Settings());
    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", starlight_settings);

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
                    entires.add(RAW_PINK_GARNET);
                    entires.add(CHISEL);
                }
        );
    }
}
