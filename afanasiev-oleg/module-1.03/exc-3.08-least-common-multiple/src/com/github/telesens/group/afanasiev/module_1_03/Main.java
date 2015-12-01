package com.github.telesens.group.afanasiev.module_1_03;

import java.util.Random;

/**
 * Created by oleg on 12/1/15.
 */
public class Main {
    private static final int MIN = 2;
    private static final int MAX = 10;
    private static Random random;

    public static void main(String[] args) {
        random = new Random();
        System.out.println("Test leas common multiple: ");

        int n = 10;
        int a, b;

        Random random = new Random();

        System.out.println("+--------+--------+----------+");
        System.out.println("|    a   |    b   | lcm(a,b) |");
        System.out.println("+--------+--------+----------+");

        for (int i = 1; i <= n; i++) {
            a = nextInt();
            b = nextInt();
            System.out.printf("| %4d   | %4d   | %5d    | %n", a, b, lcm(a, b));
        }

        System.out.println("+--------+--------+----------+");
    }

    private static int lcm(int a, int b) {
        return a*b/gcd(a, b);
    }

    private static int nextInt() {
        return MIN + Math.abs(random.nextInt()) % (MAX - MIN);
    }

    private static int gcd(int a, int b) {

        while (a != b) {
            if (a > b)
                a -= b;
            else
                b -= a;
        }

        return a;
    }
}
