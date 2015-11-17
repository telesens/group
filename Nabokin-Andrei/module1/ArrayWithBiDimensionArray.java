package ua.telesens.anabokin.module1;

import java.util.Arrays;

/**
 * Created by Admin on 15.11.15.
 */
public class ArrayWithBiDimensionArray extends AbstractArrayOfPoints {
    double[][] p = new double[2][];

    @Override
    public void setPoint(int i, double x, double y) {
        if (i < count()) {
            p[0][i] = x;
            p[1][i] = y;
        }
    }

    @Override
    public double getX(int i) {
        if (i < count()) {
            return p[0][i];
        } else {
            return 0;
        }
    }

    @Override
    public double getY(int i) {
        if (i < count()) {
            return p[1][i];
        } else {
            return 0;
        }
    }

    @Override
    public int count() {
        return p[0].length;
    }

    @Override
    public void addPoint(double x, double y) {
        if (p[0] == null) {
            p[0] = new double[1];
            p[1] = new double[1];
        } else {
            p[0] = Arrays.copyOf(p[0], p[0].length + 1);
            p[1] = Arrays.copyOf(p[1], p[1].length + 1);
        }
        setPoint(p[0].length - 1, x, y);
    }

    @Override
    public void removeLast() {
        p[0] = Arrays.copyOf(p[0], p[0].length - 1);
        p[1] = Arrays.copyOf(p[1], p[1].length - 1);
    }

    public static void main(String[] args) {
        new ArrayWithBiDimensionArray().test();
    }
}
