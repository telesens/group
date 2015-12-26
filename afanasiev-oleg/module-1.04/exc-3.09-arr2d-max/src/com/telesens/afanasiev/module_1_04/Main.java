/*
    В функции main() проинициализировать двумерный массив размерностью m x n целых чисел.
    Создать функцию, которая принимает в качестве параметра массив,
    находит максимальный элемент из минимальных элементов строк массива и возвращает его.
    Результат вывести на экран.
 */

package com.telesens.afanasiev.module_1_04;

import java.util.Random;

/**
 * Created by oleg on 12/26/15.
 */
public class Main {
    private static double[][] arr2d;

    public static void main(String[] args) {
        System.out.println("----------Search max element from min of row----------\n");

        arr2d = init();
        output(arr2d);

        System.out.printf("%n Max = %.2f %n", max(arr2d));
    }

    private static double[][] init() {
        int n = 5;
        int m = 7;
        int min = 0;
        int max = 100;

        double[][] arr2d = new double[n][m];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                arr2d[i][j] = random.nextDouble()*max;
            }

        return arr2d;
    }

    private static void output(double[][] arr2d) {
        for (int i = 0; i < arr2d.length; i++) {
            System.out.print("|");
            for (int j = 0; j < arr2d.length; j++) {
                System.out.printf(" %5.2f", arr2d[i][j]);
            }
            System.out.printf("| => min = %5.2f %n", min(arr2d, i));
        }
    }

    private static double max(double[][] arr2d) {
        double[] minRows = minRows(arr2d);
        double max = minRows[0];

        for (int r = 0; r < minRows.length; r++)
            if (max < minRows[r])
                max = minRows[r];

        return max;
    }

    private static double[] minRows(double[][] arr2d) {
        double[] arrMin = new double[arr2d.length];

        for (int i = 0; i < arrMin.length; i++)
            arrMin[i] = min(arr2d, i);

        return arrMin;
    }

    private static double min(double[][] arr2d, int row) {
        double min = arr2d[row][0];

        for (int c = 0; c < arr2d[row].length; c++)
            if (min > arr2d[row][c])
                min = arr2d[row][c];

        return min;
    }

}
