package com.github.telesens.group.afanasiev.module_2_02;

import java.util.*;

/**
 * Created by oleg on 12/1/15.
 */
public class Main {

    private static String str = "I'm awesome person. I love my life. All person that I know love own life.";

    public static void main(String[] args) {
        System.out.println("Test of sorting sentence by difference words");
        inputSentence();
        printSortedWords();
    }

    private static void inputSentence() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sentence: ");
        str = scanner.nextLine();
    }


    private static void printSortedWords() {
        System.out.println("Sorted by words: ");
        System.out.println(str);
        StringTokenizer st = new StringTokenizer(str);
        Set<String> words = new TreeSet<String>();

        while(st.hasMoreTokens()) {
            words.add(cleanWordFromToken(st.nextToken()));
        }

        System.out.println(words);
    }

    private static String cleanWordFromToken(String word) {
        int iLast = word.length()-1;

        for (; iLast >= 0; iLast--) {
            if (!isToken(word.charAt(iLast)))
                break;
        }

        return word.substring(0, iLast+1);
    }

    private static boolean isToken(char ch) {
        switch (ch) {
            case '.':
            case ',':
            case '"':
            case '\'':
            case '?':
            case '!':
            case '-':
            case ':':
            case ';':
                return true;
            default:
                return false;
        }
    }
}
