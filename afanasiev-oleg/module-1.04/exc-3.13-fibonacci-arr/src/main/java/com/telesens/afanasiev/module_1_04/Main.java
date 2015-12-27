/*
    Реализовать функцию вычисления чисел Фибоначчи (до 92-го числа включительно)
    с использованием вспомогательного массива (статического поля).
    Параметр функции – номер числа Фибоначчи.
    При первом вызове функции массив заполняется до необходимого числа.
    При последующих вызовах число либо возвращается из массива,
    либо вычисляется с использованием последних двух чисел,
    хранящихся в массиве с дальнейшим заполнением массива.
    Использовать тип long для представления чисел.

    Осуществить тестирование функции для различных значений номеров, вводимых в произвольном порядке.
 */

package com.telesens.afanasiev.module_1_04;

/**
 * Created by oleg on 12/27/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-----------Fibonacci sequence-----------\n");

        printSequenceFibonacci();
    }

    private static void printSequenceFibonacci() {
        Fibonacci fibonacci = new Fibonacci();

        System.out.println("+--------+----------------------+");
        System.out.println("|    n   |          F(n)        |");
        System.out.println("+--------+----------------------+");
        for (int i = 0; i <= fibonacci.getMAX(); i++)
            System.out.printf("|  %-5d | %-20d | %n", i, fibonacci.f(i));
        System.out.println("+--------+----------------------+");
    }
}
