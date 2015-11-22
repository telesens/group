package com.github.telesens.group.afanasiev.module_1_04;

/**
 * Created by oleg on 11/14/15.
 */
public class Main {
    public static void main(String[] args) {
        SieveEratosthenen sieve = new SieveEratosthenen(300);
        sieve.print();
        System.out.println();
        sieve.printOnlyPrime();
    }
}
