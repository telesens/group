package com.github.telesens.group.afanasiev.matrices;

import java.util.Arrays;

/**
 * Created by oleg on 11/23/15.
 */
public class MatrixArr extends AbstractMatrix {
    private double[] arr;
    private boolean[] excludedRows;
    private boolean[] excludedCols;

    public MatrixArr(int n) {
        if (n < 0)
            throw new NegativeArraySizeException();

        arr = new double[n * n];
        excludedRows = new boolean[n];
        excludedCols = new boolean[n];
    }

    private MatrixArr(double[] arr, boolean[] excludedRows, boolean[] excludedCols) {
        this.arr = arr;
        this.excludedRows = excludedRows;
        this.excludedCols = excludedCols;
    }

    @Override
    public double get(int r, int c) {
        if (r <= 0 || r > size() || c <= 0 || c > size())
            throw new ArrayIndexOutOfBoundsException();

        int l = (int)Math.sqrt(arr.length);
        int ind = (r - 1 + rowMinorOffset(r)) * l + c - 1 + colMinorOffset(c);
        return arr[ind];
    }

    @Override
    public void set(double val, int r, int c) {
        if (r <= 0 || r > size() || c <= 0 || c > size())
            throw new ArrayIndexOutOfBoundsException();

        int l = (int)Math.sqrt(arr.length);
        int ind = (r - 1 + rowMinorOffset(r)) * l + c - 1 + colMinorOffset(c);
        arr[ind] = val;
    }

    @Override
    public int size() {
        return (int)Math.sqrt(arr.length) - rowMinorOffset(excludedRows.length);
    }

    @Override
    protected MatrixArr getMinorMatrix(int r, int c) {
        boolean[] excludedRowsForM = Arrays.copyOf(excludedRows, excludedRows.length);
        boolean[] excludedColsForM = Arrays.copyOf(excludedCols, excludedCols.length);

        excludedRowsForM[r - 1 + rowMinorOffset(r)] = true;
        excludedColsForM[c - 1 + colMinorOffset(c)] = true;

        return new MatrixArr(arr, excludedRowsForM, excludedColsForM);
    }

    @Override
    protected  MatrixArr createMatrix() {
        return new MatrixArr(size());
    }

    private int rowMinorOffset(int r) {
        int offset = 0;
        for (int i = 0, j = 1; i < excludedRows.length && j <= r; i++) {
            if (excludedRows[i])
                offset++;
            else
                j++;
        }
        return offset;
    }

    private int colMinorOffset(int c) {
        int offset = 0;
        for (int i = 0, j = 1; i < excludedCols.length && j <= c; i++) {
            if (excludedCols[i])
                offset++;
            else
                j++;
        }
        return offset;
    }
}
