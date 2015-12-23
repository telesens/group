package com.github.telesens.group.afanasiev.module_2_06;

/**
 * Created by oleg on 12/21/15.
 */
public class InsertionSort implements  Runnable {

    private int[] arr;

    public InsertionSort(int... arr) {
        this.arr = arr;
    }

    private void sort() {
        try {
            for (int i = 1; i < arr.length; i++) {
                insert(arr[i], i);
                Array.print("Insertion", arr);
                Thread.sleep(150);
            }
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }

    private void insert(int val, int maxIndex) {
        int i = binSearchPos(val, 0, maxIndex);

        if (i != maxIndex) {
            offset(i, maxIndex);
            arr[i] = val;
        }
    }

    private int binSearchPos(int val, int from, int to) {

        if (from == to)
            return from;

        int mid = (to + from) >> 1;

        if (arr[mid] == val)
            return mid;

        if (arr[mid] < val)
            return binSearchPos(val, mid+1, to);
        else
            return binSearchPos(val, from, mid);
    }

    private void offset(int iFrom, int iTo) {
        for (int i = iTo; i > iFrom; i--) {
            arr[i] = arr[i - 1];
        }
    }

    @Override
    public void run() {
        sort();
    }
}
