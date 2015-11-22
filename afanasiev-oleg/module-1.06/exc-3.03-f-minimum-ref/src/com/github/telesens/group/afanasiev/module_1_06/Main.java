package com.github.telesens.group.afanasiev.module_1_06;

/**
 * Created by oleg on 11/21/15.
 */
public class Main {
    private static final double a = 0;
    private static final double b = 8 * Math.PI;
    private static final double eps = 0.01;

    public static void main(String[] args) {
        double min = FMininum.solve(a, b, eps, MyFunc::f);
        System.out.printf("Minimum of x * sin(x) on [%.2f, %.2f] = %.2f %n", a, b, min);
    }
}
