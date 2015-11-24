package com.github.telesens.group.afanasiev.module_1_05;

/**
 * Created by oleg on 11/24/15.
 */
public class Point3D {
    private double x, y, z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public static double distance(Point3D p1, Point3D p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) +
                (p1.y - p2.y) * (p1.y - p2.y) +
                (p1.z - p2.z) * (p1.z - p2.z));
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }
}
