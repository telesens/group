package com.github.telesens.group.afanasiev.module_2_03;

import java.util.FormatFlagsConversionMismatchException;
import java.util.Formatter;
import java.util.Random;

/**
 * Created by oleg on 12/4/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-------Format number-------\n");

        printN100();
        printShortView();
        printFormatDouble();
    }

    private static void printN100() {
        System.out.println();
        int n = 100;

        System.out.printf("(d): n = %d %n", n);
        System.out.printf("(o): n = %o %n", n);
        System.out.printf("(x): n = %x %n", n);
    }

    private static void printShortView() {
        System.out.println();
        int min = 100000;
        int max = 10000000;
        int step = 100000;

        for (double i = min; i <= max; i+=step)
            System.out.printf("i = %g %n", i);
    }

    private static void printFormatDouble() {
        System.out.println();
        Random random = new Random();
        final int N = 5;
        double d;
        Formatter formatter;

        for (int i = 1; i <= N; i++) {
            d = random.nextDouble() * 100000;
            formatter = new Formatter();
            formatter.format("|%-12.4f|", d);
            System.out.printf("d = %s %n", formatter);
        }
    }
}
