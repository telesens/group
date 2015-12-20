package com.github.telesens.group.afanasiev.module_2_06;

import java.util.Arrays;

/**
 * Created by oleg on 12/20/15.
 */
public class Main {

    private static int[] array;
    private static int sum;
    private static int mult;
    private static Thread tSum, tMult;

    static class Summ implements Runnable {

        @Override
        public void run() {
            sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
                try {
                    Thread.sleep(500);
                } catch(InterruptedException exc) {
                    exc.printStackTrace();
                }
            }

            System.out.println("sum = " + sum);
        }
    }

    static class Mult implements Runnable {

        @Override
        public void run() {
            mult = 1;
            try {
                for (int i = 0; i < array.length; i++) {
                    mult *= array[i];
                    Thread.sleep(100);
                }

                System.out.println("mult = " + mult);
                tSum.join();
            } catch(InterruptedException exc) {
                exc.printStackTrace();
            }

            System.out.println("avg = " + (sum + mult)/2.0);
        }
    }

    public static void main(String[] args) {
        System.out.println("-------Multi threading-------");
        init();
        tSum = new Thread(new Summ());
        tMult = new Thread(new Mult());

        tMult.start();
        tSum.start();
    }

    private static void init() {
        int N = 5;
        array = new int[N];

        for (int i = 0; i < N; i++)
            array[i] = i + 1;

        System.out.println("array = " + Arrays.toString(array));
    }
}
