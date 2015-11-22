package com.github.telesens.group.afanasiev.module_1_06; /**
 * Created by oleg on 11/21/15.
 */
import com.github.telesens.group.afanasiev.module_1_06.Extrema;

import java.util.Arrays;

public class Main {
    private static final double a = 0 * Math.PI;
    private static final double b = 8 * Math.PI;
    private static final double eps = 0.001;

    public static void main(String[] args) {
        Double[] extremaList = Extrema.solve(a, b, eps, (x -> x * Math.sin(x)));

        System.out.printf("Extremas of x * sin(x) on [%.2f, %.2f] %n", a, b);
        System.out.println(Arrays.toString(extremaList));
    }
}
