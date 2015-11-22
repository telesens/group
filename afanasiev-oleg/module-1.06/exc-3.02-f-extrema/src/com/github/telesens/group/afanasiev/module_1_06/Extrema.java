package com.github.telesens.group.afanasiev.module_1_06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.DoubleUnaryOperator;

/**
 * Created by oleg on 11/21/15.
 */
public class Extrema {
    private static final double epsY = 0.01;
    public static Double[] solve(double a, double b, double epsX, DoubleUnaryOperator func) {
        Collection<Double> extremaList = new ArrayList<>();

        if (a > b) {
            double tmp = b;
            b = a;
            a = tmp;
        }

        double fx, dfx, ddfx;

        for (double xi = a; xi + epsX <= b; xi += epsX) {

            dfx = dF(xi, (x->func.applyAsDouble(x)));
            ddfx = ddF(xi, (x -> func.applyAsDouble(x)));

            if (Math.abs(dfx) < epsY && Math.abs(ddfx) > epsY)
                if (!contains(xi, epsY * 10, extremaList))
                    extremaList.add(Math.round(xi * 100.0) / 100.0);
        }

        return extremaList.toArray(new Double[extremaList.size()]);
    }

    private static double dF(double x, FunctionWithDerivates func) {
        return func.f1(x);
    }

    private static double ddF(double x, FunctionWithDerivates func) {
        return func.f2(x);
    }

    private static boolean contains(double x, double eps, Collection<Double> list) {
        for (Double el : list) {
            if (Math.abs(x - el) <= eps)
                return true;
        }

        return false;
    }
}
