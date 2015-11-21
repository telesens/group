/**
 * Created by oleg on 11/21/15.
 */
import java.util.Arrays;
import  java.util.function.DoubleBinaryOperator;
public class Main {
    private static final double a = 0 * Math.PI;
    private static final double b = 8 * Math.PI;
    private static final double eps = 0.001;

    public static void main(String[] args) {
        Double[] extremaList = Extrema.solve(a, b, eps, (x-> x*Math.sin(x)));

        System.out.printf("Extremas of x * sin(x) on [%f, %f] %n", a, b);
        System.out.println(Arrays.toString(extremaList));
    }
}
