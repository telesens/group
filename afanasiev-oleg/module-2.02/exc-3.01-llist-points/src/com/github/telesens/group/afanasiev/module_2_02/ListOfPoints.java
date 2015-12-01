package com.github.telesens.group.afanasiev.module_2_02;

import ua.in.iwanoff.lesson105.AbstractArrayOfPoints;

import java.util.ArrayList;

/**
 * Created by oleg on 12/1/15.
 */
public class ListOfPoints extends AbstractArrayOfPoints {
    private ArrayList<Double> points;

    public ListOfPoints() {
        points = new ArrayList<Double>();
    }

    @Override
    public void setPoint(int i, double x, double y) {
        points.set(i*2, x);
        points.set(i*2 + 1, y);
    }

    @Override
    public double getX(int i) {
        return points.get(i*2);
    }

    @Override
    public double getY(int i) {
        return points.get(i*2 + 1);
    }

    @Override
    public int count() {
        return points.size()/2;
    }

    @Override
    public void addPoint(double x, double y) {
        points.add(x);
        points.add(y);
    }

    @Override
    public void removeLast() {
        points.remove(points.size() - 1);
        points.remove(points.size() - 1);
    }
}
