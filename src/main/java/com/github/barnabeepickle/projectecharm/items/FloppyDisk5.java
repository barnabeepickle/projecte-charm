package com.github.barnabeepickle.projectecharm.items;

import com.github.barnabeepickle.projectecharm.items.custom.ItemProjectE;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nonnull;

public class FloppyDisk5 extends ItemProjectE {
    public FloppyDisk5() {
        this.setTranslationKey(name);
        this.setMaxStackSize(64);
    }

    @Nonnull
    private static final String name = "floppy_disk_5";

    public static @NonNull String getName() {
        return name;
    }
}
