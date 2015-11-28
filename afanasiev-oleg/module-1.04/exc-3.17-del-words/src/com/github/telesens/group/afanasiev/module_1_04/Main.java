package com.github.telesens.group.afanasiev.module_1_04;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by oleg on 11/28/15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strLine;
        String strSeq;
        System.out.println("Enter the line: ");
        strLine = scanner.nextLine();

        System.out.println("Enter the sequence: ");
        strSeq = scanner.nextLine();

        System.out.printf("The line without words that contains inputed sequence: \"%s\" %n", delWordsBySeq(strLine, strSeq));

    }

    private static String delWordsBySeq(String str, String seqDel) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(str);
        String word;

        while (st.hasMoreTokens()) {
            word = st.nextToken();

            if (word.indexOf(seqDel) == -1) {
                sb.append(word);
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
