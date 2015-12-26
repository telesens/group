/*
Создать консольную программу, в которой один поток выполнения добавляет целые числа к очереди BlockingQueue,
а другой вычисляет их среднее арифметическое.
 */

package com.telesens.afanasiev.module_2_06;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by oleg on 12/25/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---------Work with BlockingQueue---------\n");

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        IntCollector intCollector = new IntCollector(queue);
        AvgCounter avgCounter = new AvgCounter(queue);

        Thread tIntCollector = new Thread(intCollector);
        Thread tAvgCounter = new Thread(avgCounter);

        tIntCollector.start();
        tAvgCounter.start();

        try {
            tIntCollector.join();
        } catch(InterruptedException exc) {
            exc.printStackTrace();
        }

        avgCounter.finish();
    }
}
