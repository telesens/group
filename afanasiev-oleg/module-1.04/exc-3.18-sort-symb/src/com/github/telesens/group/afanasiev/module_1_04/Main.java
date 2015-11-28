package com.github.telesens.group.afanasiev.module_1_04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by oleg on 11/28/15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the line: ");
        String str = scanner.nextLine();
        System.out.printf("Result: %s %n", sortBySymbols(delNumeric(str)));
    }

    private static String delNumeric(String str) {
        StringBuilder sb = new  StringBuilder();
        char[] chars = str.toCharArray();

        for (char ch : chars) {
            if (ch >= '0' && ch <= '9')
                continue;

            sb.append(ch);
        }

        return sb.toString();
    }

    private static String sortBySymbols(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(chars);
        for (char ch : chars)
            sb.append(ch);

        return sb.toString();
    }
}
