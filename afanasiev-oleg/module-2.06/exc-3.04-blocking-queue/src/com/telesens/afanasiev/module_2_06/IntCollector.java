package com.telesens.afanasiev.module_2_06;

import java.util.concurrent.BlockingQueue;

/**
 * Created by oleg on 12/25/15.
 */
public class IntCollector implements Runnable {

    private BlockingQueue<Integer> queue;

    public IntCollector(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 50;) {
                if (queue.offer(i))
                    i++;

                Thread.sleep(80);
            }
        } catch(InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}
