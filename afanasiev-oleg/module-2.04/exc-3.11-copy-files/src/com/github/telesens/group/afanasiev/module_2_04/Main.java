package com.github.telesens.group.afanasiev.module_2_04;

import java.io.*;
import java.util.Arrays;

/**
 * Created by oleg on 12/9/15.
 */
public class Main {
    private static String dirSrc = "./resources/dirSrc";
    private static String dirDst = "./resources/dirDst";
    private static String[] fNames = {"file1.txt", "file2.txt", "file3.txt"};

    public static void main(String[] args) {
        System.out.println("---------Copy files---------\n");
        mkDir();
        copyFiles();
        delDir();
    }

    private static void mkDir() {
        System.out.printf("Create new dir \"%s\" %n", dirDst);

        File file = new File(dirDst);
        file.mkdir();
    }

    private static void copyFiles() {
        System.out.printf("Copy files (%s)from \"%s\" to \"%s\" %n", Arrays.toString(fNames), dirSrc, dirDst);

        File file;
        try {
            for (String fName : fNames) {
                file = new File(dirDst + "/" + fName);
                file.createNewFile();
                copyContent(dirSrc + "/" + fName, dirDst + "/" + fName);
            }
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void delDir() {
        System.out.printf("Delete dir \"%s\" %n", dirSrc);

        File file;

        for (String fName : fNames) {
            file = new File(dirSrc + "/" + fName);
            file.delete();
        }

        file = new File(dirSrc);

        if (!file.delete())
            System.out.println("Couldn't remove dir \"" + dirDst + "\"");
    }

    private static void copyContent(String pathFrom, String pathTo) throws IOException{

        byte[] buffer = new byte[1024];
        int length;

        DataInputStream in = new DataInputStream(new FileInputStream(pathFrom));
        DataOutputStream out = new DataOutputStream(new FileOutputStream(pathTo));

        while ((length = in.read(buffer)) >= 0) {
            out.write(buffer, 0, length);
        }

        in.close();
        out.close();
    }
 }
