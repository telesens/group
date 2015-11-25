package com.github.telesens.group.afanasiev.module_1_05;

import java.util.Scanner;

/**
 * Created by oleg on 11/25/15.
 */
public class Main {
    private static int n;
    private static Fraction a;
    private static Fraction b;
    public static void main(String[] args) {
        System.out.println("----------Test fractions----------");
        init();
        print();
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        int numerator, denominator;

        System.out.print("Enter a.n: ");
        numerator = scanner.nextInt();

        System.out.print("Enter a.d: ");
        denominator = scanner.nextInt();
        a = new Fraction(numerator, denominator);

        System.out.print("Enter b.n: ");
        numerator = scanner.nextInt();

        System.out.print("Enter b.d: ");
        denominator = scanner.nextInt();
        b = new Fraction(numerator, denominator);

        System.out.print("Enter n: ");
        n = scanner.nextInt();
    }

    private static void print() {
        System.out.println("a = " + a.reduce());
        System.out.println("b = " + b.reduce());
        System.out.println("a + b = " + Fraction.sum(a, b));
        System.out.println("a * b = " + Fraction.mult(a, b));
        System.out.printf("a ^ %d = %s %n", n, a.pow(n));
    }
}
