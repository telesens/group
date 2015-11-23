package com.github.telesens.group.afanasiev.matrices;

import java.util.Arrays;

/**
 * Created by oleg on 11/23/15.
 */
public class Main {
    public static void main(String[] args) {
        testMatrix3x3();
        //testMatrix4x4();
    }

    private static void testMatrix3x3() {
        MatrixArr M = new MatrixArr(3);

        M.set(1, 1, 1);
        M.set(2, 1, 2);
        M.set(3, 1, 3);

        M.set(0, 2, 1);
        M.set(1, 2, 2);
        M.set(4, 2, 3);

        M.set(5, 3, 1);
        M.set(6, 3, 2);
        M.set(0, 3, 3);

//        M.set(2, 1, 1);
//        M.set(1, 1, 2);
//        M.set(-1, 1, 3);
//
//        M.set(5, 2, 1);
//        M.set(2, 2, 2);
//        M.set(4, 2, 3);
//
//        M.set(7, 3, 1);
//        M.set(3, 3, 2);
//        M.set(2, 3, 3);

//        MatrixArr invM = (MatrixArr)M.inverse();
//
        System.out.println("-----test matrix 3x3-------\n");
        System.out.println("M: ");
        System.out.println(M);

        System.out.printf("det(M) = %.2f %n%n", M.determinant());
//        System.out.printf("1/M = %n%s %n%n", invM);
//
//        System.out.printf("M * 1/M = %n%s %n", M.mult(invM));
//        System.out.printf("1/M * M = %n%s %n", invM.mult(M));
//        System.out.println("-----------------------------\n");
    }

    private static void testMatrix4x4() {
        MatrixArr2D M = new MatrixArr2D(4);

        M.set(2, 1, 1);
        M.set(3, 1, 2);
        M.set(3, 1, 3);
        M.set(1, 1, 4);

        M.set(3, 2, 1);
        M.set(5, 2, 2);
        M.set(3, 2, 3);
        M.set(2, 2, 4);

        M.set(5, 3, 1);
        M.set(7, 3, 2);
        M.set(6, 3, 3);
        M.set(2, 3, 4);

        M.set(4, 4, 1);
        M.set(4, 4, 2);
        M.set(3, 4, 3);
        M.set(1, 4, 4);

//        M.set(2, 0, 0);
//        M.set(1, 0, 1);
//        M.set(-1, 0, 2);
//
//        M.set(5, 1, 0);
//        M.set(2, 1, 1);
//        M.set(4, 1, 2);
//
//        M.set(7, 2, 0);
//        M.set(3, 2, 1);
//        M.set(2, 2, 2);

        MatrixArr2D invM = (MatrixArr2D)M.inverse();

        System.out.println("-----test matrix 4x4-------\n");
        System.out.println("M: ");
        System.out.println(M);

        System.out.printf("det(M) = %.2f %n%n", M.determinant());
        System.out.printf("1/M = %n%s %n%n", invM);

        System.out.printf("M * 1/M = %n%s %n", M.mult(invM));
        System.out.printf("1/M * M = %n%s %n", invM.mult(M));
        System.out.println("-----------------------------\n");
    }
}
