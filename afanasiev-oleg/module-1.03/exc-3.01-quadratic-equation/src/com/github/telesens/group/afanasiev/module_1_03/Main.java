package com.github.telesens.group.afanasiev.module_1_03;

/**
 * Created by oleg on 12/1/15.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("quadratic-equation");
        QuadraticEquation eq = new QuadraticEquation(-1, -1, -4.2);
        System.out.println(eq);

        printRealSolutions(eq);
        printComplexSolutions(eq);
    }

    private static void printRealSolutions(QuadraticEquation eq) {
        int nRoots = eq.nRealRoots();
        System.out.printf("\nAmount of real roots: %d %n", nRoots);

        if (nRoots == 0)
            System.out.println("There is not real roots");
        else if (nRoots == 2)
            System.out.printf("x1 = %.2f %nx2 = %.2f %n", eq.X1(), eq.X2());
        else
            System.out.printf("x1 = %.2f %n", eq.X1());
    }

    private static void printComplexSolutions(QuadraticEquation eq) {
        int nRoots = eq.nComplexRoots();
        System.out.printf("\nAmount of complex roots: %d %n", nRoots);

        if (nRoots == 1)
            System.out.printf("z1 = %s %n", eq.Z1ToString());
        else
            System.out.printf("z1 = %s %nz1 = %s %n", eq.Z1ToString(), eq.Z2ToString());
    }
}
