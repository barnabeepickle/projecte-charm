package com.github.barnabeepickle.projectecharm.gui;

import moze_intel.projecte.gameObjs.container.TransmutationContainer;
import moze_intel.projecte.gameObjs.container.inventory.TransmutationInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import org.jspecify.annotations.Nullable;

public class ModGUIHandler implements IGuiHandler {
    public static final int TABLE_TRANS_GUI = 1;
    public static final int TABLET_TRANS_GUI = 2;
    public static final int CHARM_TRANS_GUI = 3;
    public static final int COMPUTER_GUI = 4;

    @Override
    public @Nullable Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        EnumHand playerHand;
        if (id == TABLET_TRANS_GUI) {
            playerHand = x == 1 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
        } else {
            playerHand = null;
        }

        return switch (id) {
            case TABLE_TRANS_GUI, COMPUTER_GUI, CHARM_TRANS_GUI ->
                    new TransmutationContainer(entityPlayer.inventory, new TransmutationInventory(entityPlayer), null);
            case TABLET_TRANS_GUI ->
                    new TransmutationContainer(entityPlayer.inventory, new TransmutationInventory(entityPlayer), playerHand);
            default -> null;
        };

    }

    @Override
    public @Nullable Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        EnumHand playerHand;
        if (id == TABLET_TRANS_GUI) {
            playerHand = x == 1 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
        } else {
            playerHand = null;
        }

        return switch (id) {
            case TABLE_TRANS_GUI, CHARM_TRANS_GUI ->
                    new TransGUI(entityPlayer.inventory, new TransmutationInventory(entityPlayer), null);
            case COMPUTER_GUI ->
                    new ComputerGUI(entityPlayer.inventory, new TransmutationInventory(entityPlayer), null);
            case TABLET_TRANS_GUI ->
                    new TransGUI(entityPlayer.inventory, new TransmutationInventory(entityPlayer), playerHand);
            default -> null;
        };
    }
}
