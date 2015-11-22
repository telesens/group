package com.github.telesens.group.afanasiev.module_1_03;

/**
 * Created by oleg on 11/17/15.
 */
public class Main {
    public static void main(String[] args) {
        double eps = 1;
        PiNilakanthSeries pi = new PiNilakanthSeries();
        double piIter, piRec;

        System.out.printf("Math.PI = %15.14f%n%n", Math.PI);
        System.out.println("+------------------+------------------+------------------+------------------+");
        System.out.printf ("|       eps        |      pi(iter)    |   pi(recursive)  |  |Math.PI - pi|  |%n");
        System.out.println("+------------------+------------------+------------------+------------------+");
        for (int i = 1; i <= 9; i++) {
            piIter = pi.calcIter(eps);
            piRec = pi.calcRecursive(eps);
            System.out.printf("| %15.14f | %15.14f | %15.14f | %15.14f |%n", eps, piIter, piRec, Math.abs(Math.PI - piIter));
            eps /= 10;
        }
        System.out.println("+------------------+------------------+------------------+------------------+");
    }
}
