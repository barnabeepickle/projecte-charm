package com.github.barnabeepickle.projectecharm;

import com.github.barnabeepickle.projectecharm.event.ModItemsEvent;
import jakarta.annotation.Nonnull;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModTechTab extends CreativeTabs {
    public ModTechTab()
    {
        super(Tags.MODID + ".tech");
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack createIcon()
    {
        return new ItemStack(ModItemsEvent.FLOPPY_DISK_5);
    }
}
