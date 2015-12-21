package com.github.telesens.group.afanasiev.module_2_06;

/**
 * Created by oleg on 12/21/15.
 */
public class Array {

    public static synchronized void print(String name, int... arr) throws InterruptedException{
        System.out.println(name + " sort: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            Thread.sleep(100);
        }

        System.out.println();
    }
}
