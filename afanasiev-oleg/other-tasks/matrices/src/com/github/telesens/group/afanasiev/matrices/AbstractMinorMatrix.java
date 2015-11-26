package com.github.telesens.group.afanasiev.matrices;

import java.util.Arrays;

/**
 * Created by oleg on 11/26/15.
 */
public abstract class AbstractMinorMatrix extends AbstractMatrix {
    private boolean[] excludedRows;
    private boolean[] excludedCols;

    protected AbstractMinorMatrix(int size) {
        if (size < 0)
            throw new NegativeArraySizeException();

        excludedRows = new boolean[size];
        excludedCols = new boolean[size];
    }

    protected AbstractMinorMatrix(AbstractMinorMatrix minorMatrix, int excludedRow, int excludedCol) {
        excludedRows = Arrays.copyOf(minorMatrix.excludedRows, minorMatrix.excludedRows.length);
        excludedCols = Arrays.copyOf(minorMatrix.excludedCols, minorMatrix.excludedCols.length);

        excludedRows[getRow(excludedRow) - 1] = true;
        excludedCols[getCol(excludedCol) - 1] = true;
    }

    public int getRow(int r) {
        return r + rowMinorOffset(r);
    }

    public int getCol(int c) {
        return c + colMinorOffset(c);
    }

    @Override
    public int size() {
        return excludedRows.length - rowMinorOffset(excludedRows.length);
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
