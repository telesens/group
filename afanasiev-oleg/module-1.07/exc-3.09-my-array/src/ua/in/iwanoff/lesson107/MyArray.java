package ua.in.iwanoff.lesson107;

import java.util.Arrays;

/**
 * Created by oleg on 11/24/15.
 */
public class MyArray<T> {
    private Object[] arr;

    public MyArray(T... arr) {
        this.arr = arr;
    }

    public int size() {
        return arr.length;
    }

    public T get(int i) {
        return (T)arr[i];
    }

    public void set(int i, T t) {
        arr[i] = t;
    }

    public void add(T t) {
        Object[] temp = new Object[arr.length + 1];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
        arr[arr.length - 1] = t;
    }

    public void printAll() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

}
