package com.github.telesens.group.afanasiev.module_2_06;

/**
 * Created by oleg on 12/21/15.
 */
public class SelectionSort implements Runnable {

    private int[] arr;

    public SelectionSort(int... arr) {
        this.arr = arr;
    }

    private void sort()  {
        int iMin;
        try {
            for (int i = 0; i < arr.length - 1; i++) {
                iMin = searchIMin(i);

                if (i != iMin) {
                    arr[i] = arr[i]^arr[iMin];
                    arr[iMin] = arr[i]^arr[iMin];
                    arr[i] = arr[i]^arr[iMin];
                    Array.print("Selection", arr);
                }
            }
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }

    private int searchIMin(int iFrom) {
        int iMin = iFrom;

        for (int i = iFrom; i < arr.length; i++)
            if (arr[i] < arr[iMin]) {
                iMin = i;
            }

        return iMin;
    }

    @Override
    public void run() {
        sort();
    }
}
