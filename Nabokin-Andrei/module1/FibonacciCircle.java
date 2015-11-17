package ua.telesens.anabokin.module1;

import java.util.Scanner;

/**
 * Created by Admin on 13.11.15.
 */
public class FibonacciCircle {
    static int fibNumber(int n) {
        if (n < 3) {
            return 1;
        } else {
            int numN_1 = 1;
            int numN_2 = 1;
            int retNum = 0;
            for (int i = 3; i <= n; i++) {
                retNum = numN_2 + numN_1;
                numN_2 = numN_1;
                numN_1 = retNum;
            }
            return retNum;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер числа Фибоначчи.");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print(fibNumber(i) + " ");
        }
    }
}
