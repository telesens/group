package com.github.telesens.group.afanasiev.module_1_07;

import java.util.Scanner;

/**
 * Created by oleg on 11/22/15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dNext;

        try(Arr myArr = new Arr(5)) {
            for (int i = 0 ; i <= 5; i++) {
                System.out.print("Enter the double value: ");
                dNext = scanner.nextDouble();
                myArr.insert(dNext, i);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}