package com.github.telesens.group.afanasiev.module_1_07;

import java.util.Arrays;

/**
 * Created by oleg on 11/23/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-----Test working with generic arrays------");
        testInteger();
        testLong();
        testDouble();
    }

    private static void testInteger() {
        final int N = 10;
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++)
            arr[i] = -N/2 + i;

        System.out.println("\n Test integer array: \n");
        System.out.printf("arr: %s %n", Arrays.toString(arr));
        System.out.printf("index of zero value: %d %n", LibArrNum.indefOfZero(arr));
        System.out.printf("number of negatives: %d %n", LibArrNum.numberNegativs(arr));
        System.out.printf("last negative: %d %n", LibArrNum.lastNegative(arr));
        System.out.println("-------------------------------------");
    }

    private static void testLong() {
        final int N = 10;
        Long[] arr = new Long[N];

        for (int i = 0; i < N; i++)
            arr[i] = (long)(-N/2 + i);

        System.out.println("\n Test long array: \n");
        System.out.printf("arr: %s %n", Arrays.toString(arr));
        System.out.printf("index of zero value: %d %n", LibArrNum.indefOfZero(arr));
        System.out.printf("number of negatives: %d %n", LibArrNum.numberNegativs(arr));
        System.out.printf("last negative: %d %n", LibArrNum.lastNegative(arr));
        System.out.println("-------------------------------------");
    }

    private static void testDouble() {
        final int N = 10;
        Double[] arr = new Double[N];

        for (int i = 0; i < N; i++)
            arr[i] = (double)(-N/2 + i);

        System.out.println("\n Test double array: \n");
        System.out.printf("arr: %s %n", Arrays.toString(arr));
        System.out.printf("index of zero value: %d %n", LibArrNum.indefOfZero(arr));
        System.out.printf("number of negatives: %d %n", LibArrNum.numberNegativs(arr));
        System.out.printf("last negative: %.2f %n", LibArrNum.lastNegative(arr));
        System.out.println("-------------------------------------");
    }
}
