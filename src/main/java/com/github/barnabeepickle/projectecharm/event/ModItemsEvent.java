package com.github.barnabeepickle.projectecharm.event;

import com.github.barnabeepickle.projectecharm.Tags;
import com.github.barnabeepickle.projectecharm.items.TransMutationCharm;
import com.github.barnabeepickle.projectecharm.items.TransMutationTablet;
import com.github.barnabeepickle.projectecharm.items.TransmutationCharm;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

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

    // Utility methods

    private static <V extends IForgeRegistryEntry<V>> void registerEntry(IForgeRegistry<V> registry, IForgeRegistryEntry<V> o, String name) {
        registerEntry(registry, o, new ResourceLocation(Tags.MODID, name));
    }

    private static <V extends IForgeRegistryEntry<V>> void registerEntry(IForgeRegistry<V> registry, IForgeRegistryEntry<V> o, ResourceLocation name) {
        registry.register(o.setRegistryName(name));
    }

}
