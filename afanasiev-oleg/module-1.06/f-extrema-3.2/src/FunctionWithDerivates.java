/**
 * Created by oleg on 11/21/15.
 */
public interface FunctionWithDerivates {
    double DX = 0.001;

    double f(double x);

    default double f1(double x) {
        return (f(x + DX) - f(x)) / DX;
    }

    default double f2(double x) {
        return (f1(x + DX) - f1(x)) / DX;
    }
}
