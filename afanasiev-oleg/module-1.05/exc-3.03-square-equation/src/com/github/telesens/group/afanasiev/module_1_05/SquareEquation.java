package com.github.telesens.group.afanasiev.module_1_05;

/**
 * Created by oleg on 11/25/15.
 */
public class SquareEquation {
    public class SquareSolveError extends Exception {
        @Override
        public String toString() {
            return "Negative discriminant";
        }
    }

    public class SquareInitError extends  Exception {
        @Override
        public String toString() {
            return "'a' must have value difference than zero";
        }
    }

    private double a, b, c;

    public SquareEquation(double a, double b, double c) throws SquareInitError {
        if (a == 0)
            throw new SquareInitError();

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void set(double a, double b, double c) throws SquareInitError {
        if (a == 0)
            throw new SquareInitError();

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double discriminant() {
        return b*b - 4*a*c;
    }

    public double x1() throws SquareSolveError {
        double d  = discriminant();

        if (d < 0)
            throw new SquareSolveError();

        if (d == 0)
            return -b/(2*a);
        else // d > 0
            return (-b - Math.sqrt(d))/(2*a);
    }

    public double x2() throws SquareSolveError {
        double d  = discriminant();

        if (d < 0)
            throw new SquareSolveError();

        if (d == 0)
            return -b/(2*a);
        else // d > 0
            return (-b + Math.sqrt(d))/(2*a);
    }

    public void printSolve() {
        double d = discriminant();

        if (d < 0) {
            System.out.printf("There are not solutions %n");
            return;
        }

        try {
            if (d == 0) {
                System.out.printf("x = %.4f %n", x1());
                return;
            }

            if (d > 0) {
                System.out.printf("x1 = %.4f %n", x1());
                System.out.printf("x2 = %.4f %n", x2());
                return;
            }
        } catch(SquareSolveError err) {
            System.err.println(err);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s%.1f*x^2", (a < 0 ? " - " : ""), Math.abs(a)));

        if (b != 0)
            sb.append(String.format("%s%.1f*x", (b < 0 ? " - " : " + "), Math.abs(b)));

        if (c != 0)
            sb.append(String.format("%s%.1f", (c < 0 ? " - " : "+"), Math.abs(c)));

        sb.append(" = 0");

        return sb.toString();
    }


}
