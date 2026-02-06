package com.github.barnabeepickle.projectecharm.blocks;

import com.github.barnabeepickle.projectecharm.blocks.custom.TransmutationTable;
import com.github.barnabeepickle.projectecharm.utils.BlockUtilities;
import com.github.barnabeepickle.projectecharm.utils.BoundBox16;
import jakarta.annotation.Nonnull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class TransmutationClonePC extends TransmutationTable {
    public TransmutationClonePC() {
        super();
        this.setTranslationKey(name);
    }

    @Nonnull
    private static final String name = "transmutation_pc";

    public static @NonNull String getName() {
        return name;
    }

    private static final AxisAlignedBB AABB = BoundBox16.Simple16(
            // Used for the block outline
            1.0D, // minX
            0.0D, // minY
            4.0D, // minZ
            15.0D,// maxX
            13.0D,// maxY
            16.0D // maxZ
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
        BlockUtilities.addBoundingBox16(entityBoundingBox, collisionBoundingBoxes, pos,
                1.0D,
                0.0D,
                4.0D,
                15.0D,
                5.0D,
                16.0D
        );
        BlockUtilities.addBoundingBox16(entityBoundingBox, collisionBoundingBoxes, pos,
                2.5D,
                5.0D,
                5.0D,
                13.5D,
                13.0D,
                15.0D
        );
    }
}
