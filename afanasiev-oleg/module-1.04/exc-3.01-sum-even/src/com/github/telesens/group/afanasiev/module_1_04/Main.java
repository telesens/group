package com.github.telesens.group.afanasiev.module_1_04;

import java.util.Arrays;

/**
 * Created by oleg on 11/18/15.
 */
public class Main {
    public static void main(String[] args) {
        double arr[] = {5.5, 3.4, -1.2, -5, 0, 6};
        System.out.printf("arr: %s %n", Arrays.toString(arr));
        System.out.printf("sum even (iterative) = %f%n", sumEvenIter(arr));
        System.out.printf("sum even (recursive) = %f%n", sumRecursive(arr, 0));
    }

    private static  double sumEvenIter(double... arr) {
        double s = 0;
        for (double el : arr) {
            if (el > 0)
                s += el;
        }

        return s;
    }

    private static double sumRecursive(double[] arr, int i) {
        if (i == arr.length)
            return 0;

        if (arr[i] > 0)
            return arr[i] + sumRecursive(arr, i + 1);
        else
            return sumRecursive(arr, i + 1);
    }
}
