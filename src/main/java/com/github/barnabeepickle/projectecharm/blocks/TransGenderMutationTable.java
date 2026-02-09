package com.github.barnabeepickle.projectecharm.blocks;

import com.github.barnabeepickle.projectecharm.CharmMod;
import com.github.barnabeepickle.projectecharm.blocks.custom.TransmutationTable;
import com.github.barnabeepickle.projectecharm.networking.ModGUIHandler;
import jakarta.annotation.Nonnull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jspecify.annotations.NonNull;

public class TransGenderMutationTable extends TransmutationTable {
    public TransGenderMutationTable() {
        super();
        this.setTranslationKey(name);
    }

    @Nonnull
    private static final String name = "trans_mutation_table";

    public static @NonNull String getName() {
        return name;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hintX, float hintY, float hintZ) {
        if (!world.isRemote) {
            player.openGui(CharmMod.INSTANCE, ModGUIHandler.TABLE_TRANS_GUI, world, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }
}
