package com.github.telesens.group.afanasiev.module_2_03;

import java.util.Scanner;

/**
 * Created by oleg on 12/4/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-----------Reverse sentence----------");
        String str = inputSentence();
        System.out.printf("Reversed sentence: %n%s %n", reverseSentence(str));
    }

    private static String inputSentence() {
        System.out.println("Input the same sentence: ");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        return str;
    }

    private static String reverseSentence(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--)
            sb.append(words[i] + " ");

        return sb.toString();
    }
}
