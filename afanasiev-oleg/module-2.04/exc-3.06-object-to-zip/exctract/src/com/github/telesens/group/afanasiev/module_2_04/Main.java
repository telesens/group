package com.github.telesens.group.afanasiev.module_2_04;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by oleg on 12/8/15.
 */
public class Main {
    private static String fName = "./resource/source.zip";
    public static void main(String[] args) {
        System.out.println("----------Try printFromZip from zip---------");
        printFromZip();
    }

    private static void printFromZip() {

        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(fName))) {
            ZipEntry entry = zipIn.getNextEntry();
            byte[] buffer = new byte[1024];
            int bytesRead;

            if (entry != null) {
                while((bytesRead = zipIn.read(buffer)) >= 0) {
                    System.out.write(buffer, 0, bytesRead);
                }
                zipIn.closeEntry();
            }

        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }
}
