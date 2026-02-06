package com.github.barnabeepickle.projectecharm.utils;

import net.minecraft.util.math.AxisAlignedBB;

public class BoundBox16 {
    public static AxisAlignedBB Simple16(
            double minX,
            double minY,
            double minZ,
            double maxX,
            double maxY,
            double maxZ
    ) {
        return new AxisAlignedBB(
                1.0D/16 * minX,
                1.0D/16 * minY,
                1.0D/16 * minZ,
                1.0D/16 * maxX,
                1.0D/16 * maxY,
                1.0D/16 * maxZ
        );
    }
}
