package com.github.telesens.group.afanasiev.module_2_04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by oleg on 12/7/15.
 */
public class Main {
    private static Group group;
    private static String fZipName = "./resource/source.zip";
    private static String fEntryName = "source.dat";

    public static void main(String[] args) {
        System.out.println("--------Try pack to zip--------");
        createGroup();
        System.out.println(group);
        saveToZip();
    }

    private static void createGroup() {
        group = new Group("mp-113");

        group.addStudent(new Student("Oleg", 34));
        group.addStudent(new Student("Lena", 23));
        group.addStudent(new Student("Kolya", 27));
    }

    private static void saveToZip() {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(fZipName))) {
            ZipEntry zipEntry = new ZipEntry(fEntryName);
            byte[] buffer = group.toString().getBytes();
            zipOut.putNextEntry(zipEntry);
            zipOut.write(buffer, 0, buffer.length);
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }
}
