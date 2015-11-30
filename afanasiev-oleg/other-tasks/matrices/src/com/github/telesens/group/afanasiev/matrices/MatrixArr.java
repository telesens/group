package com.github.telesens.group.afanasiev.matrices;
/**
 * Created by oleg on 11/23/15.
 */
public class MatrixArr extends AbstractMatrix {
    private double[] arr;
    private int size;

    public MatrixArr(int size) {
        if (size <= 0 || size > 64)
            throw new NegativeArraySizeException("Incorrect size of array");

        this.size = size;
        arr = new double[size * size];
    }

    @Override
    public double getEl(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size)
            throw new ArrayIndexOutOfBoundsException();

        return arr[row * size + col];
    }

    @Override
    public void setEl(double val, int row, int col) {
        if (row < 0 || row >= getSize() || col < 0 || col > getSize())
            throw new ArrayIndexOutOfBoundsException();

        arr[row * size + col] = val;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected  MatrixArr createMatrix(int size) {
        return new MatrixArr(size);
    }
}
