package com.github.telesens.group.afanasiev.module_1_04;

/**
 * Created by oleg on 11/29/15.
 */
public class SelectionSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            sortTail(arr, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    private static void sortTail(int[] arr, int k) {
        int minInd;
        for (int i = k; i < arr.length; i++) {
            minInd = indexOfMin(arr, i);
            if (minInd > i)
                swap(arr, i, minInd);
        }
    }

    private static int indexOfMin(int[] arr, int iStart) {
        int minInd = iStart;
        int min = arr[iStart];

        for (int i = iStart+1; i < arr.length; i++) {
            if (arr[i] < min) {
                minInd = i;
                min = arr[i];
            }
        }

        return minInd;
    }
}
