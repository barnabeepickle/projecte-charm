package com.github.barnabeepickle.projectecharm.items.tech;

import com.github.barnabeepickle.projectecharm.items.custom.TransmutationBlockItem;
import jakarta.annotation.Nullable;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import static com.github.barnabeepickle.projectecharm.event.ModBlocksEvent.TRANSMUTATION_PC;

public class TransmutationPCBlockItem extends TransmutationBlockItem {
    public TransmutationPCBlockItem() {
        super(TRANSMUTATION_PC, 4);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flags)
    {
        list.add(I18n.format("tile.transmutation_pc.tooltip"));
    }
}
