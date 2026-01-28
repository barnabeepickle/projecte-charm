package com.github.barnabeepickle.projectecharm.utils;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class BlockUtilities {
    public static void addBoundingBox(
            AxisAlignedBB entityBoundingBox,
            List<AxisAlignedBB> collidingBoxes,
            BlockPos pos,
            // min cords
            double minX,
            double minY,
            double minZ,
            // max cords
            double maxX,
            double maxY,
            double maxZ
    ) {
        AxisAlignedBB boundingBox = new AxisAlignedBB(
                // min cords
                pos.getX() + minX, // minX
                pos.getY() + minY, // minY
                pos.getZ() + minZ, // minZ
                // max cords
                pos.getX() + maxX, // maxX
                pos.getY() + maxY, // maxY
                pos.getZ() + maxZ  // maxZ
        );
        if (entityBoundingBox.intersects(boundingBox)) {
            collidingBoxes.add(boundingBox);
        }
    }
}
