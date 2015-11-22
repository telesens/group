package com.github.telesens.group.afanasiev.module_1_05;

/**
 * Created by oleg on 11/16/15.
 */
public abstract class AbstractFunc {
    private final double  step = 0.00001;
    private double X1;
    private double X2;

    public double min(double x1, double x2) {
        X1 = Math.min(x1, x2);
        X2 = Math.max(x1, x2);
        double x = X1;
        double fMin = f(x);
        double f;

        do {
            x += step;
            f = f(x);
            fMin = Math.min(f, fMin);
        } while(x <= X2);

        return fMin;
    }

    protected abstract  double f(double x);
}
