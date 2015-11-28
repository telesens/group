package com.github.telesens.group.afanasiev.matrices;

/**
 * Created by oleg on 11/23/15.
 */
public abstract class AbstractMatrix extends ArithmeticException {

    public abstract double get(int r, int c);
    public abstract void set(double val, int r, int c);
    public abstract int size();

    protected abstract AbstractMatrix getMinorMatrix(int r, int c);
    protected abstract int getR(int row);
    protected abstract int getC(int col);
    protected abstract AbstractMatrix createMatrix();

    public double determinant() {
        if (size() == 1)
            return get(1, 1);

        double det = 0;

        for (int k = 1; k <= size(); k++) {
            det += (Math.pow(-1, k - 1) * get(getR(1), getC(k)) * getMinorMatrix(1, k).determinant());
        }

        return det;
    }

    public AbstractMatrix inverse() {
        AbstractMatrix invM = createMatrix();

        double A;
        double det = determinant();

        if (det == 0)
            throw new ArithmeticException("\"Determinant is zero!\"");

        for (int r = 1; r <= size(); r++)
            for (int c = 1; c <= size(); c++) {
                A = Math.pow(-1, r + c) * getMinorMatrix(getR(r), getC(c)).determinant();
                invM.set(A/det, c, r);
            }

        return invM;
    }

    public AbstractMatrix mult(AbstractMatrix matr) {
        AbstractMatrix multMatrix = createMatrix();
        double m;

        for (int r = 1; r <= size(); r++)
            for (int c = 1; c <= size(); c++) {
                m = multEl(matr, r, c);
                multMatrix.set(m, r, c);
            }

        return multMatrix;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int r = 1; r <= size(); r++) {
            str.append(String.format("|"));
            for (int c = 1; c <= size(); c++) {
                str.append(String.format(" %8.2f", get(r, c)));
            }
            str.append(String.format(" |%n"));
        }

        return str.toString();
    }

    private double multEl(AbstractMatrix matr, int r, int c) {
        double m = 0;

        for (int k = 1; k <= size(); k++) {
            m += get(r, k) * matr.get(k, c);
        }

        return m;
    }
}
