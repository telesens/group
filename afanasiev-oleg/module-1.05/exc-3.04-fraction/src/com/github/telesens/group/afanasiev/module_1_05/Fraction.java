package com.github.telesens.group.afanasiev.module_1_05;

/**
 * Created by oleg on 11/25/15.
 */
public class Fraction {
    private int n, d;

    public Fraction() {
        n = 0;
        d = 1;
    }

    public Fraction(int numerator, int denominator) {
        n = numerator * (int) Math.signum(numerator * denominator);
        d = Math.abs(denominator);
    }

    public int getDenominator() {
        return d;
    }

    public int getNumerator() {
        return n;
    }

    public void set(int numerator, int denominator) {
        n = numerator * (int) Math.signum(numerator * denominator);
        d = Math.abs(denominator);
    }

    @Override
    public String toString() {
        if (n == 0 || Math.abs(n) == Math.abs(d))
            return n + "";
        else
            return n + "/" + d;
    }

    public static Fraction sum(Fraction a, Fraction b) {
        Fraction c = new Fraction();
        c.n = a.n * b.d + a.d * b.n;
        c.d = a.d * b.d;
        c.reduce();
        return c;
    }

    public static Fraction mult(Fraction a, Fraction b) {
        Fraction c = new Fraction();
        c.n = a.n * b.n;
        c.d = a.d * b.d;
        c.reduce();
        return c;
    }

    public Fraction pow(int n) {
        Fraction c = new Fraction();
        c.n = (int)Math.pow(this.n, n);
        c.d = (int)Math.pow(this.d, n);
        c.reduce();
        return c;
    }

    protected Fraction reduce() {
        if (n == 0)
            return this;

        int num = n, den = d;
        while (num != den) {
            if (num > den) {
                num -= den;
            }
            else {
                den -= num;
            }
        }
        n /= num;
        d /= num;
        return this;
    }
}
