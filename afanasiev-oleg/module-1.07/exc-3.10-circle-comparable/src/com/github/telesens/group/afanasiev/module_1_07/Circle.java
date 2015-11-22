package com.github.telesens.group.afanasiev.module_1_07;

/**
 * Created by oleg on 11/21/15.
 */
public class Circle implements Comparable<Circle> {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        String str = "(R = " + r + ", S = " + String.format("%.2f", area()) + ")";
        return str;
    }

    @Override
    public int compareTo(Circle other) {
        return Double.compare(this.getR(), other.getR());
    }

    public double area() {
        return 2 * r * Math.PI;
    }

    public double getR() {
        return r;
    }
}
