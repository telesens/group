package com.github.telesens.group.afanasiev.module_2_04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

/**
 * Created by oleg on 12/8/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("----------Get attribute about file or dir---------\n");
        System.out.print("(-h|-r|+s|+a: ");
        System.out.println("not hidden, not readonly, system, archive)\n");

        System.out.println("Getting attributes about root dir: ");
        System.out.println(getAttributd("."));

        System.out.println("Getting attributes about file \"Main.java\": ");
        System.out.println(getAttributd("./src/com/github/telesens/group/afanasiev/module_2_04/Main.java"));

        System.out.println("Getting attributes about dir \".idea\"");
        System.out.println(getAttributd(".idea"));

        System.out.println("Getting attributes about dir \"temp.zip\"");
        System.out.println(getAttributd("./temp.zip"));
    }

    private static String getAttributd(String fName) {
        Path path = Paths.get(fName);
        try {
            DosFileAttributes attr = Files.readAttributes(path, DosFileAttributes.class);
            return readAttr(attr);

        } catch(IOException exc) {
            exc.printStackTrace();
        }
        return "";
    }

    private static String readAttr(DosFileAttributes attr) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-20s %s %n", "Type:", getType(attr)));
        sb.append(String.format("%-20s %.3f K %n", "Size:", convertByteToKByte(attr.size())));
        sb.append(String.format("%-20s %s %n", "Text:", getAddAttr(attr)));

        sb.append(String.format("%-20s %s %n", "Create:", attr.creationTime()));
        sb.append(String.format("%-20s %s %n", "Last access:", attr.lastAccessTime()));
        sb.append(String.format("%-20s %s %n", "Last modification:", attr.lastModifiedTime()));


        return sb.toString();
    }

    private static double convertByteToKByte(long bytes) {
        return bytes/1024.0;
    }

    private static String getAddAttr(DosFileAttributes attr) {
        StringBuilder sb = new StringBuilder();

        sb.append(attr.isHidden() ? "+h" : "-h");
        sb.append(attr.isReadOnly() ? "+r" : "-r");
        sb.append(attr.isSystem() ? "+s" : "-s");
        sb.append(attr.isArchive() ? "+a" : "-a");

        return sb.toString();
    }

    private static String getType(DosFileAttributes attr) {
        StringBuilder sb = new StringBuilder();

        sb.append(attr.isDirectory() ? "Directory" : "File");

        return sb.toString();
    }
}
