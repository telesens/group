package com.github.telesens.group.afanasiev.matrices.reduced;
/**
 * Created by oleg on 11/23/15.
 */
public class MatrixArr2D extends AbstractMatrix {
    private double[][] arr2D;
    private int size;

    public MatrixArr2D(int size) {
        if (size <= 0 || size > 64)
            throw new NegativeArraySizeException("Incorrect size of array");

        this.size = size;
        arr2D = new double[size][size];
    }

    @Override
    public double getEl(int row, int col) {
        return arr2D[row][col];
    }

    @Override
    public void setEl(double val, int row, int col) {
        arr2D[row][col] = val;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected MatrixArr2D createMatrix() {
        return new MatrixArr2D(size);
    }

    @Override
    protected  AbstractMatrix getMinor(int r, int c, AbstractMatrix base) {
        return new ReducedMatrix(r, c, this);
    }
}
