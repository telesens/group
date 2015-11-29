package com.github.telesens.group.afanasiev.matrices;

/**
 * Created by oleg on 11/23/15.
 */
public class Main {
    public static void main(String[] args) {
        testMatrix2x2();
        testMatrix3x3();
        testMatrix4x4();
        testMatrix11x11();
    }

    private static void testMatrix2x2() {
        MatrixArr2D mat2x2 = new MatrixArr2D(2);
        mat2x2.setEl(1, 1, 1);
        mat2x2.setEl(2, 1, 2);
        mat2x2.setEl(5, 2, 1);
        mat2x2.setEl(3, 2, 2);

        System.out.println("\n---------------test matrix 3x3-----------------\n");
        System.out.println("M: ");
        System.out.println(mat2x2);

        System.out.printf("det(M) = %.2f %n%n", mat2x2.determinant());
        MatrixArr2D invM = (MatrixArr2D)mat2x2.inverse();
        System.out.printf("1/M = %n%s %n%n", invM);

        System.out.printf("M * 1/M = %n%s %n", mat2x2.mult(invM));
        System.out.printf("1/M * M = %n%s %n", invM.mult(mat2x2));
    }

    private static void testMatrix3x3() {
        MatrixArr M = new MatrixArr(3);

        M.setEl(1, 1, 1);
        M.setEl(2, 1, 2);
        M.setEl(3, 1, 3);

        M.setEl(0, 2, 1);
        M.setEl(1, 2, 2);
        M.setEl(4, 2, 3);

        M.setEl(5, 3, 1);
        M.setEl(6, 3, 2);
        M.setEl(0, 3, 3);

        System.out.println("\n---------------test matrix 3x3-----------------\n");
        System.out.println("M: ");
        System.out.println(M);

        System.out.printf("det(M) = %.2f %n%n", M.determinant());
        MatrixArr invM = (MatrixArr)M.inverse();
        System.out.printf("1/M = %n%s %n%n", invM);

        System.out.printf("M * 1/M = %n%s %n", M.mult(invM));
        System.out.printf("1/M * M = %n%s %n", invM.mult(M));
    }

    private static void testMatrix4x4() {
        MatrixArr2D M = new MatrixArr2D(4);

        M.setEl(2, 1, 1);
        M.setEl(3, 1, 2);
        M.setEl(3, 1, 3);
        M.setEl(1, 1, 4);

        M.setEl(3, 2, 1);
        M.setEl(5, 2, 2);
        M.setEl(3, 2, 3);
        M.setEl(2, 2, 4);

        M.setEl(5, 3, 1);
        M.setEl(7, 3, 2);
        M.setEl(6, 3, 3);
        M.setEl(2, 3, 4);

        M.setEl(4, 4, 1);
        M.setEl(4, 4, 2);
        M.setEl(3, 4, 3);
        M.setEl(1, 4, 4);

        MatrixArr2D invM = (MatrixArr2D)M.inverse();

        System.out.println("\n---------------test matrix 4x4-----------------\n");
        System.out.println("M: ");
        System.out.println(M);

        System.out.printf("det(M) = %.2f %n%n", M.determinant());
        System.out.printf("1/M = %n%s %n%n", invM);

        System.out.printf("M * 1/M = %n%s %n", M.mult(invM));
        System.out.printf("1/M * M = %n%s %n", invM.mult(M));
    }

    private static void testMatrix11x11() {
        final int N = 11;
        MatrixArr2D M = new MatrixArr2D(N);

        M.initRandom(0, 10);

        System.out.println("\n---------------test matrix 11x11-----------------\n");
        System.out.println("M: ");
        System.out.println(M);

        System.out.printf("det(M) = %.2f %n%n", M.determinant());
        MatrixArr2D invM = (MatrixArr2D)M.inverse();
        System.out.printf("1/M = %n%s %n%n", invM);

        System.out.printf("M * 1/M = %n%s %n", M.mult(invM));
        System.out.printf("1/M * M = %n%s %n", invM.mult(M));
    }
}
