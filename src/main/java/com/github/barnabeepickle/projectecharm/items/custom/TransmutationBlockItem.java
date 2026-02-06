package com.github.barnabeepickle.projectecharm.items.custom;

import moze_intel.projecte.gameObjs.items.itemBlocks.ItemTransmutationBlock;
import net.minecraft.block.Block;

public class TransmutationBlockItem extends ItemTransmutationBlock {
    public TransmutationBlockItem(Block block, int maxStackSize) {
        super(block);
        this.setMaxStackSize(maxStackSize);
    }
}
