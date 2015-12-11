package com.github.telesens.group.afanasiev.module_2_04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by oleg on 12/8/15.
 */
public class Main {
    private static String[] fSrcNames = {"./resources/file1.txt", "./resources/file2.txt", "./resources/file3.txt"};
    private static String[] fDstNames = {"file1.txt", "file2.txt", "file3.txt"};
    private static String fZip = "./resources/packed/arc.zip";

    public static void main(String[] args) {
        System.out.println("-------------Try pack to *.zip----------------");
        pack();
    }

    private static void pack() {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(fZip))) {
            ZipEntry entry;

            for (int i = 0; i < fSrcNames.length; i++) {
                entry = new ZipEntry(fDstNames[i]);
                zipOut.putNextEntry(entry);
                byte[] buffer = new byte[1024];
                int length;

                try(FileInputStream in = new FileInputStream(fSrcNames[i])) {
                    while ((length = in.read(buffer)) >= 0) {
                        zipOut.write(buffer, 0, length);
                    }
                }
                zipOut.closeEntry();
            }
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }
}
