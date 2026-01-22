package com.github.barnabeepickle.projectecharm.networking;

import com.github.barnabeepickle.projectecharm.Tags;
import com.github.barnabeepickle.projectecharm.networking.messages.UseCharmMessage;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

// https://docs.minecraftforge.net/en/1.12.x/networking/simpleimpl/

public class NetworkHandler {
    private static int id = 0;

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Tags.MODID);

    public static void registerPackets () {
        NetworkHandler.INSTANCE.registerMessage(UseCharmMessage.Handler.class, UseCharmMessage.class, id++, Side.SERVER);
    }
}
