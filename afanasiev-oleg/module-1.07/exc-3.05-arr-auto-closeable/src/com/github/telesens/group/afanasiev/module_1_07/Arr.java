package com.github.telesens.group.afanasiev.module_1_07;

import java.util.Arrays;

/**
 * Created by oleg on 11/22/15.
 */
public class Arr implements AutoCloseable {
    private double[] arr;

    public Arr(int N) {
        if (N > 0)
            arr = new double[N];
    }

    public void insert(double el, int i) {
        arr[i] = el;
    }

    @Override
    public void close() throws Exception{
        System.out.println(Arrays.toString(arr));
    }
}
