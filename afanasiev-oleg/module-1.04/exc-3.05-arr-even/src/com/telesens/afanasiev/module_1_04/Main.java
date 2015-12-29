/*
    В функции main() проинициализировать одномерный массив целых чисел.
    Создать функцию, которая принимает в качестве параметра массив и
    находит среднее арифметическое всех чётных элементов массива,
    стоящих на нечётных местах (с нечетными индексами).
    Результат вывести на экран.
 */

package com.telesens.afanasiev.module_1_04;

import java.util.Random;

/**
 * Created by oleg on 12/29/15.
 */
public class Main {
    private static int[] arr;

    public static void main(String[] args) {
        System.out.println("----среднее арифметическое всех чётных элементов массива, " +
                "  стоящих на нечётных местах");

        init();
        output(arr);
        System.out.printf("avg = %.2f", avg(arr));
    }

    private static void init() {
        Random random = new Random();
        arr = new int[20];

        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(10);
    }

    private static double avg(int[] arr) {
        double sum = 0.0;
        int k = 0;

        System.out.print("filtered: [");
        for (int i = 0; i < arr.length; i++)
            if ((i & 1) == 0 && (arr[i] & 1) == 0) {
                sum += arr[i];
                k++;
                System.out.print(arr[i] + " ");
            }
        System.out.println("]");

        return k == 0 ? 0 : sum / k;
    }

    private static void output(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("]");
    }
}
