package com.github.telesens.group.afanasiev.module_2_06;

/*
    Создать консольную программу, в которой один поток выполнения ищет все файлы подкаталога и
    заполняет ConcurrentSkipListMap (имя / длина файла), а другой подсчитывает и выводит суммарную длину файлов.
 */

/**
 * Created by oleg on 12/21/15.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("---------Multithreading---------");
        FileCollector fc = new FileCollector();
        Thread tfc = new Thread(fc);
        Thread tsl = new Thread(new SummaryLength(fc, tfc));

        tfc.start();
        tsl.start();

//        try {
//            tsl.join();
//        } catch(InterruptedException exc) {
//            exc.printStackTrace();
//        }
    }
}
