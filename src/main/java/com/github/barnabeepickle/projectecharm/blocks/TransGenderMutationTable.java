package com.github.barnabeepickle.projectecharm.blocks;

import com.github.barnabeepickle.projectecharm.blocks.custom.TransmutationTable;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nonnull;

public class TransGenderMutationTable extends TransmutationTable {
    public TransGenderMutationTable() {
        super();
        this.setTranslationKey(name);
    }

    @Nonnull
    private static final String name = "trans_mutation_table";

    public static @NonNull String getName() {
        return name;
    }
}
