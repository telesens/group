package com.github.telesens.group.afanasiev.module_1_05;

import ua.in.iwanoff.lesson105.AbstractArrayOfPoints;

/**
 * Created by oleg on 11/25/15.
 */
public class Array2DPoints extends AbstractArrayOfPoints {
    private double[][] arrPoints = {};

    @Override
    public void setPoint(int i, double x, double y) {
        if (i < 0 || i >= arrPoints.length)
            throw new ArrayIndexOutOfBoundsException();

        arrPoints[i][0] = x;
        arrPoints[i][1] = y;
    }

    @Override
    public double getX(int i) {
        if (i < 0 || i >= arrPoints.length)
            throw new ArrayIndexOutOfBoundsException();

        return arrPoints[i][0];
    }

    @Override
    public double getY(int i) {
        if (i < 0 || i >= arrPoints.length)
            throw new ArrayIndexOutOfBoundsException();

        return arrPoints[i][1];
    }

    @Override
    public int count() {
        return arrPoints.length;
    }

    @Override
    public void addPoint(double x, double y) {
        double[][] arrNew = new double[arrPoints.length + 1][2];

        System.arraycopy(arrPoints, 0, arrNew, 0, arrPoints.length);
        arrNew[arrPoints.length][0] = x;
        arrNew[arrPoints.length][1] = y;

        arrPoints = arrNew;
    }

    @Override
    public void removeLast() {
        double[][] arrNew = new double[arrPoints.length - 1][2];
        System.arraycopy(arrPoints, 0, arrNew, 0, arrPoints.length - 1);
        arrPoints = arrNew;
    }
}
