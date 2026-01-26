package com.github.barnabeepickle.projectecharm.blocks;

import moze_intel.projecte.gameObjs.blocks.TransmutationStone;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nonnull;

public class TransMutationTable extends TransmutationStone {
    public TransMutationTable() {
        super();
        this.setTranslationKey(name);
    }

    @Nonnull
    private static final String name = "trans_mutation_table";

    public static @NonNull String getName() {
        return name;
    }
}
