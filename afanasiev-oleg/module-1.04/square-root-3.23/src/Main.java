/**
 * Created by oleg on 11/18/15.
 */
public class Main {
    public static void main(String[] args) {
        double x = 17;
        double mathSqrt = Math.sqrt(x);
        double sqrt = sqrt(x);
        System.out.printf("Math.sqrt(%.2f) = %.20f%n", x, mathSqrt);
        System.out.printf("     sqrt(%.2f) = %.20f%n ", x, sqrt);
        System.out.printf(" |Math.sqrt(%.2f) - sqrt(%.2f)| = %.20f%n ",x, x, Math.abs(mathSqrt - sqrt));
    }

    private static Double sqrt(Double x) {
        if (x == null || x < 0)
            return null;

        final double eps = 0.00001;
        double sqrt = 1;
        double sqrtNext = nextIter(x, sqrt);

        while (Math.abs(sqrt - sqrtNext) > eps) {
            sqrt = sqrtNext;
            sqrtNext = nextIter(x, sqrt);
        }

        return sqrt;
    }

    private static double nextIter(double x, double sqrtPrev) {
        return (sqrtPrev + x / sqrtPrev)/2;
    }
}
