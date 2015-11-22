package com.github.telesens.group.afanasiev.module_1_03;

/**
 * Created by oleg on 11/18/15.
 */
public class Main {
    public static void main(String[] args) {

        byte n;
        System.out.print("Enter the number: ");
        try {
            n = Byte.parseByte(System.console().readLine());
        } catch(Exception ex) {
            System.err.println("You couldn't run this programm on IDEA");
            return;
        }

        System.out.printf("n = %d%n", n);
        System.out.printf("binary reverse = ");

        for (int i = 0; i < 8; i++) {
            System.out.print((byte)(1 & (n >> i)));
        }
        System.out.println();
    }
}
