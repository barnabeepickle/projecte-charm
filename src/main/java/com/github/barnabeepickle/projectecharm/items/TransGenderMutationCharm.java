package com.github.barnabeepickle.projectecharm.items;

import com.github.barnabeepickle.projectecharm.CharmMod;
import com.github.barnabeepickle.projectecharm.networking.ModGUIHandler;
import jakarta.annotation.Nonnull;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jspecify.annotations.NonNull;

public class TransGenderMutationCharm extends TransmutationCharm {
    public TransGenderMutationCharm() {
        this.setTranslationKey(name);
        this.setMaxStackSize(1);
    }

    @Nonnull
    private static final String name = "trans_mutation_charm";

    public static @NonNull String getName() {
        return name;
    }

    @Override
    public void openCharmGUI(World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.openGui(CharmMod.INSTANCE, ModGUIHandler.CHARM_TRANS_GUI, world, -1, -1, -1);
        }
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        if (!world.isRemote) {
            player.openGui(CharmMod.INSTANCE, ModGUIHandler.TABLET_TRANS_GUI, world, hand == EnumHand.MAIN_HAND ? 0 : 1, -1, -1);
        }

        return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
