package com.github.telesens.group.afanasiev.module_1_03;

/**
 * Created by oleg on 12/1/15.
 */
public class Main {
    public static void main(String[] args) {
        double x;

        System.out.println("Test signum");
        System.out.println("+---------+---------+");
        System.out.println("|    x    | sign(x) |");
        System.out.println("+---------+---------+");
        x = -6.2;
        System.out.printf("|  %5.2f  |    %2d   |%n", x, signum(x));

        x = 0;
        System.out.printf ("|  %5.2f  |    %2d   |%n", x, signum(x));

        x = 3.43;
        System.out.printf ("|  %5.2f  |    %2d   |%n", x, signum(x));
        System.out.println("+---------+---------+");
    }

    private static int signum(double d) {
        if (d == 0)
            return 0;
        else
            return d < 0 ? -1 : 1;
    }
}
