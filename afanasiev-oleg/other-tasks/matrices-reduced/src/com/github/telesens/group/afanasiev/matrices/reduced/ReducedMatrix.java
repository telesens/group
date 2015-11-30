package com.github.telesens.group.afanasiev.matrices.reduced;

/**
 * Created by oleg on 11/30/15.
 */
public class ReducedMatrix extends AbstractMatrix {
    private int excludedRow;
    private int excludedCol;
    private AbstractMatrix base;

    public ReducedMatrix(int r, int c, AbstractMatrix base) {
        excludedRow = r;
        excludedCol = c;
        this.base = base;
    }

    @Override
    public double getEl(int r, int c) {
        int row = r < excludedRow ? r : r + 1;
        int col = c < excludedCol ? c : c + 1;

        return base.getEl(row, col);
    }

    @Override
    public void setEl(double value, int r, int c) {
        throw new UnsupportedOperationException("Cannot set in \"ReduceMatrix\"");
    }

    @Override
    public int getSize() {
        return base.getSize() - 1;
    }

    @Override
    protected AbstractMatrix createMatrix() {
        return base.createMatrix();
    }

    @Override
    protected  AbstractMatrix getMinor(int r, int c, AbstractMatrix base) {
        return new ReducedMatrix(r, c, base);
    }
}
