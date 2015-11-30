package com.github.telesens.group.afanasiev.matrices.reduced;

import java.util.Random;

/**
 * Created by oleg on 11/23/15.
 */
public abstract class AbstractMatrix extends ArithmeticException {

    public abstract double getEl(int r, int c);
    public abstract void setEl(double val, int r, int c);
    public abstract int getSize();

    protected abstract AbstractMatrix createMatrix();
    protected abstract AbstractMatrix getMinor(int r, int c, AbstractMatrix base);

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int r = 0; r < getSize(); r++) {
            str.append(String.format("|"));
            for (int c = 0; c < getSize(); c++) {
                str.append(String.format(" %8.2f", getEl(r, c)));
            }
            str.append(String.format(" |%n"));
        }

        return str.toString();
    }

    public void initRandom(double min, double max) {
        Random random = new Random();
        for (int r = 0; r < getSize(); r++)
            for (int c = 0; c < getSize(); c++)
                setEl(min + random.nextDouble() * (max - min), r, c);
    }

    public double determinant() {
        double det = 0;
        int sign = 1;

        if (getSize() == 1)
            return getEl(0, 0);

        for (int r = 0; r < getSize(); r++) {
            for (int c = 0; c < getSize(); c++) {
                det = det + sign * getEl(r, c) * getMinor(0, c, this).determinant();
                sign = -sign;
            }
        }

        return det;
    }

    public AbstractMatrix inverse() {
        AbstractMatrix invM = createMatrix();

        double A;
        double det = determinant();
        double sign;

        if (det == 0)
            throw new ArithmeticException("\"Determinant is zero!\"");

        for (int r = 0; r < getSize(); r++)
            for (int c = 0; c < getSize(); c++) {
                sign = ((r+c) & 1) == 0 ? 1 : -1;
                A = sign * getMinor(r, c, this).determinant();
                invM.setEl(A / det, c, r);
            }

        return invM;
    }

    public AbstractMatrix mult(AbstractMatrix matr) {
        AbstractMatrix multMatrix = createMatrix();
        double m;

        for (int r = 0; r < getSize(); r++)
            for (int c = 0; c < getSize(); c++) {
                m = multEl(matr, r, c);
                multMatrix.setEl(m, r, c);
            }

        return multMatrix;
    }

    private double multEl(AbstractMatrix matr, int r, int c) {
        double m = 0;

        for (int k = 0; k < getSize(); k++) {
            m += getEl(r, k) * matr.getEl(k, c);
        }

        return m;
    }
}
