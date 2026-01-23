package com.github.barnabeepickle.projectecharm.items;

import baubles.api.IBauble;
import moze_intel.projecte.PECore;
import moze_intel.projecte.gameObjs.items.TransmutationTablet;
import moze_intel.projecte.utils.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;

@Optional.Interface(iface = "baubles.api.IBauble", modid = "baubles")
public class TransmutationCharm extends TransmutationTablet implements IBauble {
    public TransmutationCharm() {
        this.setTranslationKey(name);
        this.setMaxStackSize(1);
    }

    private static final String name = "transmutation_charm";

    public static String getName() {
        return name;
    }

    public static void openTransmutationGUI(World world, EntityPlayer player) {
        if (!world.isRemote)
        {
            player.openGui(PECore.instance, Constants.TRANSMUTATION_GUI, world, 0, -1, -1);
        }
    }
}
