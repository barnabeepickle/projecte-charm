package com.github.barnabeepickle.projectecharm.items.tech;

import com.github.barnabeepickle.projectecharm.CharmMod;
import com.github.barnabeepickle.projectecharm.items.custom.ItemProjectE;
import jakarta.annotation.Nonnull;
import org.jspecify.annotations.NonNull;

public class PrintedCircuitBoard extends ItemProjectE {
    public PrintedCircuitBoard() {
        super(CharmMod.techCreativeTab);
        this.setTranslationKey(name);
        this.setMaxStackSize(64);
    }

    @Nonnull
    private static final String name = "pcb";

    public static @NonNull String getName() {
        return name;
    }
}
