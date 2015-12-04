package com.github.telesens.group.afanasiev.module_2_03;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * Created by oleg on 12/4/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("------------Reverse substring-----------");
        String str = "This is same string from exercise 3.3";

        System.out.println("String: ");
        System.out.println(str);

        printReverse(str, 15);
    }

    private static void printReverse(String str, int i) {
        if (i > str.length() - 1)
            return;

        CharacterIterator it = new StringCharacterIterator(str);
        for (char ch = it.setIndex(i); ch != it.DONE; ch = it.previous()) {
            System.out.print(ch);
        }
    }
}
