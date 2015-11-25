package com.github.telesens.group.afanasiev.module_1_05;

import ua.in.iwanoff.lesson105.AbstractArrayOfPoints;

/**
 * Created by oleg on 11/25/15.
 */
public class ArrayOfPoints extends AbstractArrayOfPoints {
    private double[] arrPoints = {};

    @Override
    public void setPoint(int i, double x, double y) {
        if (i < 0 || i >= arrPoints.length / 2)
            throw new ArrayIndexOutOfBoundsException();

        arrPoints[i*2] = x;
        arrPoints[i*2+1] = y;
    }

    @Override
    public double getX(int i) {
        return arrPoints[i*2];
    }

    @Override
    public double getY(int i) {
        return arrPoints[i*2+1];
    }

    @Override
    public int count() {
        return arrPoints.length/2;
    }

    @Override
    public void addPoint(double x, double y) {
        double[] arrNew = new double[arrPoints.length + 2];

        System.arraycopy(arrPoints, 0, arrNew, 0, arrPoints.length);

        arrNew[arrPoints.length] = x;
        arrNew[arrPoints.length + 1] = y;

        arrPoints = arrNew;
    }

    @Override
    public void removeLast() {
        double[] arrNew = new double[arrPoints.length - 2];

        System.arraycopy(arrPoints, 0, arrNew, 0, arrPoints.length - 2);
        arrPoints = arrNew;
    }

    // "selection sort" algorithm
    @Override
    public void sortByX() {
        for (int i = 0; i < count(); i++)
            sortIter(i);
    }

    private void sortIter(int i) {
        int indMin = indexOfMinX(i);

        if (indMin > i)
            swap(i, indMin);
    }

    private void swap(int i, int j) {

        double tmpX = getX(i);
        double tmpY = getY(i);

        setPoint(i, getX(j), getY(j));
        setPoint(j, tmpX, tmpY);
    }

    private int indexOfMinX(int from) {

        double min = getX(from);
        int ind = from;

        for (int i = from; i < count(); i++) {
            if (getX(i) < min) {
                min = getX(i);
                ind = i;
            }
        }

        return ind;
    }
}
