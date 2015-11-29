package com.github.telesens.group.afanasiev.module_1_04;

/**
 * Created by oleg on 11/29/15.
 */
public class InsertionSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            sortIter(arr, i);
        }
    }

    private static void sortIter(int[] arr, int k) {
        int indSorted = indexOfSortedPos(arr, k);

        if (indSorted < k)
            shiftRight(arr, k, indSorted);
    }

    private static int indexOfSortedPos (int[] arr, int k) {
        int el = arr[k];

        for (int i = k-1; i >= 0; i--) {
            if (el >= arr[i]) {
                return i+1;
            }
        }

        return 0;
    }

    private static void shiftRight(int[] arr, int iSrc, int iDst) {
        if (iDst > iSrc)
            return;

        int tmp = arr[iSrc];

        for (int i = iSrc; i > iDst; i--) {
            arr[i] = arr[i-1];
        }

        arr[iDst] = tmp;
    }

 }
