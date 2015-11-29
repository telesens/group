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
        if (row <= 0 || row > size || col <= 0 || col > size)
            throw new ArrayIndexOutOfBoundsException();

        int l = (int)Math.sqrt(arr.length);
        int ind = (row - 1) * l + col - 1;
        return arr[ind];
    }

    @Override
    public void setEl(double val, int row, int col) {
        if (row <= 0 || row > getSize() || col <= 0 || col > getSize())
            throw new ArrayIndexOutOfBoundsException();

        int ind = (row - 1) * size + col - 1;
        arr[ind] = val;
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
