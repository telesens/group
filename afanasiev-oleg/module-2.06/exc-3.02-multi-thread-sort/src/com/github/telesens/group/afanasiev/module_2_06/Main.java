package com.github.telesens.group.afanasiev.module_2_06;

/**
 * Created by oleg on 12/20/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--------Multi threading--------");
        Thread t1 = new Thread(new BubbleSort(3, 1, 6, 2, 7, 4));
        Thread t2 = new Thread(new InsertionSort(3, 1, 6, 2, 7, 4));
        Thread t3 = new Thread(new SelectionSort(3, 1, 6, 2, 7, 4));

        t1.start();
        t2.start();
        t3.start();
    }
}
