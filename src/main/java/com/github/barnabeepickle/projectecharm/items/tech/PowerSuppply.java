package com.github.barnabeepickle.projectecharm.items.tech;

import com.github.barnabeepickle.projectecharm.CharmMod;
import com.github.barnabeepickle.projectecharm.items.custom.ItemProjectE;
import jakarta.annotation.Nonnull;
import org.jspecify.annotations.NonNull;

public class PowerSuppply extends ItemProjectE {
    public PowerSuppply() {
        super(CharmMod.techCreativeTab);
        this.setTranslationKey(name);
        this.setMaxStackSize(4);
    }

    @Nonnull
    private static final String name = "pc_xt_psu";

    public static @NonNull String getName() {
        return name;
    }
}
