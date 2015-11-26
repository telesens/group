package com.github.telesens.group.afanasiev.matrices;
/**
 * Created by oleg on 11/23/15.
 */
public class MatrixArr2D extends AbstractMinorMatrix {
    private double[][] arr2D;

    public MatrixArr2D(int size) {
        super(size);

        arr2D = new double[size][size];
    }

    private MatrixArr2D(MatrixArr2D extendedMatrix, int excludedRow, int excludedCol) {
        super(extendedMatrix, excludedRow, excludedCol);
        this.arr2D = extendedMatrix.arr2D;
    }

    @Override
    public double get(int row, int col) {
        if (row <= 0 || row > size() || col <= 0 || col > size())
            throw new ArrayIndexOutOfBoundsException();

        return arr2D[getRow(row) - 1][getCol(col) - 1];
    }

    @Override
    public void set(double val, int row, int col) {
        if (row <= 0 || row > size() || col <= 0 || col > size())
            throw new ArrayIndexOutOfBoundsException();

        arr2D[getRow(row) - 1][getCol(col) - 1] = val;
    }

    @Override
    protected MatrixArr2D createMatrix() {
        return new MatrixArr2D(size());
    }

    @Override
    protected MatrixArr2D getMinorMatrix(int row, int col) {
        return new MatrixArr2D(this, row, col);
    }
}
