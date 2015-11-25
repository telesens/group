package com.github.telesens.group.afanasiev.module_1_05;

import ua.in.iwanoff.lesson105.ArrayOfDouble;

import java.util.Scanner;

/**
 * Created by oleg on 11/25/15.
 */
public class Main {
    private static ArrayOfDouble arr;
    private static double n1, n2, n3, n4, n5;
    public static void main(String[] args) {
        init();
        runTest();
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n1: ");
        n1 = scanner.nextDouble();

        System.out.print("Enter n2: ");
        n2 = scanner.nextDouble();

        System.out.print("Enter n3: ");
        n3 = scanner.nextDouble();

        System.out.print("Enter n4: ");
        n4 = scanner.nextDouble();

        System.out.print("Enter n5: ");
        n5 = scanner.nextDouble();

        arr = new ArrayOfDouble(new double[] { n1, n2, n3 });
    }

    private static void runTest() {
        System.out.println("-------Test ArrayOfDouble-----\n");

        System.out.printf("arr: %s %n", arr);
        System.out.printf("arr.get(0): %.2f %n", arr.get(0));
        System.out.printf("arr.toArray()[2]: %.2f %n %n", arr.toArray()[2]);

        arr.add(n4);
        arr.add(n5);
        System.out.printf("arr.add(n4..n5): %s %n %n", arr);

        arr.delLast();
        System.out.printf("arr.delLast(): %s %n %n", arr);

        System.out.printf("after new ...: %s %n", new ArrayOfDouble());
    }
}
