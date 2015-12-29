/*
    В функции main() проинициализировать одномерный массив из 10 целых чисел.
    Создать функцию, которая принимает в качестве параметра массив,
    упорядочивает первые 4 элемента этого массива по возрастанию,
    последние 4 – по убыванию.
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
        System.out.println();
        init();
        output(arr);
        sort(arr);
        output(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3 - i; j++)
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);

        for (int i = 0; i < arr.length - 3; i++)
            for (int j = arr.length - 4; j < arr.length - 1 - i; j++)
                if (arr[j] < arr[j+1])
                    swap(arr, j, j+1);
    }

    private static void init(){
        Random random = new Random();
        arr = new int[10];

        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(100);
    }

    private static void output(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("]");
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
