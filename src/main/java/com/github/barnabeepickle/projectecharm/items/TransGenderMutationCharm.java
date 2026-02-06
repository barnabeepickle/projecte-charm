package com.github.barnabeepickle.projectecharm.items;

import jakarta.annotation.Nonnull;
import org.jspecify.annotations.NonNull;

public class TransGenderMutationCharm extends TransmutationCharm {
    public TransGenderMutationCharm() {
        this.setTranslationKey(name);
        this.setMaxStackSize(1);
    }

    @Nonnull
    private static final String name = "trans_mutation_charm";

    public static @NonNull String getName() {
        return name;
    }
}
