package com.github.barnabeepickle.projectecharm.client;

import com.github.barnabeepickle.projectecharm.CharmMod;
import com.github.barnabeepickle.projectecharm.items.TransGenderMutationCharm;
import com.github.barnabeepickle.projectecharm.items.TransmutationCharm;
import com.github.barnabeepickle.projectecharm.networking.NetworkHandler;
import com.github.barnabeepickle.projectecharm.networking.messages.UseCharmMessage;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

import static com.github.barnabeepickle.projectecharm.CharmMod.charmKeybind;
import static com.github.barnabeepickle.projectecharm.Constants.CharmActions.TRANSMUTATION_CHARM_ACTION;
import static com.github.barnabeepickle.projectecharm.event.ModBlocksEvent.*;
import static com.github.barnabeepickle.projectecharm.event.ModItemsEvent.*;

public class ModClientListener {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Minecraft client = Minecraft.getMinecraft();
            while (charmKeybind.isPressed()) {
                if (client.player != null && !client.isGamePaused()) {
                    //CharmMod.LOGGER.info("Client checking if the player has the charm");
                    useCharmClient(client.player);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static void useCharmClient(EntityPlayer player) {
        if (CharmMod.checkForBaubleByClass(player, TransmutationCharm.class) || CharmMod.checkForBaubleByClass(player, TransGenderMutationCharm.class)) {
            NetworkHandler.INSTANCE.sendToServer(new UseCharmMessage(TRANSMUTATION_CHARM_ACTION));
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent evt) {
        registerItemModels();
        registerItemBlockModels();
    }

    public static void registerItemModels() {
        // register item models here
        registerItem(TRANSMUTATION_CHARM);
        registerItem(TRANS_MUTATION_CHARM);
        registerItem(TRANS_MUTATION_TABLET);
    }

    // Item model registration utilities
    private static void registerItem(Item item)
    {
        registerItem(item, 0);
    }

    @SuppressWarnings("SameParameterValue")
    private static void registerItem(Item item, int meta)
    {
        String name = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).toString();
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(name, "inventory"));
    }

    public static void registerItemBlockModels() {
        // register block item models here
        registerItemBlock(TRANS_MUTATION_TABLE);
        registerItemBlock(UPSIDE_DOWN_TRANSMUTATION_TABLE);
        registerItemBlock(BIG_TRANSMUTATION_TABLE);
    }

    // Block Item model registration utility
    private static void registerItemBlock(Block block)
    {
        String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).toString();
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(name, "inventory"));
    }
}
