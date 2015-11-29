package com.github.telesens.group.afanasiev.matrices;

import java.util.Random;

/**
 * Created by oleg on 11/23/15.
 */
public abstract class AbstractMatrix extends ArithmeticException {

    public abstract double getEl(int r, int c);
    public abstract void setEl(double val, int r, int c);
    public abstract int getSize();

    protected abstract AbstractMatrix createMatrix(int size);

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int r = 1; r <= getSize(); r++) {
            str.append(String.format("|"));
            for (int c = 1; c <= getSize(); c++) {
                str.append(String.format(" %8.2f", getEl(r, c)));
            }
            str.append(String.format(" |%n"));
        }

        return str.toString();
    }

    public void initRandom(double min, double max) {
        Random random = new Random();
        for (int r = 1; r <= getSize(); r++)
            for (int c = 1; c <= getSize(); c++)
                setEl(min + random.nextDouble() * (max - min), r, c);
    }

    public double determinant() {
        return getDeterminantInt(0, 0);
    }

    public AbstractMatrix inverse() {
        AbstractMatrix invM = createMatrix(getSize());

        double A;
        double det = determinant();

        if (det == 0)
            throw new ArithmeticException("\"Determinant is zero!\"");

        for (int r = 1; r <= getSize(); r++)
            for (int c = 1; c <= getSize(); c++) {
                A = powMinus1(r + c) * getDeterminantInt(getExcluded(r), getExcluded(c));
                invM.setEl(A / det, c, r);
            }

        return invM;
    }

    public AbstractMatrix mult(AbstractMatrix matr) {
        AbstractMatrix multMatrix = createMatrix(getSize());
        double m;

        for (int r = 1; r <= getSize(); r++)
            for (int c = 1; c <= getSize(); c++) {
                m = multEl(matr, r, c);
                multMatrix.setEl(m, r, c);
            }

        return multMatrix;
    }

    private double multEl(AbstractMatrix matr, int r, int c) {
        double m = 0;

        for (int k = 1; k <= getSize(); k++) {
            m += getEl(r, k) * matr.getEl(k, c);
        }

        return m;
    }

    private double getDeterminantInt(long excludedRows, long excludedCols) {

        double retValue = 0;
        int k = 0;

        for (int r = 1; r <= getSize(); r++) {
            if (((excludedRows >> (r-1)) & 1) == 0) {
                for (int c = 1; c <= getSize(); c++) {
                    if (((excludedCols >> (c-1)) & 1) == 0) {
                        retValue = retValue + powMinus1(k) * getEl(r, c) * getDeterminantInt(excludedRows | 1 << (r-1), excludedCols | 1 << (c-1));
                        k++;
                    }
                }
                return retValue;
            }
        }
        // если все строки вычеркнуты, возвращаем 1
        return 1;
    }

    private long getExcluded(int n) {
        long excluded = 0;

        return excluded | 1 << (n-1);
    }

    private double powMinus1(int k) {
        return (k & 1) == 0 ? 1 : -1;
    }
}
