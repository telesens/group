package com.github.telesens.group.afanasiev.module_2_03;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by oleg on 12/4/15.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("-------------------Real number are shown in avialable locales-------------------\n");
        double d = input();
        printAllLocale(d);
    }

    private static double input() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the real number (for example 3.14): ");
            return scanner.nextDouble();
        } catch(InputMismatchException exc) {
            System.out.println("Incorrect number. Please, try again.");
            return input();
        }
    }

    private static void printAllLocale(double d) {
        Locale[] locales = NumberFormat.getAvailableLocales();

        for (Locale locale : locales) {
            NumberFormat numberFormat = NumberFormat.getInstance(locale);
            System.out.printf("%40s : %s %n", locale.getDisplayName(), numberFormat.format(d));
        }
    }
}
