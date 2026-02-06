package com.github.barnabeepickle.projectecharm.blocks;

import com.github.barnabeepickle.projectecharm.blocks.custom.TransmutationTable;
import com.github.barnabeepickle.projectecharm.utils.BlockUtilities;
import jakarta.annotation.Nonnull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jspecify.annotations.NonNull;

import java.util.List;

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
            // Used for the block outline
            -0.5D, // minX
            0.0D,  // minY
            -0.5D, // minZ
            1.5D,  // maxX
            0.25D, // maxY
            1.5D   // maxZ
    );

    @Nonnull
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return AABB;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void addCollisionBoxToList(
            IBlockState state,
            World world,
            BlockPos pos,
            AxisAlignedBB entityBoundingBox,
            List<AxisAlignedBB> collisionBoundingBoxes,
            Entity entity,
            boolean isStateReal
    ) {
        BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos,
                0.0D,
                0.0D,
                -0.5D,
                1.0D,
                0.25D,
                1.5D
        );
        BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos,
                -0.5D,
                0.0D,
                0.0D,
                1.5D,
                0.25D,
                1.0D
        );
        BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos,
                -0.1875D,
                0.0D,
                -0.1875D,
                1.1875D,
                0.25D,
                1.1875D
        );
    }
}
