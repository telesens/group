package com.github.telesens.group.afanasiev.module_2_04;

import java.io.*;

/**
 * Created by oleg on 12/10/15.
 */
public class Main {

    private static String ext = ".hff";
    private static String fSrcName = "file.txt";
    private static String fSrcPath;
    private static String fDstPackedPath;
    private static String fDstExtractedPath;

    private static HuffmanCodding hArc;

    private static String baseName = "huff";
    private static String baseFlagHelp = "--help";
    private static String baseFlagVersion = "--version";

    private static String packCmd = "pack";
    private static String packCmdDescribe = "Pack file (or several files) using algorithm of Huffman";

    private static String extractCmd = "extract";
    private static String extractCmdDescribe = "Extract file (or several files).";

    private static String helpCmd = "help";
    private static String helpFlagAll = "-a";

    public static void main(String[] args) {
//        if (args.length == 0) {
//            //System.out.printf("You must point path to the file. See '%s %s' %n", baseName, baseFlagHelp);
//            printHelp();
//            return;
//        }
//
//        if (args[0].equals(baseFlagHelp)) {
//            printHelp();
//            return;
//        }
        initResourcesPaths();
        System.out.println("------------Huffman coding----------\n");

        hArc = new HuffmanCodding();
        pack();
        extract();
    }

    private static void initResourcesPaths() {
        fSrcPath = "./resources/source/";
        fDstPackedPath = Main.class.getClassLoader().getResource("packed").getPath() + "/";
        System.out.println(fDstPackedPath);
        fDstExtractedPath = Main.class.getClassLoader().getResource("extracted").getPath() + "/";
    }

    private static void pack() {
        byte[] packed;

        try (DataInputStream in = new DataInputStream(new FileInputStream(fSrcPath + fSrcName));
                DataOutputStream out = new DataOutputStream(new FileOutputStream(fDstPackedPath + fSrcName + ext))) {
            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) >= 0) {
                packed = hArc.code(buffer, length);
                out.write(packed, 0, packed.length);
            }
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void extract() {
        byte[] extracted;

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fDstExtractedPath + fSrcName));
                DataInputStream in = new DataInputStream(new FileInputStream(fDstPackedPath + fSrcName + ext))) {
            byte[] buffer = new byte[1024];

            while (in.read(buffer) >= 0) {
                extracted = hArc.decode(buffer);
                out.write(extracted, 0, extracted.length);
            }
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void printHelp() {
        System.out.printf("usage: %s [%s] [%s] %n %n", baseName, baseFlagVersion, baseFlagHelp);
        System.out.printf("The most commonly used %s commands are: %n", baseName);
        System.out.printf("%3s%-10s %s %n", " ", packCmd, packCmdDescribe);
        System.out.printf("%3s%-10s %s %n %n", " ", extractCmd, extractCmdDescribe);
        System.out.printf("'%s %s %s' lists available subcommands. See '%s %s <command>' to read about a specific subcommand.",
                baseName, helpCmd, helpFlagAll, baseName, helpCmd);
    }
}
