/*
    В функции main() проинициализировать одномерный массив целых чисел случайными значениями.
    Создать функцию, которая принимает в качестве параметра массив и
    выводит на экран сумму элементов массива от первого элемента до элемента с номером k,
    а также сумму элементов от элемента с номером k+1 до последнего.
    Функция возвращает true, если первая сумма больше, и false в противном случае.
    Результат вывести на экран.
 */

package com.telesens.afanasiev;

import java.util.Random;

/**
 * Created by oleg on 12/28/15.
 */
public class Main {
    private static final int N = 30;
    private static int[] arr;

    public static void main(String[] args) {
        System.out.println("------------Sum of array's elements---------");

        init();
        output(arr);
        System.out.println(sum(arr, 15));
    }

    private static void init() {
        arr = new int[N];
        Random random = new Random();

        for (int i = 0; i < N; i++)
            arr[i] = random.nextInt(10);
    }

    private static void output(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i % 30 == 0 && i != 0)
                System.out.println();

            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    private static boolean sum(int[] arr, int k) {
        if (k > arr.length)
            throw new IllegalArgumentException();

        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < k; i++)
            sumLeft += arr[i];

        for (int i = k; i < arr.length; i++)
            sumRight += arr[i];

        System.out.printf("Sum([1]...[%d]) = %d %n", k, sumLeft);
        System.out.printf("Sum([%d]...[%d]) = %d %n", k + 1, arr.length, sumRight);

        return sumLeft > sumRight;
    }
}
