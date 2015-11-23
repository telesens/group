package com.github.telesens.group.afanasiev.module_1_07;

/**
 * Created by oleg on 11/23/15.
 */
public class LibArrNum {
    public static<T extends Number> int indefOfZero(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].doubleValue() == 0)
                return i;
        }

        return -1;
    }

    public static <T extends Number> int numberNegativs(T[] arr) {
        int n = 0;

        for (T el : arr) {
            if (el.doubleValue() < 0)
                n++;
        }

        return n;
    }

    public static <T extends Number> T lastNegative(T[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].doubleValue() < 0)
                return arr[i];
        }

        return (T)new Integer(-1);
    }
}
