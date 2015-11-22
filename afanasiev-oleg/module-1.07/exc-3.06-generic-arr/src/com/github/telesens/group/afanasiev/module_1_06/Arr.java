package com.github.telesens.group.afanasiev.module_1_06;

import java.util.Arrays;

/**
 * Created by oleg on 11/22/15.
 */
public class Arr<T> {
    private Object[] arr;

    public Arr(int n) {
        if (n < 0)
            throw new IllegalArgumentException(n + " < " + 0);

        arr = new Object[n];
    }

    public T get (int i) {
        if (i < 0 || i >= arr.length)
            throw new ArrayIndexOutOfBoundsException();

        return (T)arr[i];
    }

    public void setAt(T el, int i) {
        if (i < 0 || i >= arr.length)
            throw new ArrayIndexOutOfBoundsException();

        arr[i] = el;
    }

    public void deleteAt(int i) {
        if (i < 0 || i >= arr.length)
            throw new ArrayIndexOutOfBoundsException();

        Object[] newArr = new Object[arr.length - 1];

        System.arraycopy(arr, 0, newArr, 0, i);
        System.arraycopy(arr, i + 1, newArr, i, arr.length - 1 - i);

        arr = newArr;
    }

    public void addRange(T[] src, int from, int to) {
        int l = to - from;
        if (l < 0)
            throw new IllegalArgumentException(from + " > " + to);

        Object[] dest = new Object[arr.length + l];
        System.arraycopy(arr, 0, dest, 0, arr.length);
        System.arraycopy(src, from, dest, arr.length, l);

        arr = dest;
    }

    @Override
    public String toString() {
       return Arrays.toString(arr);
    }
}
