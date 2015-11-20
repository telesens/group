/**
 * Created by oleg on 11/20/15.
 */
import java.util.function.DoubleFunction;

public class FMininum {
    public static Double solveExplicit(double a, double b, double eps, DoubleFunction func) {

        for (double xi = a; xi + eps <= b; xi += eps)
            if (derivF(xi) < 0 &&  derivF(xi + eps) > 0)
                return xi;

        return null;
    }

    public static double solveNoname() {
        return 0;
    }

    public static double solveLambda() {
        return 0;
    }

    private static double derivF(double x) {
        return 0;
    }
}
