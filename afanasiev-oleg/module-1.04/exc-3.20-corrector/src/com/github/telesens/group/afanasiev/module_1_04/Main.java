package com.github.telesens.group.afanasiev.module_1_04;

import java.util.Scanner;

/**
 * Created by oleg on 11/19/15.
 */
public class Main {
    public static void main(String[] args) {
        String testLine =
                "  Тестовая  сТРОКА, СТРОКА, коТоРая дОЛЖНа быть     оТкорРектироваНа автоматичесКИ Удачи в решении.  Неккоретные ьслова появляются Ьздесь! ";

        //Scanner scanner = new Scanner(System.in);
        //testLine = scanner.nextLine();

        String correctedLine = correct(testLine);

        System.out.println("Исходный текст: ");
        System.out.println(testLine);
        System.out.println("\nОткорректированный: ");
        System.out.println(correctedLine);

        System.out.println("\nСлова, начинающиеся на мягкий знак: ");
        printSoftSignWords(correctedLine);
    }

    private static String correct(String text) {
        text = trim(text);
        text = wordsToLowerCase(text);
        text = insertPoints(text);

        return text;
    }

    private  static String trim(String text) {
        return text.replaceAll(" {2,}", " ").trim();
    }

    private static String wordsToLowerCase(String text) {
        String[] words = text.split(" ");
        StringBuilder sbLine = new StringBuilder();
        StringBuilder sbWord = new StringBuilder();
        char firstSymb;

        for (int i = 0; i < words.length; i++) {
            sbWord.setLength(0);
            firstSymb = words[i].charAt(0);
            sbWord.append(words[i].toLowerCase());
            sbWord.setCharAt(0, firstSymb);
            sbLine.append(sbWord + " ");
        }

        return sbLine.toString().trim();
    }

    private static String insertPoints(String text) {
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder();
        char firstSymb;

        for (int i = 1; i < words.length; i++) {
            firstSymb = words[i].charAt(0);

            if (Character.isUpperCase(firstSymb)) {
                words[i-1] = insertPrevPoint(words[i-1]);
            }

            line.append(words[i - 1] + " ");
        }

        line.append(words[words.length - 1] + " ");

        return line.toString().trim();
    }

    private static String insertPrevPoint(String word) {
        StringBuilder sbWord = new StringBuilder(word);
        int l = sbWord.length() - 1;
        char lastChar = sbWord.charAt(l);

        if (Character.isLetterOrDigit(lastChar)) {
            sbWord.append(".");
        }
        else {
            sbWord.setCharAt(l, '.');
        }

        return sbWord.toString();
    }

    private static void printSoftSignWords(String text) {
        String[] words = text.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == 'ь' || words[i].charAt(0) == 'Ь')
                System.out.print(words[i] + ", ");
        }

        System.out.println();
    }
}
