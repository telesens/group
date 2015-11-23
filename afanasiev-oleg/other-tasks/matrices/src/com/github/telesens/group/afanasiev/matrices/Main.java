package com.github.telesens.group.afanasiev.matrices;

/**
 * Created by oleg on 11/23/15.
 */
public class Main {
    public static void main(String[] args) {
        testMatrix3x3();
        testMatrix4x4();
        //testMatrix10x10();
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

        MatrixArr invM = (MatrixArr)M.inverse();

        System.out.println("-----test matrix 3x3-------\n");
        System.out.println("M: ");
        System.out.println(M);

        System.out.printf("det(M) = %.2f %n%n", M.determinant());
        System.out.printf("1/M = %n%s %n%n", invM);

        System.out.printf("M * 1/M = %n%s %n", M.mult(invM));
        System.out.printf("1/M * M = %n%s %n", invM.mult(M));
        System.out.println("-----------------------------\n");
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

    private static void testMatrix10x10() {
        final int N = 10;
        MatrixArr M = new MatrixArr(N);

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++) {
                M.set( i == j ? 1 : 0, i, j);
            }

        MatrixArr invM = (MatrixArr)M.inverse();

        System.out.println("-----test matrix 10x10-------\n");
        System.out.println("M: ");
        System.out.println(M);

        System.out.printf("det(M) = %.2f %n%n", M.determinant());
        System.out.printf("1/M = %n%s %n%n", invM);

        System.out.printf("M * 1/M = %n%s %n", M.mult(invM));
        System.out.printf("1/M * M = %n%s %n", invM.mult(M));
        System.out.println("-----------------------------\n");
    }
}
