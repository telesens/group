package com.github.telesens.group.afanasiev.module_1_07;

import ua.in.iwanoff.lesson107.MyArray;

import java.util.Arrays;

/**
 * Created by oleg on 11/23/15.
 */
public class Main {
    private static final int DOUBLE_N = 5;
    private static final int INTEGER_N = 7;
    private static final int FROM = 2;
    private static final int TO = 4;

    private static Integer[] intArr;
    private static Double[] doubleArr;
    private static MyArray myDArr;
    private static MyArray myIArr;

    public static void main(String[] args) {
        System.out.println("------------Test 'MyArrayLib'-----------------");
        init();
        add();
        print();
    }

    private static void init() {
        intArr = new Integer[INTEGER_N];
        doubleArr = new Double[DOUBLE_N];
        for (int i = 0; i < DOUBLE_N; i++)
            doubleArr[i] = (double)i * 3 / 5;

        for (int i = 0; i < INTEGER_N; i++)
            intArr[i] = i * 2;

        myIArr = new MyArray(intArr);
        myDArr = new MyArray(doubleArr);
    }

    private static void add() {
        MyArrayLib.addRange(myIArr, intArr, FROM, TO);
        MyArrayLib.addRange(myDArr, intArr, FROM, TO);
    }

    private static void print() {
        System.out.printf("\ndoubleArr: %s %n ", Arrays.toString(doubleArr));
        System.out.printf("intArr: %s %n", Arrays.toString(intArr));

        System.out.printf("\nAdd from intArr of diapason [%d, %d) %n", FROM, TO);

        System.out.printf("\nmyIArr: %s %n ", myIArr);
        System.out.printf("myDArr: %s %n ", myDArr);
    }
}
