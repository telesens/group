package com.github.telesens.group.afanasiev.module_1_03;

/**
 * Created by oleg on 12/1/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Sum of series 1/2^n: ");
        printSumTable();
    }

    private static double sum(double eps) {
        double sum = 0;
        double tail = 1;

        while (tail > eps) {
            sum += tail;
            tail /= 2;
        }

        return sum;
    }

    private static void printSumTable() {
        double eps = 0.1;

        System.out.println("+----------------+------------------+");
        System.out.println("|       eps      |         sum      |");
        System.out.println("+----------------+------------------+");


        while (eps >= 0.000000000001) {
            System.out.printf("|  %.10f  |    %4.10f  | %n", eps, sum(eps));
            eps /= 10;
        }
        System.out.println("+----------------+------------------+");
    }
}
