package com.github.telesens.group.afanasiev.module_1_03;

import com.github.telesens.group.afanasiev.module_1_03.Fibonacci;

/**
 * Created by oleg on 11/17/15.
 */
public class Main {
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        int nMax = 90;
        long FnIter;
        long FnRecurs;

        System.out.println("+------+---------------------------+---------------------------+");
        System.out.printf ("|   n  |         F(n) - iter       |       F(n) - recurs       |%n");
        System.out.println("+------+---------------------------+---------------------------+");

        for (int n = 1; n <= nMax; n++) {
            FnIter = fib.calcIterFn(n);
            FnRecurs = fib.calcRecursiveFn(n);

            System.out.printf("| %4d | %25d | %25d |%n", n, FnIter, FnRecurs);
        }

        System.out.println("+------+---------------------------+---------------------------+");
    }
}
