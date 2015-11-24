package com.github.telesens.group.afanasiev.module_2_01;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by oleg on 11/24/15.
 */
public class Main {
    private static final int DIGITS = 30;
    private static final int N = 50;

    public static void main(String[] args) {
        BigInteger bigInt = lazyInit(DIGITS);
        //bigInt = explicitInit(DIGITS);
        //bigInt = initByString(DIGITS);
        System.out.printf("bigInt = %d %n", bigInt);

        BigInteger pow = bigInt.pow(N);
        System.out.printf("bigInt^%d = %d %n", N, pow);

        BigInteger powMult  = powByMult(bigInt, N);
        System.out.printf("bigInt^%d = %d %n", N, powMult);

        System.out.printf("\nCheck results by subtraction: %d %n", powMult.subtract(pow));
    }

    private static BigInteger lazyInit(int digits) {
        int bits = (int)(digits * Math.log(10)/Math.log(2));

        return new BigInteger(bits, new Random());
    }

    private static BigInteger explicitInit(int digits) {
        Random random = new Random();
        int nextDigit;

        BigInteger bigInt = BigInteger.ZERO;

        for (int i = 1; i <= digits; i++) {
            nextDigit = random.nextInt(10);
            bigInt =  bigInt.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(nextDigit));
        }
        return bigInt;
    }

    private static BigInteger initByString(int digits) {
        Random random = new Random();
        StringBuilder bigNumberSB = new StringBuilder();

        for (int i = 1; i <= digits; i++) {
            bigNumberSB.append(random.nextInt(10));
        }

        return new BigInteger(bigNumberSB.toString());
    }

    private static BigInteger powByMult(BigInteger bigInt, int N) {

        BigInteger pow = bigInt.add(BigInteger.ZERO);
        for (int i = 1; i < N; i++) {
            pow = pow.multiply(bigInt);
        }

        return pow;
    }
}
