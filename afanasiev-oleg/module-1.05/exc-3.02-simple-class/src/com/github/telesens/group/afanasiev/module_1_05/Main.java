package com.github.telesens.group.afanasiev.module_1_05;

/**
 * Created by oleg on 11/24/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("----------Test simple class----------\n");
        Simple simpleTShirt = new Simple("T-shirt", 200.00);
        Simple jacket = new Simple("Jacket", 344.45);

        System.out.printf("%s %n %s %n", simpleTShirt, jacket);
    }
}
