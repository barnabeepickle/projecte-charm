package com.github.barnabeepickle.projectecharm;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import com.github.barnabeepickle.projectecharm.event.ModItemsEvent;
import com.github.barnabeepickle.projectecharm.items.TransMutationCharm;
import com.github.barnabeepickle.projectecharm.items.TransmutationCharm;
import com.github.barnabeepickle.projectecharm.networking.NetworkHandler;
import com.github.barnabeepickle.projectecharm.networking.messages.UseCharmMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjglx.input.Keyboard;

import static com.github.barnabeepickle.projectecharm.Tags.CharmActions.TRANSMUTATION_CHARM_ACTION;

@Mod(modid = Tags.MODID, name = Tags.MOD_NAME, version = Tags.VERSION,
        dependencies = "after-required:baubles@[2.4.9,);after-required:projecte;"
)
@Mod.EventBusSubscriber
public class CharmMod {

    @SuppressWarnings("unused")
    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    public static KeyBinding charmKeybind;

    private static final String keyCategory = "key.category." + Tags.MODID;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        NetworkHandler.initMessages();
        //LOGGER.info("Registered " + Tags.MOD_NAME + " network packets");

        MinecraftForge.EVENT_BUS.register(ModItemsEvent.class);
        //LOGGER.info("Registered " + Tags.MOD_NAME + " ModItemsEvent.class on the EVENT_BUS");


        charmKeybind = new KeyBinding("key." + Tags.MODID + ".charm.transmutation", KeyConflictContext.IN_GAME, Keyboard.KEY_K, keyCategory);
        ClientRegistry.registerKeyBinding(charmKeybind);
        //LOGGER.info("Registered " + Tags.MOD_NAME + " keybinds");

        MinecraftForge.EVENT_BUS.register(ModClientListener.class);
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
}
