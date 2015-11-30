package com.github.telesens.group.afanasiev.module_1_04;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by oleg on 26.11.15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the line: ");
        String str = scanner.nextLine();

        System.out.println(Abbr.get(str));
        System.out.printf("");
    }
}
