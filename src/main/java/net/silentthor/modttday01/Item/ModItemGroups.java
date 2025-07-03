package net.silentthor.modttday01.Item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.silentthor.modttday01.TutorialMod;
import net.silentthor.modttday01.block.ModBlocks;

import java.util.List;

public class ModItemGroups {

    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = registerItemGroup("pink_garnet_items_group",
            ModItems.PINK_GARNET,
            List.of(ModItems.PINK_GARNET, ModItems.RAW_PINK_GARNET, ModItems.CHISEL, ModItems.CAULIFLOWER,
                    ModItems.STARLIGHT_ASHES));

    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = registerItemGroup("pink_garnet_blocks_group",
            ModBlocks.PINK_GARNET_BLOCK,
            List.of(ModBlocks.PINK_GARNET_BLOCK, ModBlocks.RAW_PINK_GARNET_BLOCK,
                    ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE,
                    ModBlocks.MAGIC_BLOCK, ModBlocks.PINK_GARNET_FENCE, ModBlocks.PINK_GARNET_SLAB, ModBlocks.PINK_GARNET_BUTTON,
                    ModBlocks.PINK_GARNET_FENCE_GATE, ModBlocks.PINK_GARNET_STAIRS, ModBlocks.PINK_GARNET_PRESSURE_PLATE,
                    ModBlocks.PINK_GARNET_WALL, ModBlocks.PINK_GARNET_DOOR, ModBlocks.PINK_GARNET_TRAPDOOR));

    public static ItemGroup registerItemGroup(String name, ItemConvertible icon, List<ItemConvertible> items) {
        Registry<ItemGroup> type = Registries.ITEM_GROUP;
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
        Text text = Text.translatable("itemgroup.modttday01." + name);
        ItemGroup builder = FabricItemGroup.builder().icon(() -> new ItemStack(icon))
                .displayName(text)
                .entries(((displayContext, entries) -> {
                        for (ItemConvertible item : items) {
                            entries.add(item);
                        }
                })).build();
        return Registry.register(type, id, builder);
    }

    public static void registerItemGroups() {

    }
}
