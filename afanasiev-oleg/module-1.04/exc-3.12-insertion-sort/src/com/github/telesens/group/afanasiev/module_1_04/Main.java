package com.github.telesens.group.afanasiev.module_1_04;

import java.util.Random;

/**
 * Created by oleg on 11/29/15.
 */
public class Main {
    private static int[] arr;
    private static final int LENGTH = 70;

    public static void main(String[] args) {
        System.out.println("----Test selection sort----");
        arr = init(LENGTH, 0, 20);

        System.out.println("arr: ");
        print(arr);

        InsertionSort.sort(arr);
        System.out.println("arr after sorting: ");
        print(arr);
    }

    private static int[] init(int length, int min, int max) {
        int[] arr = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            arr[i] = min + Math.abs(random.nextInt()) % (max - min);
        }

        return arr;
    }

    private static void print(int[] arr) {
        int lengthGroup = 20;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d ", arr[i]);
            if ((i + 1) % lengthGroup == 0)
                System.out.println();
        }

        System.out.println("\n");
    }
}
