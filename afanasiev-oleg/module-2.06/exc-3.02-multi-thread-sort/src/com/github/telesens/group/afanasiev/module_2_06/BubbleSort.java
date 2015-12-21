package com.github.telesens.group.afanasiev.module_2_06;

/**
 * Created by oleg on 12/21/15.
 */
public class BubbleSort implements Runnable {

    private int[] arr;

    public BubbleSort(int... arr) {
        this.arr = arr;
    }

    private void sort() {
        try {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        arr[j] = arr[j] ^ arr[j + 1];
                        arr[j + 1] = arr[j] ^ arr[j + 1];
                        arr[j] = arr[j] ^ arr[j + 1];
                    }
                }
                Array.print("Bubble", arr);
                Thread.sleep(100);
            }
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void run() {
        sort();
    }
}
