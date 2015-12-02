package com.github.telesens.group.afanasiev.module_1_03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by oleg on 12/2/15.
 */
public class Main {
    private static long from;
    private static long to;

    public static void main(String[] args) {
        System.out.println("----Search prime numbers----");

        inputRange();
        printPrimes();
    }

    private static void inputRange() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number \"from\": ");
            from = scanner.nextLong();

            System.out.print("Enter the number \"to\": ");
            to = scanner.nextLong();

            if (from <= 0 || to <= 0) {
                System.out.println("Inputed numbers must be positive. Please, try again.");
                inputRange();
            }

            if (from > to) {
                System.out.println("\"from\" cannot be more than \"to\". Please, try again.");
                inputRange();
            }

        } catch(InputMismatchException exc) {
            System.out.println("Incorrect number. Please, try again.");
            inputRange();
        }
    }

    private static boolean isPrime(long n) {
        long m = (long)Math.sqrt(n);

        for (int k = 2; k <= m; k++ ) {
            if (k > 10)
                if (k % 2 == 0 || k % 10 == 5)
                    continue;

            if (n % k == 0)
                return false;
        }

        return true;
    }

    private static void printPrimes() {
        boolean first = true;
        int nGroup = 20;
        int j = 1;

        System.out.println("List of primes number: ");
        System.out.println("[");

        for (long i = from; i <= to; i++) {

            if (isPrime(i)) {
                if (!first)
                    System.out.print(", ");
                else
                    first = false;

                if (j == nGroup) {
                    System.out.println();
                    j = 1;
                }

                System.out.printf("%6d", i);
                j++;
            }
        }

        System.out.println("]");
    }
}
