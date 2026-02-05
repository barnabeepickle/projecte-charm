package com.github.barnabeepickle.projectecharm.event;

import moze_intel.projecte.gameObjs.blocks.TransmutationStone;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.github.barnabeepickle.projectecharm.event.ModItemsEvent.FLOPPY_DISK_5;
import static com.github.barnabeepickle.projectecharm.event.ModItemsEvent.TRANSMUTATION_FLOPPY_DISK_5;

public class FloppyDiskImprintEvent {
    @SubscribeEvent
    public static void onTransmutationTableInteract(PlayerInteractEvent.RightClickBlock event) {
        if (!event.getWorld().isRemote) {
            Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
            if (block instanceof TransmutationStone) {
                ItemStack itemStack = event.getItemStack();
                if (!itemStack.isEmpty()) {
                    if (itemStack.getItem() == FLOPPY_DISK_5) {
                        itemStack.setCount(itemStack.getCount()-1);
                        event.getEntityPlayer().addItemStackToInventory(new ItemStack(TRANSMUTATION_FLOPPY_DISK_5));
                    }
                }
            }
        }
    }
}
