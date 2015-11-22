package com.github.telesens.group.afanasiev.module_1_03;

/**
 * Created by oleg on 11/17/15.
 */
public class Fibonacci {
    private long fibSaved[];

    public Fibonacci() {
        init (100);
    }

    public long calcIterFn(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        long fibPrev = 1;
        long fibPrevPrev = 1;
        long fib = 0;

        for (int i = 3; i <= n; i++) {
            fib = fibPrev + fibPrevPrev;
            fibPrevPrev = fibPrev;
            fibPrev = fib;
        }

        return fib;
    }

    public long calcRecursiveFn(int n) {
        if (n > fibSaved.length)
            init(n);

        if (fibSaved[n - 1] > 0)
            return fibSaved[n - 1];

        long fib;

        if (n == 1 || n == 2) {
            fib = 1;
        }
        else {
            fib = calcRecursiveFn(n - 1) + calcRecursiveFn(n - 2);
            fibSaved[n - 1] = fib;
        }

        return fib;
    }

    private void init(int n) {
        fibSaved = new long[n];
    }
}
