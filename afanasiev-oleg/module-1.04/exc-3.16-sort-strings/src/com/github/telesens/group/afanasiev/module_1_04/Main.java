package com.github.telesens.group.afanasiev.module_1_04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by oleg on 11/29/15.
 */
public class Main {
    private static String[] lines;
    public static void main(String[] args) {
        try {
            init();
        } catch(InputMismatchException ex) {
            System.out.println("Incorrect number");
            return;
        }

        sort();
        System.out.printf("%n All the words: %s %n", getWordsAsLine());
    }

    private static void init() throws InputMismatchException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");

        int n = scanner.nextInt();
        scanner.nextLine();

        lines = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter line %d: ", i + 1);
            lines[i] = scanner.nextLine();
        }
    }

    private static void sort() {
        Arrays.sort(lines);
    }

    private static String getWordsAsLine() {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lines.length; i++) {
            st = new StringTokenizer(lines[i]);

            while(st.hasMoreTokens())
                sb.append(st.nextToken() + " ");
        }

        return sb.toString();
    }
 }
