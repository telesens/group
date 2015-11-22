package com.github.telesens.group.afanasiev.module_1_03;

/**
 * Created by oleg on 11/17/15.
 */
public class Main {
    public static void main(String[] args) {

        final int n = 10;
        long pow8 = 1;
        long pow8bit = 1;

        System.out.println("+----+------------+------------+");
        System.out.printf("|  n |     8^n    |  8^n - bit |%n");
        System.out.println("+----+------------+------------+");

        System.out.printf("| %2d | %10d | %10d |%n", 0, 1, 8 >> 3);

        for (int i = 1; i <= n; i++) {
            pow8 *= 8;
            pow8bit <<= 3;
            System.out.printf("| %2d | %10d | %10d |%n", i,  pow8, pow8bit);
        }
        System.out.println("+----+------------+------------+");
    }
}
