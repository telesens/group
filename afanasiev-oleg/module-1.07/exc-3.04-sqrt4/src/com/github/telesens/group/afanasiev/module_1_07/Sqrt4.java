package com.github.telesens.group.afanasiev.module_1_07;

/**
 * Created by oleg on 11/22/15.
 */
public class Sqrt4 {
    static public class Sqrt4NegativeArgError extends Exception {
        private double arg;
        public Sqrt4NegativeArgError(double arg) {
            this.arg = arg;
        }
        public void printError() {
            System.err.println("Sqrt4NegativeArgError!");
            System.err.println("Sqrt4 can't be resolve with negative arg. ");
            System.err.printf("arg = %.2f %n", arg);
        }
    }

    static public double solve(double x) throws Sqrt4NegativeArgError{
        if (x < 0)
            throw new Sqrt4NegativeArgError(x);

        return Math.pow(x, 0.25);
    }
}
