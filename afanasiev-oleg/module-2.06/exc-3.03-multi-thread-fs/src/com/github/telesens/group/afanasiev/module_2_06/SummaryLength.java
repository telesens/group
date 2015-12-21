package com.github.telesens.group.afanasiev.module_2_06;

import java.util.Map;

/**
 * Created by oleg on 12/21/15.
 */
public class SummaryLength implements Runnable {

    long totalLenght = 0;
    private FileCollector fc;
    Thread tfc;

    public SummaryLength(FileCollector fc, Thread tfc) {
        this.fc = fc;
        this.tfc = tfc;
    }

    @Override
    public void run() {
        try {
            tfc.join();
        } catch(InterruptedException exc) {
            exc.printStackTrace();
        }

        long length = 0;
        for (Map.Entry<String, Long> entry : FileCollector.files.entrySet()) {
            length += entry.getValue();
        }

        if (length != totalLenght) {
            totalLenght = length;
            System.out.println(fc);
            System.out.println("Total length = " + totalLenght);
        }
    }
}
