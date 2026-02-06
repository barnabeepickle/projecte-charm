package com.github.barnabeepickle.projectecharm.items.custom;

import jakarta.annotation.Nonnull;
import moze_intel.projecte.PECore;
import moze_intel.projecte.utils.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jspecify.annotations.NonNull;

public class TransmutationTablet extends ItemProjectE {
    public TransmutationTablet() {
        this.setTranslationKey(name);
        this.setMaxStackSize(1);
    }

    @Nonnull
    private static final String name = "transmutation_charm";

    public static @NonNull String getName() {
        return name;
    }


    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        if (!world.isRemote) {
            player.openGui(PECore.instance, Constants.TRANSMUTATION_GUI, world, hand == EnumHand.MAIN_HAND ? 0 : 1, -1, -1);
        }

        return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
