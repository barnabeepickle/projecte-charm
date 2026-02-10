package com.github.barnabeepickle.projectecharm.utils;

import com.github.barnabeepickle.projectecharm.CharmMod;
import net.minecraft.util.math.AxisAlignedBB;

import javax.vecmath.Matrix3d;
import javax.vecmath.Vector3d;

public class BoundBoxUtilities {
    public static AxisAlignedBB simple16(
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

    public static AxisAlignedBB vectorAABB(Vector3d minVector, Vector3d maxVector) {
        return new AxisAlignedBB(
                minVector.getX(),
                minVector.getY(),
                minVector.getZ(),
                maxVector.getX(),
                maxVector.getY(),
                maxVector.getZ()
        );
    }

    public static Vector3d rotHack(Vector3d vector, double angle) {
        angle = Math.toRadians(angle);

        // identity matrix
        Matrix3d rotMat = new Matrix3d(1,0,0, 0,1,0, 0,0,1);
        rotMat.rotY(angle); // rotate on the y axis
        rotMat.transform(vector);

        vector.setX(Math.round(vector.getX() * 10000000D)/10000000D);
        vector.setZ(Math.round(vector.getZ() * 10000000D)/10000000D);

        return vector;
    }

    public static AxisAlignedBB rotHackAABB(AxisAlignedBB aabb) {
        Vector3d minVec = rotHack(new Vector3d(aabb.minX, aabb.minY, aabb.minZ), 90);
        Vector3d maxVec = rotHack(new Vector3d(aabb.maxX, aabb.maxY, aabb.maxZ), 90);
        if (minVec.getX() < 0) {
            minVec.setX(Math.abs(minVec.getX() + 1));
            maxVec.setX(Math.abs(maxVec.getX() + 1));
        }
        if (minVec.getZ() < 0) {
            minVec.setZ(Math.abs(minVec.getZ() + 1));
            maxVec.setZ(Math.abs(maxVec.getZ() + 1));
        }
        //CharmMod.LOGGER.info("minVec : {}", minVec.toString());
        //CharmMod.LOGGER.info("maxVec : {}", maxVec.toString());

        return vectorAABB(minVec, maxVec);
    }
}
