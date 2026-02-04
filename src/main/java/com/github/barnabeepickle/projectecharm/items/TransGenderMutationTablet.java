package com.github.barnabeepickle.projectecharm.items;

import com.github.barnabeepickle.projectecharm.items.custom.TransmutationTablet;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nonnull;

public class TransGenderMutationTablet extends TransmutationTablet {
    public TransGenderMutationTablet() {
        this.setTranslationKey(name);
        this.setMaxStackSize(1);
    }

    @Nonnull
    private static final String name = "trans_mutation_tablet";

    public static @NonNull String getName() {
        return name;
    }
}
