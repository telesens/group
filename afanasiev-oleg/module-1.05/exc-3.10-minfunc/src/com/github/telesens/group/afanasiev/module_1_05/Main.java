package com.github.telesens.group.afanasiev.module_1_05;

/**
 * Created by oleg on 11/16/15.
 */
public class Main {
    public static void main(String[] args) {
        FSquare fSquare = new FSquare();
        FSin fSin = new FSin();
        System.out.printf("min of x^2 on [5, 10] = %.2f %n", fSquare.min(5, 10));
        System.out.printf("min of sin on [-PI/2, PI/2] = %.2f %n", fSin.min(-Math.PI /2, Math.PI /2 ));
    }
}
