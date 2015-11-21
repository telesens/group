import java.util.function.DoubleUnaryOperator;

/**
 * Created by oleg on 11/20/15.
 */
class SomeFunc implements DoubleUnaryOperator {
    @Override
    public double applyAsDouble(double x) {
        return x * Math.sin(x);
    }

    @Override
    public String toString() {
        String str = "x * sin(x)";
        return str;
    }
}

public class Main {
    private static final double a = 0;
    private static final double b = 2 * Math.PI;
    private static final double eps = 0.0001;

    public static void main(String[] args) {
        SomeFunc f = new SomeFunc();
        double min1 = FMininum.solve(a, b, eps, f);

        double min2 = FMininum.solve(a, b, eps, new DoubleUnaryOperator() {
            @Override
            public double applyAsDouble(double x) {
                return x * Math.sin(x);
            }
        });

        double min3 = FMininum.solve(a, b, eps, (x -> x * Math.sin(x)));

        System.out.printf("Minimum of %s on [%f, %f]: %n", f, a, b);

        System.out.printf("1) = %.2f %n", min1);
        System.out.printf("2) = %.2f %n", min2);
        System.out.printf("3) = %.2f %n", min3);
    }
}
