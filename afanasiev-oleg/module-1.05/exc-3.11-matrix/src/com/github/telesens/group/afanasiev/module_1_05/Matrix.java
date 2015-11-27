package com.github.telesens.group.afanasiev.module_1_05;
import java.util.Random;

/**
 * Created by oleg on 11/25/15.
 */
public class Matrix implements Cloneable {
    private String name;
    private double[][] arr;

    public Matrix(String name, int rows, int cols) {
        this.name = name;
        arr = new double[rows][cols];
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEl(double val, int row, int col) {
        if (row < 1 || row > getRows() || col < 1 || col > getCols())
            throw new ArrayIndexOutOfBoundsException();

        arr[row - 1][col - 1] = val;
    }

    public double getEl(int row, int col) {
        if (row < 1 || row > getRows() || col < 1 || col > getCols())
            throw new ArrayIndexOutOfBoundsException();

        return arr[row - 1][col - 1];
    }

    public int getRows() {
        return arr.length;
    }

    public int getCols() {
        return arr[0].length;
    }

    @Override
    public String toString() {
        StringBuilder strSB = new StringBuilder();

        strSB.append(name + ":\n");
        for (int r = 1; r <= getRows(); r++) {
            strSB.append("| ");
            for (int c = 1; c <= getCols(); c++) {
                strSB.append(String.format("%6.2f ", getEl(r, c)));
            }
            strSB.append(" |\n");
        }

        return strSB.toString();
    }

    @Override
    protected Matrix clone() throws CloneNotSupportedException {
        Matrix matrixCloned = (Matrix) super.clone();
        matrixCloned.arr = arr.clone();

        for (int i = 0; i < arr.length; i++)
            matrixCloned.arr[i] = arr[i].clone();

        return matrixCloned;
    }

    @Override
    public boolean equals(Object obj) {
        Matrix matr = (Matrix)obj;
        if (!this.getName().equals(matr.getName()))
            return false;

        for (int r = 1; r <= getRows(); r++) {
            for (int c = 1; c <= getCols(); c++) {
                if (this.getEl(r, c) != matr.getEl(r, c))
                    return false;
            }
        }
        return true;
    }

    public void initRandom(double min, double max) {
        Random random = new Random();
        for (int r = 1; r <= getRows(); r++) {
            for (int c = 1; c <= getCols(); c++) {
                setEl(min + random.nextDouble() * (max - min), r, c);
            }
        }
    }
}
