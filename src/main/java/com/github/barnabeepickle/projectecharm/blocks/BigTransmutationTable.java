package com.github.barnabeepickle.projectecharm.blocks;

import com.github.barnabeepickle.projectecharm.blocks.custom.TransmutationTable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nonnull;

public class BigTransmutationTable extends TransmutationTable {
    public BigTransmutationTable() {
        super();
        this.setTranslationKey(name);
    }

    @Nonnull
    private static final String name = "big_transmutation_table";

    public static @NonNull String getName() {
        return name;
    }

    private static final AxisAlignedBB AABB = new AxisAlignedBB(
            // Use for the block outline
            0.0F,  // minX
            0.0F, // minY
            0.0F,  // minZ
            1.0F,  // maxX
            0.25F,  // maxY
            1.0F   // maxZ
    );

    @Nonnull
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return AABB;
    }
}
