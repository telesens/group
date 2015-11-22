package com.github.telesens.group.afanasiev.module_1_07;

/**
 * Created by oleg on 11/22/15.
 */
public class Main {
    public static void main(String[] args) {
        double x = -16;
        try {
            System.out.printf("sqrt4(%.2f) = %.2f %n", x, Sqrt4.solve(x));
        } catch(Sqrt4.Sqrt4NegativeArgError err) {
            err.printError();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
