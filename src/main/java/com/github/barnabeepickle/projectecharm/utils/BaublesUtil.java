package com.github.barnabeepickle.projectecharm.utils;

import baubles.api.BaublesApi;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public class BaublesUtil {
    public static boolean hasBaubleEquipped(EntityPlayer entityPlayer, Item baubleItem) {
        return BaublesApi.isBaubleEquipped(entityPlayer, baubleItem) != -1;
    }

    public static Item returnBaubleWhenEquipped(EntityPlayer entityPlayer, Item baubleItem) {
        int result = BaublesApi.isBaubleEquipped(entityPlayer, baubleItem);

        if (result != -1) {
            return BaublesApi.getBaublesHandler(entityPlayer).getStackInSlot(result).getItem();
        } else {
            return null;
        }
    }
}
