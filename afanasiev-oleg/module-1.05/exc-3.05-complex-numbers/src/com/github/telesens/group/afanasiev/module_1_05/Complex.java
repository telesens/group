package com.github.telesens.group.afanasiev.module_1_05;

/**
 * Created by oleg on 11/16/15.
 */
public class Complex {
    private final double re;
    private final double im;

    public Complex() {
        this(0, 0);
    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double re() {
        return re;
    }

    public double im() {
        return im;
    }

    public Complex plus(Complex b) {
        Complex a = this;
        double re = a.re + b.re;
        double im = a.im + b.im;
        return new Complex(re, im);
    }

    public Complex minus(Complex b) {
        Complex a = this;
        double re = a.re - b.re;
        double im = a.im - b.im;
        return new Complex(re, im);
    }

    public Complex mult(Complex b) {
        Complex a = this;
        double re = a.re * b.re - a.im * b.im;
        double im = a.re * b.im + a.im * b.re;
        return new Complex(re, im);
    }

    public Complex mult(double c) {
        Complex a = this;
        double re = a.re * c;
        double im = a.im * c;
        return new Complex(re, im);
    }

    public Complex div(Complex b) {
        Complex a = this;
        return a.mult(b.reciprical());
    }

    public Complex reciprical() {
        double scale = re*re + im*im;
        return new Complex(re/scale, -im/scale);
    }

    public String toString() {

        if (im == 0)
            return String.format("%.2f", re);

        if (re == 0)
            return String.format("%.2fi", im).toString();

        if (im < 0)
            return String.format("%.2f - %.2fi", re, -im).toString();

        return String.format("%.2f + %.2fi", re, im).toString();
    }
}
