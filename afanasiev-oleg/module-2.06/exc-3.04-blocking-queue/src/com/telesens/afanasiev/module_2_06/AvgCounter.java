package com.telesens.afanasiev.module_2_06;

import java.util.concurrent.BlockingQueue;

/**
 * Created by oleg on 12/25/15.
 */
public class AvgCounter implements Runnable {

    private BlockingQueue<Integer> queue;
    private boolean isFinish = false;

    public AvgCounter(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void finish( ) {
        isFinish = true;
    }

    @Override
    public void run() {
        int i = 0;
        double avg = 0;
        int sum = 0;
        int el;
        try {
            while (!isFinish || queue.size() > 0) {
                System.out.printf("%n queue = %s %n", queue);

                el = queue.take();
                sum += el;
                i++;
                avg = (double)sum / i;

                System.out.printf("          el = %d %n", el);
                System.out.printf("          sum = %d %n", sum);
                System.out.printf("          avg = %.4f %n", avg);
                Thread.sleep(100);
            }
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}
