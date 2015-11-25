package com.github.telesens.group.afanasiev.module_1_05;

/**
 * Created by oleg on 11/25/15.
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("-------Test Matrix------");
        Matrix matrix = new Matrix("Matrix from Olegjan", 8, 12);
        matrix.initRandom(-2, 5);

        Matrix matrixCloned = matrix.clone();

        System.out.println(matrix);
        System.out.println("\nclonedMatrix: ");
        System.out.println(matrixCloned);

        System.out.println("\nmatrix == matrixCloned: " + matrix.equals(matrixCloned));

        matrixCloned.setName("Matrix cloned");
        matrixCloned.setEl(666, 1, 1);
        System.out.println("\nCloned matrix after changed: ");
        System.out.println(matrix);
        System.out.println(matrixCloned);

        System.out.println("\nmatrix == matrixCloned: " + matrix.equals(matrixCloned));
    }
}
