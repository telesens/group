package com.github.telesens.group.afanasiev.module_2_04;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by oleg on 12/5/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-----------Copy all short lines from file \"src.txt\" to \"dst.txt\"");

        int length = inputLengthLine();
        System.out.println("length = " + length);
        copyShortLines(length);
    }

    private static int inputLengthLine() {
        Scanner scanner = new Scanner(System.in);
        int length;

        System.out.print("Enter max length of the lines: ");

        try {
            length = scanner.nextInt();
        } catch(InputMismatchException exc) {
            System.out.println("Incorrect number. Please, try again.");
            return inputLengthLine();
        }

        if (length < 0) {
            System.out.println("Length should by positive. Please, try again.");
            return inputLengthLine();
        }

        return length;
    }

    private static void copyShortLines(int length) {
        String nextLine;

        try (Scanner scanner = new Scanner(new FileReader("resources/src.txt"));
                PrintWriter pw = new PrintWriter(new FileWriter("resources/dst.txt"))){
            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                if (nextLine.length() <= length) {
                    System.out.println(nextLine);
                    pw.println(nextLine);
                }
            }

        } catch(IOException | NoSuchElementException exc) {
            exc.printStackTrace();
        }
    }
}
