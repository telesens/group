/*
    Разработать функцию для перемножения двух матриц с проверкой размерностей и
    осуществить тестирование этой функции с проверкой возможных ошибок.
*/
package com.telesens.afanasiev.module_1_04;

import java.util.Random;

/**
 * Created by oleg on 12/27/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("----------Multiply Matrix----------\n");
        double[][] matrIncorrect = new double[1][0];
        double[][] matrIncorrect1 = new double[0][1];

        double[][] matr1 = new double[5][4];
        double[][]matr2 = new double [4][3];
        double[][]matr3 = new double [5][4];

        init(matrIncorrect, 0, 10);
        init(matrIncorrect1, 0, 10);
        init(matr1, 0, 10);
        init(matr2, 0, 10);
        init(matr3, 0, 10);

        output(matrIncorrect);
        output(matrIncorrect1);

        output(matr1);
        System.out.println("                            *");
        output(matr2);
        System.out.println("                            =");
        output(mult(matr1, matr2));

        output(matr2);
        System.out.println("                            *");
        output(matr3);
        System.out.println("                            =");
        output(mult(matr2, matr3));

    }

    private static double[][] mult(double[][] matr1, double[][] matr2) {
        if (matr1.length == 0 || matr2.length == 0)
            return null;

        if (matr1[0].length == 0 || matr2[0].length == 0)
            return null;

        if (matr1[0].length != matr2.length)
            return null;

        double[][] result = new double[matr1.length][matr2[0].length];

        for (int r = 0; r < result.length; r++)
            for (int c = 0; c < result[0].length; c++)
                result[r][c] = multEl(matr1, matr2, r, c);

        return result;
    }

    private static double multEl(double[][] matr1, double[][] matr2, int row, int col) {
        double res = 0;

        for (int i = 0; i < matr1[0].length; i++)
            res += matr1[row][i] * matr2[i][col];

        return res;
    }

    private static void output(double[][] matrix) {
        if (matrix == null) {
            System.out.printf("[NaNxNaN]\n\n");
            return;
        }

        if (matrix.length == 0) {
            System.out.printf("[0xNaN]\n\n");
            return;
        }

        if (matrix[0].length == 0) {
            System.out.printf("[%dx%d]\n\n", matrix.length, matrix[0].length);
            return;
        }


        for (int r = 0; r < matrix.length; r++) {
            System.out.print("|");
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.printf("%8.2f", matrix[r][c]);
            }
            System.out.println("|");
        }

        System.out.println();
    }

    private static boolean init(double[][] matrix, double min, double max) {
        if (matrix.length == 0)
            return false;

        if (matrix[0].length == 0)
            return false;

        Random random = new Random();

        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = min + random.nextDouble() * (max - min);
            }

        return true;
    }
}