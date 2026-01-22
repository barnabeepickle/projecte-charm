package com.github.barnabeepickle.projectecharm.networking.messages;

import baubles.api.BaublesApi;
import com.github.barnabeepickle.projectecharm.items.TransmutationCharm;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class UseCharmMessage implements IMessage {
    public UseCharmMessage(){

    }

    int toSend;
    public UseCharmMessage(int toSend) {
        this.toSend = toSend;
    }

    @Override
    public void fromBytes(ByteBuf byteBuf) {
        byteBuf.writeInt(toSend);
    }

    @Override
    public void toBytes(ByteBuf byteBuf) {
        toSend = byteBuf.readInt();
    }

    public static class Handler implements IMessageHandler<UseCharmMessage, IMessage> {
        @Override
        public IMessage onMessage(UseCharmMessage message, MessageContext ctx) {
            // This is the player the packet was sent to the server from
            EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
            // Execute the action on the main server thread by adding it as a scheduled task
            serverPlayer.getServerWorld().addScheduledTask(() -> {
                switch (message.toSend) {
                    case 0: // TRANSMUTATION_CHARM
                        if (BaublesApi.isBaubleEquipped(serverPlayer, new TransmutationCharm()) != -1) {
                            TransmutationCharm.openTransmutationGUI(serverPlayer.world, serverPlayer);
                        }
                }

            });
            // No response packet
            return null;
        }
    }
}