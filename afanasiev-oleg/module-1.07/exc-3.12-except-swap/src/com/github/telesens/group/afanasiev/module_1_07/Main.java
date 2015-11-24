package com.github.telesens.group.afanasiev.module_1_07;

import java.util.Arrays;

/**
 * Created by oleg on 11/24/15.
 */
public class Main {
    public static void main(String[] args) {
        int i = 0;
        int j = 2;

        Double[] dArr = {4.2, 5.4, 6.6, 7.1};
        Integer[] iArr = {4, 5, 6, 8};

        System.out.println("---test arrays swap----\n");

        System.out.printf("dArr = %s %n", Arrays.toString(dArr));
        System.out.printf("iArr = %s %n%n", Arrays.toString(iArr));

        LibArray.swap(dArr, i, j);
        LibArray.swap(iArr, i, j);
        System.out.printf("Swap by indexes %d and %d %n", i, j);
        System.out.printf("dArr = %s %n", Arrays.toString(dArr));
        System.out.printf("iArr = %s %n%n", Arrays.toString(iArr));

        System.out.println("-----test exception----");
        try {
            LibArray.swap(dArr, 0, 10);
        }  catch(LibArrExc exc) {
            exc.printError();
        }

    }
}
