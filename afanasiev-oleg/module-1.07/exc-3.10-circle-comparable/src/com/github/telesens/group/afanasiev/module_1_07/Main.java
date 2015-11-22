package com.github.telesens.group.afanasiev.module_1_07;

import java.util.Arrays;

/**
 * Created by oleg on 11/21/15.
 */
public class Main {
    private static Circle[] circles;
    private static final int N = 5;

    public static void main(String[] args) {
        System.out.println("*******test 'Comparable'*******");
        init();
        System.out.println("\nBefore sorting:");
        System.out.println(Arrays.toString(circles));
        System.out.println("\nAfter sorting:");
        Arrays.sort(circles);
        System.out.println(Arrays.toString(circles));
    }

    private static void init() {
        circles = new Circle[N];

        for (int i = 0; i < N; i++)
            circles[i] = new Circle(20 - i);
    }
}
