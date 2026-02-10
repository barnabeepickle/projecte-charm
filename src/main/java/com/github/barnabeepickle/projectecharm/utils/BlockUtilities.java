package com.github.barnabeepickle.projectecharm.utils;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import javax.vecmath.Vector3d;
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

    public static void addBoundingBox(
            AxisAlignedBB entityBoundingBox,
            List<AxisAlignedBB> collidingBoxes,
            BlockPos pos,
            AxisAlignedBB aabb
    ) {
        AxisAlignedBB boundingBox = new AxisAlignedBB(
                // min cords
                pos.getX() + aabb.minX, // minX
                pos.getY() + aabb.minY, // minY
                pos.getZ() + aabb.minZ, // minZ
                // max cords
                pos.getX() + aabb.maxX, // maxX
                pos.getY() + aabb.maxY, // maxY
                pos.getZ() + aabb.maxZ  // maxZ
        );
        if (entityBoundingBox.intersects(boundingBox)) {
            collidingBoxes.add(boundingBox);
        }
    }

    public static void addBoundingBox16(
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
                pos.getX() + 1.0D/16 * minX, // minX
                pos.getY() + 1.0D/16 * minY, // minY
                pos.getZ() + 1.0D/16 * minZ, // minZ
                // max cords
                pos.getX() + 1.0D/16 * maxX, // maxX
                pos.getY() + 1.0D/16 * maxY, // maxY
                pos.getZ() + 1.0D/16 * maxZ  // maxZ
        );
        if (entityBoundingBox.intersects(boundingBox)) {
            collidingBoxes.add(boundingBox);
        }
    }

    public static void addBoundingBox(
            AxisAlignedBB entityBoundingBox,
            List<AxisAlignedBB> collidingBoxes,
            BlockPos pos,
            Vector3d minVector,
            Vector3d maxVector
    ) {
        AxisAlignedBB boundingBox = new AxisAlignedBB(
                // min cords
                pos.getX() + minVector.getX(), // minX
                pos.getY() + minVector.getY(), // minY
                pos.getZ() + minVector.getZ(), // minZ
                // max cords
                pos.getX() + maxVector.getX(), // maxX
                pos.getY() + maxVector.getY(), // maxY
                pos.getZ() + maxVector.getZ() // maxZ
        );
        if (entityBoundingBox.intersects(boundingBox)) {
            collidingBoxes.add(boundingBox);
        }
    }
}
