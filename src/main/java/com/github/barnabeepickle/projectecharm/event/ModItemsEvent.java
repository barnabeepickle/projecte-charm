package com.github.barnabeepickle.projectecharm.event;

import com.github.barnabeepickle.projectecharm.blocks.BigTransmutationTable;
import com.github.barnabeepickle.projectecharm.blocks.TransMutationTable;
import com.github.barnabeepickle.projectecharm.blocks.UpsideDownTransmutationTable;
import com.github.barnabeepickle.projectecharm.items.TransMutationCharm;
import com.github.barnabeepickle.projectecharm.items.TransMutationTablet;
import com.github.barnabeepickle.projectecharm.items.TransmutationCharm;
import moze_intel.projecte.gameObjs.items.itemBlocks.ItemTransmutationBlock;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static com.github.barnabeepickle.projectecharm.event.ModBlocksEvent.*;
import static com.github.barnabeepickle.projectecharm.utils.RegisteryUtilities.registerEntry;

public class ModItemsEvent {
    public static TransmutationCharm TRANSMUTATION_CHARM = new TransmutationCharm();
    public static TransMutationCharm TRANS_MUTATION_CHARM = new TransMutationCharm();
    public static TransMutationTablet TRANS_MUTATION_TABLET = new TransMutationTablet();

    public static ItemTransmutationBlock ITEM_TRANS_MUTATION_TABLE = new ItemTransmutationBlock(TRANS_MUTATION_TABLE);
    public static ItemTransmutationBlock ITEM_UPSIDE_DOWN_TRANSMUTATION_TABLE = new ItemTransmutationBlock(UPSIDE_DOWN_TRANSMUTATION_TABLE);
    public static ItemTransmutationBlock ITEM_BIG_TRANSMUTATION_TABLE = new ItemTransmutationBlock(BIG_TRANSMUTATION_TABLE);

    @SubscribeEvent
    public static void registerItemsEvent(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> itemEvent = event.getRegistry();

        // Register items here
        registerEntry(itemEvent, TRANSMUTATION_CHARM, TransmutationCharm.getName());
        registerEntry(itemEvent, TRANS_MUTATION_CHARM, TransMutationCharm.getName());
        registerEntry(itemEvent, TRANS_MUTATION_TABLET, TransMutationTablet.getName());

        // Register block items here
        registerEntry(itemEvent, ITEM_TRANS_MUTATION_TABLE, TransMutationTable.getName());
        registerEntry(itemEvent, ITEM_UPSIDE_DOWN_TRANSMUTATION_TABLE, UpsideDownTransmutationTable.getName());
        registerEntry(itemEvent, ITEM_BIG_TRANSMUTATION_TABLE, BigTransmutationTable.getName());
    }
}
