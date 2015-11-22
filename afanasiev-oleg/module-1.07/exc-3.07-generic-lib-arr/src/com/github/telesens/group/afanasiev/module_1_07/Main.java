package com.github.telesens.group.afanasiev.module_1_07;

import java.util.Arrays;

/**
 * Created by oleg on 11/22/15.
 */
public class Main {
    private static final int N = 5;
    public static void main(String[] args) {
        System.out.println("-----Test generic library on different array's type");
        testInteger();
        testDouble();
        testString();
        testBoolean();
    }

    private static void testInteger() {
        Integer[] arr = new Integer[5];

        for (int i = 0; i < N; i++) {
            arr[i] = i * 5;
        }

        System.out.print("\nInteger arr: ");
        System.out.println(Arrays.toString(arr));

        System.out.print("\nswap 1, 3: ");
        LibArr.swap(arr, 1, 3);
        System.out.println(Arrays.toString(arr));

        System.out.print("\nreverse: ");
        LibArr.reverse(arr);
        System.out.println(Arrays.toString(arr));

        System.out.printf("\nOccurrence: %d %n", LibArr.nOccurrence(arr, 1));
        System.out.println("----------------------------");
    }

    private static void testDouble() {
        Double[] arr = new Double[5];

        for (int i = 0; i < N; i++) {
            arr[i] = i * 5.0;
        }

        System.out.print("\nDouble arr: ");
        System.out.println(Arrays.toString(arr));

        System.out.print("\nswap 1, 3: ");
        LibArr.swap(arr, 1, 3);
        System.out.println(Arrays.toString(arr));

        System.out.print("\nreverse: ");
        LibArr.reverse(arr);
        System.out.println(Arrays.toString(arr));

        System.out.printf("\nOccurrence: %d %n", LibArr.nOccurrence(arr, 1.0));
        System.out.println("----------------------------");
    }

    private static void testString() {
        String[] arr = new String[5];

        for (int i = 0; i < N; i++) {
            arr[i] = String.format("str %d", i * 5);
        }

        System.out.print("\nString arr: ");
        System.out.println(Arrays.toString(arr));

        System.out.print("\nswap 1, 3: ");
        LibArr.swap(arr, 1, 3);
        System.out.println(Arrays.toString(arr));

        System.out.print("\nreverse: ");
        LibArr.reverse(arr);
        System.out.println(Arrays.toString(arr));

        System.out.printf("\nOccurrence: %d %n", LibArr.nOccurrence(arr, "str 5"));
        System.out.println("----------------------------");
    }

    private static void testBoolean() {
        Boolean[] arr = new Boolean[5];

        for (int i = 0; i < N; i++) {
            arr[i] = i >= N/2;
        }

        System.out.print("\nBoolean arr: ");
        System.out.println(Arrays.toString(arr));

        System.out.print("\nswap 1, 3: ");
        LibArr.swap(arr, 1, 3);
        System.out.println(Arrays.toString(arr));

        System.out.print("\nreverse: ");
        LibArr.reverse(arr);
        System.out.println(Arrays.toString(arr));

        System.out.printf("\nOccurrence: %d %n", LibArr.nOccurrence(arr, true));
        System.out.println("----------------------------");
    }
}
