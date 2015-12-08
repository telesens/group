package com.github.telesens.group.afanasiev.module_2_04;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


/**
 * Created by oleg on 12/8/15.
 */
public class Main {
    private static String fName = "temp.txt";

    public static void main(String[] args) {
        System.out.println("-----------Work with file system---------");
        createFile();
        listFiles();
        deleteFile();
    }

    private static void createFile() {
        File file = new File(fName);
        try {
            file.createNewFile();
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void listFiles() {
        File dir = new File(".");
        System.out.println(Arrays.asList(dir.list()));
    }

    private static void deleteFile() {
        File file = new File (fName);
        file.delete();
    }
}
