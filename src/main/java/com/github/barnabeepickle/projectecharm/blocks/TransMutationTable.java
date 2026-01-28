package com.github.barnabeepickle.projectecharm.blocks;

import com.github.barnabeepickle.projectecharm.blocks.custom.TransmutationTable;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nonnull;

public class TransMutationTable extends TransmutationTable {
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
