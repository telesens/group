package com.telesens.afanasiev;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by oleg on 12/26/15.
 */
public class Main {
    private static ConcurrentSkipListMap<String, BasicFileAttributes> listFiles;

    public static void main(String[] args) throws InterruptedException{
        System.out.println("---------------File search engine------------\n");
        System.out.println("           file list            | ");

        listFiles = new ConcurrentSkipListMap<>();
        FileCollector fileDetective = new FileCollector(listFiles, "./");
        fileDetective.setPattern("*.xml");
        Thread tFileDetective = new Thread(fileDetective);
        tFileDetective.start();

        Thread.sleep(200);
        System.out.printf("%n %35s --Files with size more than 1 kb-- %n%n", " ");
        selectMoreLength(1024);

        Thread.sleep(200);
        System.out.printf("%n %35s --Files with size less than 1 kb-- %n%n", " ");
        selectLessLength(1024);

        Thread.sleep(200);
        String text = "Checkout";
        System.out.printf("%n %35s--Files with target text \"%s\" %n%n", " ", text);
        selectWithText(text);
    }

    private static void selectMoreLength(int length) {
        FileSelector fileSelector = new FileSelector(listFiles, (attr -> attr.size() > length), ((path, matchText) -> true));
        Thread fFileSelector = new Thread(fileSelector);

        fFileSelector.start();
    }

    private static void selectLessLength(int length) {
        FileSelector fileSelector = new FileSelector(listFiles, (attr -> attr.size() < length), (((path, matchText) -> true)));
        Thread fFileSelector = new Thread(fileSelector);

        fFileSelector.start();
    }


    private static void selectWithText(String text) {
        FileSelector fileSelector = new FileSelector(listFiles, (attr -> true), (path, matchText) -> matchText(path, matchText));
        fileSelector.setMatchText(text);
        Thread fFileSelector = new Thread(fileSelector);

        fFileSelector.start();
    }

    private static boolean matchText(String path, String matchText) {
        String nextLine;

        try (Scanner scanner = new Scanner(new FileReader(path))) {

            while (scanner.hasNextLine()) {
                nextLine = scanner.nextLine();
                if (nextLine.contains(matchText)) {
                    return true;
                }
            }

        } catch(IOException | NoSuchElementException  exc) {
            exc.printStackTrace();
        }
        return false;
    }
}
