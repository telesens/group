package com.github.telesens.group.afanasiev.module_1_03;

/**
 * Created by oleg on 12/1/15.
 */
public class QuadraticEquation {
    private final double A, B, C;
    private final double D;

    public QuadraticEquation(double a, double b, double c) {
        if (a == 0)
            throw new UnsupportedOperationException("No quadratic exception");

        this.A = a;
        this.B = b;
        this.C = c;

        D = discriminant();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (Math.abs(A) == 1)
            sb.append(String.format("%sx^2", A < 0 ? "-" : ""));
        else {
            sb.append(String.format("%.2f", A));
            sb.append("x^2");
        }

        if (B != 0) {
            sb.append(String.format(" %s ", B < 0 ? "-" : "+"));
            if (Math.abs(B) == 1)
                sb.append("x");
            else
                sb.append(String.format("%.2fx", Math.abs(B)));
        }

        if (C != 0)
            sb.append(String.format(" %s %.2f = 0", C < 0 ? "-" : "+", Math.abs(C)));

        return sb.toString();
    }

    public double X1() {
        if (D < 0)
            throw new ArithmeticException("Discriminant is negative");

        return (-B + Math.sqrt(D))/(2*A);
    }

    public double X2() {
        if (D < 0)
            throw new ArithmeticException("Discriminant is negative");

        return (-B - Math.sqrt(D))/(2*A);
    }

    public String Z1ToString() {
        StringBuilder sb = new StringBuilder();

        if (D < 0)
            sb.append(String.format("%.2f + %.2fi", -B, Math.sqrt(-D)));
        else if (D > 0)
            sb.append(String.format("%.2f", X1()));

        return sb.toString();
    }

    public String Z2ToString() {
        StringBuilder sb = new StringBuilder();

        if (D < 0)
            sb.append(String.format("%.2f - %.2fi", -B, Math.sqrt(-D)));
        else if (D > 0)
            sb.append(String.format("%.2f", X2()));

        return sb.toString();
    }

    public int nRealRoots() {
        if (D < 0)
            return 0;
        else if (D == 0)
            return 1;
        else
            return 2;
    }

    public int nComplexRoots() {
        if (D == 0)
            return 1;
        else
            return 2;
    }

    private double discriminant() {
        return B*B - 4*A*C;
    }
}
