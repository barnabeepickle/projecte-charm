package com.github.barnabeepickle.projectecharm;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import com.github.barnabeepickle.projectecharm.client.ModClientListener;
import com.github.barnabeepickle.projectecharm.event.FloppyDiskImprintEvent;
import com.github.barnabeepickle.projectecharm.event.ModBlocksEvent;
import com.github.barnabeepickle.projectecharm.event.ModItemsEvent;
import com.github.barnabeepickle.projectecharm.networking.ModGUIHandler;
import com.github.barnabeepickle.projectecharm.networking.NetworkHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjglx.input.Keyboard;

@Mod(modid = Tags.MODID, name = Tags.MOD_NAME, version = Tags.VERSION,
        dependencies = "after-required:baubles;after-required:projecte;"
)
@Mod.EventBusSubscriber
public class CharmMod {
    @Mod.Instance(Tags.MODID)
    public static CharmMod INSTANCE;

    @SuppressWarnings("unused")
    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    public static final CreativeTabs techCreativeTab = new ModTechTab();

    public static KeyBinding charmKeybind;

    private static final String keyCategory = "key.category." + Tags.MODID;

    @Mod.EventHandler
    public void preLoadEvent(FMLPreInitializationEvent event) {
        NetworkHandler.initMessages();
        //LOGGER.info("Registered " + Tags.MOD_NAME + " network packets");
        NetworkRegistry.INSTANCE.registerGuiHandler(CharmMod.INSTANCE, new ModGUIHandler());

        MinecraftForge.EVENT_BUS.register(ModItemsEvent.class);
        //LOGGER.info("Registered " + Tags.MOD_NAME + " ModItemsEvent.class on the EVENT_BUS");
        MinecraftForge.EVENT_BUS.register(ModBlocksEvent.class);


        charmKeybind = new KeyBinding("key." + Tags.MODID + ".charm.transmutation", KeyConflictContext.IN_GAME, Keyboard.KEY_K, keyCategory);
        ClientRegistry.registerKeyBinding(charmKeybind);
        //LOGGER.info("Registered " + Tags.MOD_NAME + " keybinds");

        MinecraftForge.EVENT_BUS.register(ModClientListener.class);
        //LOGGER.info("Registered " + Tags.MOD_NAME + " CharmMod.ClientEventListener.class on the EVENT_BUS");
    }

    @Mod.EventHandler
    public void loadEvent(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(FloppyDiskImprintEvent.class);
    }
}
