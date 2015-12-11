package com.github.telesens.group.afanasiev.module_2_04;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by oleg on 12/8/15.
 */
public class Main {
    private static String fZip = "./resources/packed/arc.zip";

    public static void main(String[] args) {
        System.out.println("----------Try extract from *.zip-----------");
        extract();
    }

    private static void extract() {
        try(ZipInputStream zipIn = new ZipInputStream(new FileInputStream(fZip))) {
            ZipEntry entry;

            while ((entry = zipIn.getNextEntry()) != null) {
                byte[] buffer = new byte[1024];
                int length;
                try(DataOutputStream out = new DataOutputStream(new FileOutputStream("./resources/extracted/" + entry.getName()))) {
                    while ((length = zipIn.read(buffer)) >= 0) {
                        out.write(buffer, 0, length);
                    }
                }
            }
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }
}
