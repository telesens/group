package com.github.telesens.group.afanasiev.module_1_07;

import ua.in.iwanoff.lesson107.MyArray;

/**
 * Created by oleg on 11/23/15.
 */
public class MyArrayLib {
    public static <T extends Number> void addRange(MyArray<T> myArrDest, Integer[] intSrc, int from, int to) {
        if (to < from)
            throw new IllegalArgumentException(from + " > " + to);

        for (int i = from; i < to; i++) {
            myArrDest.add((T)intSrc[i]);
        }
    }
}
