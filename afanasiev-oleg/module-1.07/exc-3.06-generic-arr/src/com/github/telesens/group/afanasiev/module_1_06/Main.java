package com.github.telesens.group.afanasiev.module_1_06;

import java.util.DoubleSummaryStatistics;

/**
 * Created by oleg on 11/22/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- test generic array----\n");
        testArrInteger();
        testArrDouble();
        testArrChar();
        testArrString();
        testArrBool();
    }

    private static void testArrInteger() {
        final int N = 5;

        Arr<Integer> arr = new Arr<Integer>(N);
        Integer[] src = {101, 102, 103, 104, 105};

        for (int i = 0; i < N; i++) {
            arr.setAt(i*2, i);
        }

        System.out.print("Integer arr: ");
        System.out.println(arr);

        arr.setAt(666, 3);
        System.out.println("\nSet new value by index 3");
        System.out.print("Integer arr: ");
        System.out.println(arr);

        arr.deleteAt(3);
        System.out.println("\nDelete value by index 3");
        System.out.print("Integer arr: ");
        System.out.println(arr);

        arr.addRange(src, 1, 4);
        System.out.println("\nAdd group");
        System.out.print("Integer arr: ");
        System.out.println(arr);

        System.out.println("\n-------------------------");
    }

    private static void testArrDouble() {
        final int N = 5;

        Arr<Double> arr = new Arr<Double>(N);
        Double[] src = {101.0, 102.0, 103.0, 104.0, 105.0};

        for (int i = 0; i < N; i++) {
            arr.setAt(i*2.0, i);
        }

        System.out.print("\nDouble arr: ");
        System.out.println(arr);

        arr.setAt(666.0, 3);
        System.out.println("\nSet new value by index 3");
        System.out.print("Double arr: ");
        System.out.println(arr);

        arr.deleteAt(3);
        System.out.println("\nDelete value by index 3");
        System.out.print("Double arr: ");
        System.out.println(arr);

        arr.addRange(src, 1, 4);
        System.out.println("\nAdd group");
        System.out.print("Double arr: ");
        System.out.println(arr);

        System.out.println("\n-------------------------");
    }

    private static void testArrChar() {
        final int N = 5;

        Arr<Character> arr = new Arr<Character>(N);
        Character[] src = {'1', '2', '3', '4', '5'};

        for (int i = 0; i < N; i++) {
            arr.setAt(Character.toChars(100 + i)[0], i);
        }

        System.out.print("\nCharacter arr: ");
        System.out.println(arr);

        arr.setAt('Y', 3);
        System.out.println("\nSet new value by index 3");
        System.out.print("Character arr: ");
        System.out.println(arr);

        arr.deleteAt(3);
        System.out.println("\nDelete value by index 3");
        System.out.print("Character arr: ");
        System.out.println(arr);

        arr.addRange(src, 1, 4);
        System.out.println("\nAdd group");
        System.out.print("Character arr: ");
        System.out.println(arr);

        System.out.println("\n-------------------------");
    }

    private static void testArrString() {
        final int N = 5;

        Arr<String> arr = new Arr<String>(N);
        String[] src = {"one", "two", "three", "four", "five"};

        for (int i = 0; i < N; i++) {
            arr.setAt(String.format("%d", i), i);
        }

        System.out.print("\nString arr: ");
        System.out.println(arr);

        arr.setAt("Olegjan", 3);
        System.out.println("\nSet new value by index 3");
        System.out.print("String arr: ");
        System.out.println(arr);

        arr.deleteAt(3);
        System.out.println("\nDelete value by index 3");
        System.out.print("String arr: ");
        System.out.println(arr);

        arr.addRange(src, 1, 4);
        System.out.println("\nAdd group");
        System.out.print("String arr: ");
        System.out.println(arr);

        System.out.println("\n-------------------------");
    }

    private static void testArrBool() {
        final int N = 5;

        Arr<Boolean> arr = new Arr<Boolean>(N);
        Boolean[] src = {false, true, true, false, false};

        for (int i = 0; i < N; i++) {
            arr.setAt(i < N/2 ? true : false, i);
        }

        System.out.print("\nBoolean arr: ");
        System.out.println(arr);

        arr.setAt(true, 3);
        System.out.println("\nSet new value by index 3");
        System.out.print("Boolean arr: ");
        System.out.println(arr);

        arr.deleteAt(3);
        System.out.println("\nDelete value by index 3");
        System.out.print("Boolean arr: ");
        System.out.println(arr);

        arr.addRange(src, 1, 4);
        System.out.println("\nAdd group");
        System.out.print("Boolean arr: ");
        System.out.println(arr);

        System.out.println("\n-------------------------");
    }
}
