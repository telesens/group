package com.github.telesens.group.afanasiev.module_1_02;

/**
 * Created by oleg on 11/22/15.
 */
public class GeometricMean {
    private double a, b;
    private double G;
    public GeometricMean(double a, double b) {
        this.a = a;
        this.b = b;
        G = solve();
    }

    public void print() {
        System.out.println("+--------+--------+--------+");
        System.out.println("|    a   |    b   |    G   |");
        System.out.println("+--------+--------+--------+");
        System.out.printf("| %6.2f | %6.2f | %6.2f |\n", a, b, G);
        System.out.println("+--------+--------+--------+");
    }

    private double solve() {
        return Math.sqrt(a * b);
    }
}
