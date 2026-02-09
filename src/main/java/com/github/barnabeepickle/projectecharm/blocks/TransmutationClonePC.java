package com.github.barnabeepickle.projectecharm.blocks;

import com.github.barnabeepickle.projectecharm.CharmMod;
import com.github.barnabeepickle.projectecharm.blocks.custom.TransmutationTable;
import com.github.barnabeepickle.projectecharm.networking.ModGUIHandler;
import com.github.barnabeepickle.projectecharm.utils.BlockUtilities;
import com.github.barnabeepickle.projectecharm.utils.BoundBox16;
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
    )
    {
        IBlockState blockstate = this.getDefaultState();
        if (facing.getAxis().isHorizontal()) {
            blockstate = blockstate.withProperty(FACING, facing);
        }

        return blockstate;
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
