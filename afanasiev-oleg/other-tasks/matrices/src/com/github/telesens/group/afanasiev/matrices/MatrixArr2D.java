package com.github.telesens.group.afanasiev.matrices;

import java.util.Arrays;

/**
 * Created by oleg on 11/23/15.
 */
public class MatrixArr2D extends AbstractMatrix {
    private double[][] arr2D;
    private boolean[] excludedRows;
    private boolean[] excludedCols;

    public MatrixArr2D(int n) {
        if (n < 0)
            throw new NegativeArraySizeException();

        arr2D = new double[n][n];
        excludedRows = new boolean[n];
        excludedCols = new boolean[n];
    }

    private MatrixArr2D(double[][] arr2D, boolean[] excludedRows, boolean[] excludedCols) {
        this.arr2D = arr2D;
        this.excludedRows = excludedRows;
        this.excludedCols = excludedCols;
    }

    @Override
    public double get(int r, int c) {
        if (r <= 0 || r > size() || c <= 0 || c > size())
            throw new ArrayIndexOutOfBoundsException();

        return arr2D[r - 1 + rowMinorOffset(r)][c - 1 + colMinorOffset(c)];
    }

    @Override
    public void set(double val, int r, int c) {
        if (r <= 0 || r > size() || c <= 0 || c > size())
            throw new ArrayIndexOutOfBoundsException();

        arr2D[r - 1 + rowMinorOffset(r)][c - 1 + colMinorOffset(c)] = val;
    }

    @Override
    public int size() {
        return arr2D.length - rowMinorOffset(excludedRows.length);
    }

    @Override
    protected MatrixArr2D getMinorMatrix(int r, int c) {
        boolean[] excludedRowsForM = Arrays.copyOf(excludedRows, excludedRows.length);
        boolean[] excludedColsForM = Arrays.copyOf(excludedCols, excludedCols.length);

        excludedRowsForM[r - 1 + rowMinorOffset(r)] = true;
        excludedColsForM[c - 1 + colMinorOffset(c)] = true;

        return new MatrixArr2D(arr2D, excludedRowsForM, excludedColsForM);
    }

    @Override
    protected MatrixArr2D createMatrix() {
        return new MatrixArr2D(size());
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
