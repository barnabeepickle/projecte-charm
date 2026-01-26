package com.github.barnabeepickle.projectecharm.event;

import com.github.barnabeepickle.projectecharm.items.TransMutationCharm;
import com.github.barnabeepickle.projectecharm.items.TransMutationTablet;
import com.github.barnabeepickle.projectecharm.items.TransmutationCharm;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static com.github.barnabeepickle.projectecharm.utils.RegisteryUtilities.registerEntry;

public class ModItemsEvent {
    public static TransmutationCharm TRANSMUTATION_CHARM = new TransmutationCharm();
    public static TransMutationCharm TRANS_MUTATION_CHARM = new TransMutationCharm();
    public static TransMutationTablet TRANS_MUTATION_TABLET = new TransMutationTablet();

    @SubscribeEvent
    public static void registerItemsEvent(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> itemEvent = event.getRegistry();

        // Register items here
        registerEntry(itemEvent, TRANSMUTATION_CHARM, TransmutationCharm.getName());
        registerEntry(itemEvent, TRANS_MUTATION_CHARM, TransMutationCharm.getName());
        registerEntry(itemEvent, TRANS_MUTATION_TABLET, TransMutationTablet.getName());

    }
}
