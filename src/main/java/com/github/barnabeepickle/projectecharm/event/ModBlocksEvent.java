package com.github.barnabeepickle.projectecharm.event;

import com.github.barnabeepickle.projectecharm.blocks.BigTransmutationTable;
import com.github.barnabeepickle.projectecharm.blocks.TransGenderMutationTable;
import com.github.barnabeepickle.projectecharm.blocks.UpsideDownTransmutationTable;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static com.github.barnabeepickle.projectecharm.utils.RegisteryUtilities.registerEntry;

public class ModBlocksEvent {
    public static TransGenderMutationTable TRANS_MUTATION_TABLE = new TransGenderMutationTable();
    public static UpsideDownTransmutationTable UPSIDE_DOWN_TRANSMUTATION_TABLE = new UpsideDownTransmutationTable();
    public static BigTransmutationTable BIG_TRANSMUTATION_TABLE = new BigTransmutationTable();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> blockEvent = event.getRegistry();

        // Register blocks here
        registerEntry(blockEvent, TRANS_MUTATION_TABLE, TransGenderMutationTable.getName());
        registerEntry(blockEvent, UPSIDE_DOWN_TRANSMUTATION_TABLE, UpsideDownTransmutationTable.getName());
        registerEntry(blockEvent, BIG_TRANSMUTATION_TABLE, BigTransmutationTable.getName());
    }
}
