/*
    В функции main() проинициализировать одномерный массив вещественных чисел случайными значениями
    в диапазоне от -100 до 100.

    Создать функцию, которая
    - принимает в качестве параметра массив,
    - находит количество отрицательных элементов этого массива,
    - создает новый массив необходимой размерности,
    - заполняет его отрицательными элементами и
    - возвращает новый массив.

    Результат вывести на экран.
 */
package com.telesens.afanasiev.module_1_04;

import java.util.Random;

/**
 * Created by oleg on 12/29/15.
 */
public class Main {
    private static int[] arrSrc;
    private static int[] arrDst;

    public static void main(String[] args) {
        System.out.println("-------------Negative array------------\n");
        init();
        output(arrSrc);
        arrDst = excludePositiveFromArr(arrSrc);
        output(arrDst);
    }

    private static void init() {
        Random random = new Random();
        arrSrc = new int[30];

        for (int i = 0; i < arrSrc.length; i++)
            arrSrc[i] = -100 + random.nextInt(200);
    }

    private static int[] excludePositiveFromArr(int[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 0)
                n++;

        int[] arrNeg = new int[n];

        for (int i = 0, j = 0; i < arr.length; i++)
            if (arr[i] < 0)
                arrNeg[j++] = arr[i];

        return arrNeg;
    }

    private static void output(int[] arr) {
        System.out.printf("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]: (" + arr.length + ")");
    }
}
