package com.github.barnabeepickle.projectecharm.event;

import com.github.barnabeepickle.projectecharm.blocks.TransMutationTable;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static com.github.barnabeepickle.projectecharm.utils.RegisteryUtilities.registerEntry;

public class ModBlocksEvent {
    public static TransMutationTable TRANS_MUTATION_TABLE = new TransMutationTable();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> blockEvent = event.getRegistry();

        // Register blocks here
        registerEntry(blockEvent, TRANS_MUTATION_TABLE, TransMutationTable.getName());
    }
}
