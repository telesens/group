package com.github.telesens.group.afanasiev.module_1_03;

/**
 * Created by oleg on 11/18/15.
 */
public class Main {
    public static void main(String[] args) {
        byte number = 9;
        byte bit;
        boolean firstUnit = false;

        for (int i = 7; i >= 0; i--) {
            bit = (byte)(1 & (number >> i));
            if (bit == 0 && !firstUnit) {
                continue;
            }
            else {
                firstUnit = true;
                System.out.print(bit);
            }

        }
    }
}
