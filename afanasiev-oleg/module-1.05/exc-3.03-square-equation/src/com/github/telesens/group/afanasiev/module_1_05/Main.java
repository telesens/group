package com.github.telesens.group.afanasiev.module_1_05;

/**
 * Created by oleg on 11/25/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-----Test square equation----");
        try {
            SquareEquation eq1 = new SquareEquation(3, 6, -24);
            SquareEquation eq2 = new SquareEquation(1, 1, 1);

            double x1 = eq1.x1();
            double x2 = eq1.x2();

            System.out.printf("Equation 1: %s %n", eq1);
            System.out.printf("D = %.4f %n", eq1.discriminant());
            System.out.printf("x1 = %.4f, x2 = %.4f %n", x1, x2);

            System.out.println("\n----------------------");
            System.out.printf("Equation 2: %s %n", eq2);
            System.out.println("printsolve()");
            eq2.printSolve();
        } catch(SquareEquation.SquareInitError | SquareEquation.SquareSolveError err) {
            System.err.println(err);
        }


    }
}
