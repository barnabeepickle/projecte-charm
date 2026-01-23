package com.github.barnabeepickle.projectecharm;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import com.github.barnabeepickle.projectecharm.event.ModItemsEvent;
import com.github.barnabeepickle.projectecharm.items.TransmutationCharm;
import com.github.barnabeepickle.projectecharm.networking.NetworkHandler;
import com.github.barnabeepickle.projectecharm.networking.messages.UseCharmMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjglx.input.Keyboard;

import static com.github.barnabeepickle.projectecharm.Tags.CharmActions.TRANSMUTATION_CHARM;

@Mod(modid = Tags.MODID, name = Tags.MOD_NAME, version = Tags.VERSION,
        dependencies = "after-required:baubles@[2.4.9,);after-required:projecte;"
)
@Mod.EventBusSubscriber
public class CharmMod {

    @SuppressWarnings("unused")
    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    private static KeyBinding charmKeybind;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        NetworkHandler.initMessages();
        //LOGGER.info("Registered " + Tags.MOD_NAME + " network packets");

        MinecraftForge.EVENT_BUS.register(ModItemsEvent.class);
        //LOGGER.info("Registered " + Tags.MOD_NAME + " ModItemsEvent.class on the EVENT_BUS");


        charmKeybind = new KeyBinding("key." + Tags.MODID + ".charm.transmutation", KeyConflictContext.IN_GAME, Keyboard.KEY_K, "key.category." + Tags.MODID);
        ClientRegistry.registerKeyBinding(charmKeybind);
        //LOGGER.info("Registered " + Tags.MOD_NAME + " keybinds");

        MinecraftForge.EVENT_BUS.register(ClientEventListener.class);
        //LOGGER.info("Registered " + Tags.MOD_NAME + " CharmMod.ClientEventListener.class on the EVENT_BUS");
    }

    public static boolean checkForBaubleByClass(EntityPlayer player, Class<?> clazz) {
        IBaublesItemHandler handler = BaublesApi.getBaublesHandler(player);

        for(int i = 0; i < handler.getSlots(); ++i) {
            //LOGGER.info("checking baubles {}, {}", handler.getStackInSlot(i).getItem().getClass(), i);
            if (!handler.getStackInSlot(i).isEmpty() && handler.getStackInSlot(i).getItem() != Items.AIR) {
                if (handler.getStackInSlot(i).getItem().getClass() == clazz) {
                    return true;
                }
            }
        }

        return false;
    }


    public static class ClientEventListener {
        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent event) {
            if (event.phase == TickEvent.Phase.END) {
                Minecraft client = Minecraft.getMinecraft();
                while (charmKeybind.isPressed()) {
                    if (client.player != null && !client.isGamePaused()) {
                        //LOGGER.info("Client checking if the player has the charm");
                        if (CharmMod.checkForBaubleByClass(client.player, TransmutationCharm.class)) {
                            //LOGGER.info("Client attempting to send packet to server");
                            NetworkHandler.INSTANCE.sendToServer(new UseCharmMessage(TRANSMUTATION_CHARM));
                        }
                    }
                }
            }
        }
    }
}
