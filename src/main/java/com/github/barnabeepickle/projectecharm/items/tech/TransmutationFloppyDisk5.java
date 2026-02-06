package com.github.barnabeepickle.projectecharm.items.tech;

import moze_intel.projecte.api.ProjectEAPI;
import moze_intel.projecte.api.proxy.IEMCProxy;
import net.minecraft.item.ItemStack;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nonnull;

import static com.github.barnabeepickle.projectecharm.event.ModItemsEvent.FLOPPY_DISK_5;
import static com.github.barnabeepickle.projectecharm.event.ModItemsEvent.TRANSMUTATION_FLOPPY_DISK_5;

public class TransmutationFloppyDisk5 extends FloppyDisk5 {
    public TransmutationFloppyDisk5() {
        this.setTranslationKey(name);
        this.setMaxStackSize(64);
    }

    @Nonnull
    private static final String name = "transmutation_floppy_disk_5";

    public static @NonNull String getName() {
        return name;
    }

    public static long getValueEMC() {
        IEMCProxy proxy = ProjectEAPI.getEMCProxy();
        return proxy.getValue(FLOPPY_DISK_5);
    }

    public static void setValueEMC(long value) {
        IEMCProxy proxy = ProjectEAPI.getEMCProxy();
        proxy.registerCustomEMC(new ItemStack(TRANSMUTATION_FLOPPY_DISK_5), value);
    }
}
