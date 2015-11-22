package com.github.telesens.group.afanasiev.module_1_07;

/**
 * Created by oleg on 11/22/15.
 */
public class LibArr {
    public static<T> void swap(T[] src, int i, int j) {
        if (i < 0 || i >= src.length || j < 0 || j >= src.length )
            throw new ArrayIndexOutOfBoundsException();

        T tmp = src[i];
        src[i] = src[j];
        src[j] = tmp;
    }

    public static<T> void reverse(T[] src) {
        for (int i = 0; i < src.length/2; i++)
            swap(src, i, src.length - 1 - i);
    }

    public static<T> int nOccurrence(T[] src, T el) {
        int n = 0;
        for (T aSrc : src) {
            if (aSrc.equals(el))
                n++;
        }

        return n;
    }

    public static<T> int nOccurrence(T[] src, Integer i) {
        int n = 0;
        for (T aSrc : src) {
            if (aSrc == src[i])
                n++;
        }
        return n;
    }
}
