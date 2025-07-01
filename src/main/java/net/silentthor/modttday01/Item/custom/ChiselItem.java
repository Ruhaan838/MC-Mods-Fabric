package net.silentthor.modttday01.Item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.silentthor.modttday01.block.ModBlocks;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_BLOCKS =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.OAK_LOG, ModBlocks.PINK_GARNET_BLOCK,
                    Blocks.GOLD_BLOCK, Blocks.NETHERITE_BLOCK,
                    ModBlocks.PINK_GARNET_BLOCK, ModBlocks.MAGIC_BLOCK
            );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (CHISEL_BLOCKS.containsKey(clickedBlock)){
            if (!world.isClient()){
                world.setBlockState(context.getBlockPos(), CHISEL_BLOCKS.get(clickedBlock).getDefaultState());

                ServerWorld worldserver = (ServerWorld) world;
                ServerPlayerEntity player = (ServerPlayerEntity) context.getPlayer();
                EquipmentSlot equipmentSlot = EquipmentSlot.MAINHAND;

                context.getStack().damage(1, worldserver, player,
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, equipmentSlot));

                SoundEvent sound = SoundEvents.BLOCK_GRINDSTONE_USE;
                SoundCategory soundCategory = SoundCategory.BLOCKS;

                world.playSound(null, context.getBlockPos(), sound, soundCategory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.modttday01.chisel.shift_down"));
        } else{
            tooltip.add(Text.translatable("tooltip.modttday01.chisel"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
