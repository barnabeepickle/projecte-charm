package com.github.barnabeepickle.projectecharm.blocks.custom;

import moze_intel.projecte.gameObjs.blocks.TransmutationStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nonnull;
import java.util.Random;

public class TransmutationTable extends TransmutationStone {
    public TransmutationTable() {
        super();
        this.setTranslationKey(name);
    }

    @Nonnull
    private static final String name = "transmutation_table";

    public static @NonNull String getName() {
        return name;
    }

    @NonNull
    @Override
    public Item getItemDropped(IBlockState state, Random random, int par2) {
        return Item.getItemFromBlock(this);
    }
}
