/**
 * Created by oleg on 11/17/15.
 */
public class PiNilakanthSeries {

    public PiNilakanthSeries() {
    }

    public double calcIter(double eps) {
        double pi = 0;
        double re = 3;
        double k = 2;
        short sign = 1;

        while(Math.abs(re) > eps) {
            pi += re;
            re = 4 * sign / (k * (k + 1) * (k + 2));
            sign *= -1;
            k += 2;
        }
        return pi;
    }

    public double calcRecursive(double eps) {
        return 3 + calcRemain(2, eps);
    }

    private double calcRemain(int k, double eps) {
        int sign = (k % 4 == 0) ? -1 : 1;
        double re = 4.0 * sign / (k * (k + 1) * (k + 2));

        if (Math.abs(re) > eps)
            return re + calcRemain(k + 2, eps);
        else
            return 0;
    }
}
