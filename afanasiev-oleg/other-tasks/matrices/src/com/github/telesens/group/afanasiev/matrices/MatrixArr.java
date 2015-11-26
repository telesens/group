package com.github.telesens.group.afanasiev.matrices;
/**
 * Created by oleg on 11/23/15.
 */
public class MatrixArr extends AbstractMinorMatrix {
    private double[] arr;

    public MatrixArr(int size) {
        super(size);

        arr = new double[size * size];
    }

    private MatrixArr(MatrixArr extendedMatrix, int excludedRow, int excludedCol) {
        super(extendedMatrix, excludedRow, excludedCol);
        this.arr = extendedMatrix.arr;
    }

    @Override
    public double get(int row, int col) {
        if (row <= 0 || row > size() || col <= 0 || col > size())
            throw new ArrayIndexOutOfBoundsException();

        int l = (int)Math.sqrt(arr.length);
        int ind = (getRow(row) - 1) * l + getCol(col) - 1;
        return arr[ind];
    }

    @Override
    public void set(double val, int row, int col) {
        if (row <= 0 || row > size() || col <= 0 || col > size())
            throw new ArrayIndexOutOfBoundsException();

        int l = (int)Math.sqrt(arr.length);
        int ind = (getRow(row) - 1) * l + getCol(col) - 1;
        arr[ind] = val;
    }

    @Override
    protected MatrixArr getMinorMatrix(int row, int col) {
        return new MatrixArr(this, row, col);
    }

    @Override
    protected  MatrixArr createMatrix() {
        return new MatrixArr(size());
    }
}
