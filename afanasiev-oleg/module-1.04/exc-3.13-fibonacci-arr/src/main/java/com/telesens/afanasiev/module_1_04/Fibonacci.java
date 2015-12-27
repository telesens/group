package com.telesens.afanasiev.module_1_04;

/**
 * Created by oleg on 12/27/15.
 */
public class Fibonacci {
    private final int MAX = 92;
    private long[] fib;

    public Fibonacci() {
        fib = new long[MAX+1];
        fib[0] = 0;
        fib[1] = 1;
    }

    public int getMAX() {
        return MAX;
    }

    public long f(int n) {
        if (n < 0 || n > MAX)
            return -1;

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        if (fib[n] != 0)
            return fib[n];

        fib[n] = f(n-1) + f(n-2);
        return  fib[n];
    }
}
