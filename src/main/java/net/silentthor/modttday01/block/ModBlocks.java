package net.silentthor.modttday01.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.silentthor.modttday01.TutorialMod;
import net.silentthor.modttday01.block.custom.MagicBlock;

public class ModBlocks {

    private static final BlockSoundGroup pink_garnet_sound = BlockSoundGroup.AMETHYST_BLOCK;
    private static final AbstractBlock.Settings pink_garnet_settings = AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(pink_garnet_sound);
    private static final Block pink_garnet_block = new Block(pink_garnet_settings);
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block", pink_garnet_block);

    private static final BlockSoundGroup raw_pink_garnet_sound = BlockSoundGroup.AMETHYST_CLUSTER;
    private static final AbstractBlock.Settings raw_pink_garnet_settings = AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(raw_pink_garnet_sound);
    private static final Block raw_pink_garnet_block = new Block(raw_pink_garnet_settings);
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block", raw_pink_garnet_block);

    private static final BlockSoundGroup pink_garnet_ore_sound = BlockSoundGroup.STONE;
    private static final AbstractBlock.Settings pink_garnet_ore_settings = AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(pink_garnet_ore_sound);
    public static final Block pink_garnet_ore_block = new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), pink_garnet_ore_settings);
    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore", pink_garnet_ore_block);

    private static final BlockSoundGroup pink_garnet_deepslate_ore_sound = BlockSoundGroup.DEEPSLATE;
    private static final AbstractBlock.Settings pink_garnet_deepslate_ore_settings = AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(pink_garnet_deepslate_ore_sound);
    public static final Block pink_garnet_deepslate_ore_block = new ExperienceDroppingBlock(UniformIntProvider.create(4, 5), pink_garnet_deepslate_ore_settings);
    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore", pink_garnet_deepslate_ore_block);

    private static final BlockSoundGroup magic_block_sound = BlockSoundGroup.AMETHYST_CLUSTER;
    private static final AbstractBlock.Settings magic_block_setting = AbstractBlock.Settings.create().strength(1f);
    public static final Block magic_block = new MagicBlock(magic_block_setting);
    public static final Block MAGIC_BLOCK = registerBlock("magic_block", magic_block);

    private static final AbstractBlock.Settings pink_garnet_stairs_setting = AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(pink_garnet_sound);
    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(), pink_garnet_stairs_setting));

    private static final AbstractBlock.Settings pink_garnet_slab_setting = AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(pink_garnet_sound);
    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            new SlabBlock(pink_garnet_slab_setting));

    private static final AbstractBlock.Settings pink_garnet_button_setting = AbstractBlock.Settings.create().strength(2f).noCollision().sounds(pink_garnet_sound);
    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(BlockSetType.IRON, 2, pink_garnet_button_setting));

    private static final AbstractBlock.Settings pink_garnet_pressure_plate_setting = AbstractBlock.Settings.create().strength(2f).sounds(pink_garnet_sound);
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, pink_garnet_pressure_plate_setting));

    private static final AbstractBlock.Settings pink_garnet_fence_setting = AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(pink_garnet_sound);
    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            new FenceBlock(pink_garnet_fence_setting));

    private static final AbstractBlock.Settings pink_garnet_fence_gate_setting = AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(pink_garnet_sound);
    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, pink_garnet_fence_setting));

    private static final AbstractBlock.Settings pink_garnet_wall_setting = AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(pink_garnet_sound);
    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall",
            new WallBlock(pink_garnet_wall_setting));

    private static final AbstractBlock.Settings pink_garnet_door_setting = AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(pink_garnet_sound).nonOpaque();
    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            new DoorBlock(BlockSetType.IRON, pink_garnet_fence_setting));

    private static final AbstractBlock.Settings pink_garnet_trapdoor_setting = AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(pink_garnet_sound).nonOpaque();
    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, pink_garnet_trapdoor_setting));




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
        type = ItemGroups.NATURAL;
        ItemGroupEvents.modifyEntriesEvent(type).register(
                entries -> {
                    entries.add(ModBlocks.PINK_GARNET_ORE);
                    entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                }
        );
    }

}
