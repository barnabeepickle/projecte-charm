package com.github.barnabeepickle.projectecharm.items;

import baubles.api.IBauble;
import com.github.barnabeepickle.projectecharm.CharmMod;
import com.github.barnabeepickle.projectecharm.items.custom.TransmutationTablet;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import moze_intel.projecte.PECore;
import moze_intel.projecte.utils.ClientKeyHelper;
import moze_intel.projecte.utils.Constants;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jspecify.annotations.NonNull;

import java.util.List;

@Optional.Interface(iface = "baubles.api.IBauble", modid = "baubles")
public class TransmutationCharm extends TransmutationTablet implements IBauble {
    public TransmutationCharm() {
        this.setTranslationKey(name);
        this.setMaxStackSize(1);
    }

    @Nonnull
    private static final String name = "transmutation_charm";

    public static @NonNull String getName() {
        return name;
    }

    public static void openTransmutationGUI(World world, EntityPlayer player) {
        if (!world.isRemote)
        {
            player.openGui(PECore.instance, Constants.TRANSMUTATION_GUI, world, 0, -1, -1);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flags)
    {
        list.add(I18n.format("item.transmutation_charm.tooltip.line0"));
        list.add(I18n.format("item.transmutation_charm.tooltip.line1", ClientKeyHelper.getKeyName(CharmMod.charmKeybind)));
    }
}
