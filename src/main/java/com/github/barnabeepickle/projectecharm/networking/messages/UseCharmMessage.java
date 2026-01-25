package com.github.barnabeepickle.projectecharm.networking.messages;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import com.github.barnabeepickle.projectecharm.CharmMod;
import com.github.barnabeepickle.projectecharm.items.TransMutationCharm;
import com.github.barnabeepickle.projectecharm.items.TransmutationCharm;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class UseCharmMessage implements IMessage {
    public UseCharmMessage(){

    }

    private int charm;

    public UseCharmMessage(int charm) {
        this.charm = charm;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.charm = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.charm);
    }

    public static class Handler implements IMessageHandler<UseCharmMessage, IMessage> {
        @Override
        public IMessage onMessage(UseCharmMessage message, MessageContext ctx) {
            //CharmMod.LOGGER.info("Server recieved packet from client");
            // This is the player the packet whose client sent the packet
            EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
            int charmID = message.charm;
            // Execute the action on the main server thread by adding it as a scheduled task
            serverPlayer.getServerWorld().addScheduledTask(() -> {
                switch (charmID) {
                    case 0: // TRANSMUTATION_CHARM
                        if (CharmMod.checkForBaubleByClass(serverPlayer, TransmutationCharm.class) || CharmMod.checkForBaubleByClass(serverPlayer, TransMutationCharm.class)) {
                            //CharmMod.LOGGER.info("Attempting to open transmutation GUI");
                            TransmutationCharm.openTransmutationGUI(serverPlayer.world, serverPlayer);
                        }
                        break;
                    default:
                        //CharmMod.LOGGER.warn("CharmID was {}, no value was selected", charmID);
                }

            });
            // No response packet
            return null;
        }
    }
}