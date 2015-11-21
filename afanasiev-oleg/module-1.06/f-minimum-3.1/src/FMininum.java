/**
 * Created by oleg on 11/20/15.
 */
import java.util.function.*;

public class FMininum {

    public static Double solve(double a, double b, double eps, DoubleUnaryOperator func) {

        if (a > b) {
            double tmp = b;
            b = a;
            a = tmp;
        }

        double min = func.applyAsDouble(a);
        double fx;

        for (double xi = a + eps; xi <= b; xi += eps) {
            fx = func.applyAsDouble(xi);
            if (fx < min) {
                min = fx;
            }
        }

        return min;
    }
}
