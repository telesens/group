package com.github.telesens.group.afanasiev.module_2_02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by oleg on 12/1/15.
 */
public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String str = input();
        check(str);
    }

    private static String input() {
        System.out.println("Enter the line with paranthesises: ");
        String str = new Scanner(System.in).nextLine();

        return str;
    }

    private static void check(String str) {
        Deque<Character> dq = new ArrayDeque<>();
        Character ch;

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == '(' && !intoQuotes(str, i)) {
                dq.push(ch);
                continue;
            }

            if (ch == ')' && !intoQuotes(str, i)) {
                if (dq.isEmpty()) {
                    System.out.println("Error. Closing parenthesis before opening one");
                    return;
                } else
                    dq.pop();
            }
        }

        if (dq.isEmpty())
            System.out.println("Line is correct");
        else
            System.out.println("Error. Closing parenthesises are more then the opening");
    }

    private static boolean intoQuotes(String str, int i) {
        if (i == 0 || i == str.length() - 1)
            return false;

        char ch = str.charAt(i - 1);

        if ( (ch == '\'' || ch == '"') && ch == str.charAt(i + 1))
            return true;

        return false;
    }
}
