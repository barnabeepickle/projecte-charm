package com.github.barnabeepickle.projectecharm.blocks;

import com.github.barnabeepickle.projectecharm.CharmMod;
import com.github.barnabeepickle.projectecharm.blocks.custom.TransmutationTable;
import com.github.barnabeepickle.projectecharm.networking.ModGUIHandler;
import com.github.barnabeepickle.projectecharm.utils.BlockUtilities;
import com.github.barnabeepickle.projectecharm.utils.BoundBoxUtilities;
import jakarta.annotation.Nonnull;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class TransmutationClonePC extends TransmutationTable {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public TransmutationClonePC() {
        super();
        this.setTranslationKey(name);
        this.setDefaultState(
                this.blockState
                        .getBaseState()
                        .withProperty(FACING, EnumFacing.NORTH)
        );
    }

    @Nonnull
    private static final String name = "transmutation_pc";

    public static @NonNull String getName() {
        return name;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hintX, float hintY, float hintZ) {
        if (!world.isRemote) {
            player.openGui(CharmMod.INSTANCE, ModGUIHandler.COMPUTER_GUI, world, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }

    private static final AxisAlignedBB AABB_NORTH = BoundBoxUtilities.simple16(
            // Used for the block outline
            1.0D, // minX
            0.0D, // minY
            4.0D, // minZ
            15.0D,// maxX
            13.0D,// maxY
            16.0D // maxZ
    );

    // Also used for the block outline but are generated based on AABB_NORTH (this can be unstable and hacky)
    private static final AxisAlignedBB AABB_WEST = BoundBoxUtilities.rotHackAABB(AABB_NORTH);
    private static final AxisAlignedBB AABB_SOUTH = BoundBoxUtilities.rotHackAABB(AABB_WEST);
    private static final AxisAlignedBB AABB_EAST = BoundBoxUtilities.rotHackAABB(AABB_SOUTH);

    @Nonnull
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState blockState, IBlockAccess world, BlockPos pos) {
        EnumFacing facing = blockState.getValue(FACING);
        return switch (facing) {
            case EnumFacing.NORTH -> AABB_NORTH;
            case EnumFacing.SOUTH -> AABB_SOUTH;
            case EnumFacing.EAST -> AABB_EAST;
            case EnumFacing.WEST -> AABB_WEST;
            default -> {
                CharmMod.LOGGER.warn("Invalid case in TransmutationClonePC.getBoundBox returning AABB_NORTH");
                yield AABB_NORTH;
            }
        };
    }

    private static final AxisAlignedBB C0_AABB_NORTH = BoundBoxUtilities.simple16(
            // Used for block collision
            1.0D, // minX
            0.0D, // minY
            4.0D, // minZ
            15.0D,// maxX
            5.0D, // maxY
            16.0D // maxZ
    );

    private static final AxisAlignedBB C1_AABB_NORTH = BoundBoxUtilities.simple16(
            // Used for block collision
            2.5D, // minX
            5.0D, // minY
            5.0D, // minZ
            13.5D,// maxX
            13.0D,// maxY
            15.0D // maxZ
    );

    // Also used for block collision but are generated based on C0_AABB_NORTH and C1_AABB_NORTH (same as above)
    private static final AxisAlignedBB C0_AABB_WEST = BoundBoxUtilities.rotHackAABB(C0_AABB_NORTH);
    private static final AxisAlignedBB C1_AABB_WEST = BoundBoxUtilities.rotHackAABB(C1_AABB_NORTH);
    private static final AxisAlignedBB C0_AABB_SOUTH = BoundBoxUtilities.rotHackAABB(C0_AABB_WEST);
    private static final AxisAlignedBB C1_AABB_SOUTH = BoundBoxUtilities.rotHackAABB(C1_AABB_WEST);
    private static final AxisAlignedBB C0_AABB_EAST = BoundBoxUtilities.rotHackAABB(C0_AABB_SOUTH);
    private static final AxisAlignedBB C1_AABB_EAST = BoundBoxUtilities.rotHackAABB(C1_AABB_SOUTH);

    @SuppressWarnings("deprecation")
    @Override
    public void addCollisionBoxToList(
            IBlockState blockState,
            World world,
            BlockPos pos,
            AxisAlignedBB entityBoundingBox,
            List<AxisAlignedBB> collisionBoundingBoxes,
            Entity entity,
            boolean isStateReal
    ) {
        EnumFacing facing = blockState.getValue(FACING);
        switch (facing) {
            case EnumFacing.NORTH:
                BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos, C0_AABB_NORTH);
                BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos, C1_AABB_NORTH);
                break;
            case EnumFacing.SOUTH:
                BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos, C0_AABB_SOUTH);
                BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos, C1_AABB_SOUTH);
                break;
            case EnumFacing.EAST:
                BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos, C0_AABB_EAST);
                BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos, C1_AABB_EAST);
                break;
            case EnumFacing.WEST:
                BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos, C0_AABB_WEST);
                BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos, C1_AABB_WEST);
                break;
            default:
                CharmMod.LOGGER.warn("Invalid case in TransmutationClonePC.addCollisionBoxToList applying values for EnumFacing.NORTH");
                BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos, C0_AABB_NORTH);
                BlockUtilities.addBoundingBox(entityBoundingBox, collisionBoundingBoxes, pos, C1_AABB_NORTH);
                break;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateForPlacement(
            World world,
            BlockPos blockPos,
            EnumFacing facing,
            float u,
            float v,
            float w,
            int i,
            EntityLivingBase entity
    ) {
        return this.getDefaultState().withProperty(FACING, entity.getHorizontalFacing().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState()
                .withProperty(FACING, EnumFacing.byHorizontalIndex(meta & 3));
    }

    @Override
    public int getMetaFromState(IBlockState blockState) {
        int i = 0;
        i |= blockState.getValue(FACING).getHorizontalIndex();

        return i;
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState withRotation(IBlockState blockState, Rotation rotation) {
        return blockState.withProperty(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState withMirror(IBlockState blockState, Mirror mirror) {
        return blockState.withRotation(mirror.toRotation(blockState.getValue(FACING)));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockFaceShape getBlockFaceShape(
            IBlockAccess blockAccess,
            IBlockState blockState,
            BlockPos blockPos,
            EnumFacing facing
    ) {
        return BlockFaceShape.UNDEFINED;
    }
}
