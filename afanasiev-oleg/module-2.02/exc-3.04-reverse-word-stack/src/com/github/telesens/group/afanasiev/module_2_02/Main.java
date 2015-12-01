package com.github.telesens.group.afanasiev.module_2_02;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by oleg on 12/1/15.
 */
public class Main {
    private static String word;

    public static void main(String[] args) {
        System.out.println("Reverse the word using \"Stack\"");
        word = inputWord();
        word = reverse(word);
        System.out.printf("Result: %s %n", word);
    }

    private static String inputWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String word = scanner.next();

        return word;
    }

    private static String reverse(String word) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++)
            stack.push(word.charAt(i));

        StringBuilder sb = new StringBuilder();

        Character ch;

        while(stack.size() > 0) {
            ch = stack.pop();
            sb.append(ch);
        }

        return sb.toString();
    }
}
