package ua.in.iwanoff.lesson105;

/**
 * Created by oleg on 11/25/15.
 */
public class ArrayOfDouble {
    private double[] a;

    public ArrayOfDouble() {
        a = null;
    }

    public ArrayOfDouble(int n) {
        a = new double[n];
    }

    public ArrayOfDouble(double[] a) {
        this.a = a;
    }

    int size() {
        return a != null ? a.length : 0;
    }

    public double[] toArray() {
        return a;
    }

    public void setA(double[] a) {
        this.a = a;
    }

    public double get(int i) {
        return a[i];
    }

    public void set(int i, double x) {
        a[i] = x;
    }

    public void add(double x) {
        double[] b = new double[size() + 1];
        if (a != null) {
            System.arraycopy(a, 0, b, 0, size());
        }
        b[size()] = x;
        a = b;
    }

    public void delLast() {
        double[] b = new double[size() - 1];
        if (a != null) {
            System.arraycopy(a, 0, b, 0, size() - 1);
        }
        a = b;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < size(); i++) {
            s += (a[i] + ", ");
        }
        s = s.trim() + "]";
        return s;
    }
}
