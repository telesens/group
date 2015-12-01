package com.github.telesens.group.afanasiev.module_2_02;

import java.util.*;

/**
 * Created by oleg on 12/1/15.
 */
public class Main {

    private static final int N = 5;
    private static Queue<Double> numbers;

    public static void main(String[] args) {
        System.out.println("Using \"PriorityQueue\"");
        init();
        inputNumbers();
        printSequence();
    }

    private static void init() {
        numbers = new PriorityQueue<>((o1, o2) -> ((Double)Math.abs(o1)).compareTo(Math.abs(o2)));
    }

    private static void inputNumbers() {

        Scanner scanner = new Scanner(System.in);
        double nextEl;
        System.out.println("Enter numbers: ");

        for (int i = 1; i <= N; i++) {
            System.out.printf("n%d = ", i);
            nextEl = scanner.nextDouble();
            numbers.add(nextEl);
        }
     }

    private static void printSequence() {

        Double nextEl;
        double sum = 0;
        int n = 0;
        boolean first = true;

        System.out.print("[");
        while ((nextEl = numbers.poll()) != null) {
            if (!first)
                System.out.print(", ");
            else
                first = false;

            System.out.printf("%.2f", nextEl);
            sum += nextEl;
            n++;
        }
        System.out.println("]");

        System.out.printf("AVG = %.2f %n", sum / n);
    }
}
