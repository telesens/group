package com.github.telesens.group.afanasiev.module_1_03;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by oleg on 12/2/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Calculating of factorial");
        int n = input();
        print(n);
    }

    private static BigInteger factorialIter(int n) {
        BigInteger bi = BigInteger.ONE;

        while (n > 0) {
            bi = bi.multiply(BigInteger.valueOf(n));
            n--;
        }

        return bi;
    }

    private static BigInteger facrorialRecursive (int n) {
        BigInteger bi = BigInteger.ONE;

        if (n == 0 || n == 1)
            return bi;

        return BigInteger.valueOf(n).multiply(facrorialRecursive(n - 1));
    }

    private static int input() {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("\nEnter the number: ");
        try{
            n = scanner.nextInt();
            if (n < 0) {
                System.out.println("The number cannot be negative. Please, try again");
                return input();
            }

        } catch (InputMismatchException ex){
            System.out.println("Incorrect number. Please, try again.");
            return input();
        }

        return n;
    }

    private static void print(int n) {
        int d = digits(factorialIter(n));

        if (d < 13)
            d = 13;

        System.out.printf("+-----------+--%s-+--%s-+ %n", repeatSymb('-', d), repeatSymb('-', d));
        System.out.printf("|     n     |    !n (iter) %s |  !n (recurs) %s | %n", repeatSymb(' ', d - 12), repeatSymb(' ', d - 12));
        System.out.printf("+-----------+--%s-+--%s-+ %n", repeatSymb('-', d), repeatSymb('-', d));

        for (int i = 0; i <= n; i++) {
            System.out.printf("| %5d     | %"+d+"d  | %"+d+"d  | %n", i, factorialIter(i), facrorialRecursive(i));
        }

        System.out.printf("+-----------+--%s-+--%s-+ %n", repeatSymb('-', d), repeatSymb('-', d));
    }

    private static int digits(BigInteger bi) {
        int bits = bi.bitLength();
        return (int)(bits * Math.log(2)/Math.log(10)) + 1;
    }

    private static String repeatSymb(char ch, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++)
            sb.append(ch);

        return sb.toString();
    }
}
