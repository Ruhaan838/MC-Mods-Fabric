package net.silentthor.modttday01.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.silentthor.modttday01.TutorialMod;

public class ModBlocks {

    private static final BlockSoundGroup pink_garnet_sound = BlockSoundGroup.AMETHYST_BLOCK;
    private static final AbstractBlock.Settings settings = AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(pink_garnet_sound);
    private static final Block pink_garnet_block = new Block(settings);
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block", pink_garnet_block);

    private static final BlockSoundGroup raw_pink_garnet_sound = BlockSoundGroup.AMETHYST_CLUSTER;
    private static final AbstractBlock.Settings settings1 = AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(raw_pink_garnet_sound);
    private static final Block raw_pink_garnet_block = new Block(settings1);
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block", raw_pink_garnet_block);

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        Identifier idt = Identifier.of(TutorialMod.MOD_ID, name);
        return Registry.register(Registries.BLOCK, idt, block);
    }

    private static void registerBlockItem(String name, Block block){

        Identifier idt = Identifier.of(TutorialMod.MOD_ID, name);
        Item.Settings settings = new Item.Settings();
        BlockItem item = new BlockItem(block, settings);


        Registry.register(Registries.ITEM, idt, item);
    }

    public static void registerModBlocks(){
        RegistryKey<ItemGroup> type = ItemGroups.BUILDING_BLOCKS;
        ItemGroupEvents.modifyEntriesEvent(type).register(
                entries -> {
                    entries.add(ModBlocks.PINK_GARNET_BLOCK);
                    entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                }
        );
    }

}
