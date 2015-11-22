package com.github.telesens.group.afanasiev.module_1_05;
/**
 * Created by oleg on 11/16/15.
 */
public class Main {
    public static void main(String[] args) {
        Complex z1 = new Complex(2, 4);
        Complex z2 = new Complex(5, 7);
        double c = 5;

        System.out.printf("z1 = %s %n", z1);
        System.out.printf("z2 = %s %n", z2);
        System.out.printf("Re(z1) = %s %n", z1.re());
        System.out.printf("Im(z1) = %s %n", z1.im());
        System.out.printf("z1 + z2 = %s %n", z1.plus(z2));
        System.out.printf("z1 - z2 = %s %n", z1.minus(z2));
        System.out.printf("z1 * z2 = %s %n", z1.mult(z2));
        System.out.printf("z1 * %.2f = %s %n", c, z1.mult(c));
        System.out.printf("z1 / z2 = %s %n", z1.div(z2));
        System.out.printf("1 / z1 = %s %n", z1.reciprical());
        System.out.printf("(z1 / z2) * z2 = %s %n", z1.div(z2).mult(z2));
    }
}
