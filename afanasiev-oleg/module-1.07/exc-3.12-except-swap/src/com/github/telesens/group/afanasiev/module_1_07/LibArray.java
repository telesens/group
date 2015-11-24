package com.github.telesens.group.afanasiev.module_1_07;

/**
 * Created by oleg on 11/24/15.
 */
class LibArrExc extends ArrayIndexOutOfBoundsException {
    private int i;

    public LibArrExc(int i) {
        super(i);
        this.i = i;
    }

    public void printError() {
        System.err.printf("Index %d is out of the array's bounds %n ", i);
    }
}
public class LibArray {
    public static<T> void swap(T[] arr, int i, int j) {
        if (i < 0 || i >= arr.length)
            throw new LibArrExc(i);

        if (j < 0 || j >= arr.length)
            throw new LibArrExc(j);

        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
