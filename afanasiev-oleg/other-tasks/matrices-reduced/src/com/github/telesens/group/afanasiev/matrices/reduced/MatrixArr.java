package com.github.telesens.group.afanasiev.matrices.reduced;
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
        return arr[row * size + col];
    }

    @Override
    public void setEl(double val, int row, int col) {
        arr[row * size + col] = val;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected  MatrixArr createMatrix() {
        return new MatrixArr(size);
    }

    @Override
    protected AbstractMatrix getMinor(int r,  int c, AbstractMatrix base) {
        return new ReducedMatrix(r, c, this);
    }
}
