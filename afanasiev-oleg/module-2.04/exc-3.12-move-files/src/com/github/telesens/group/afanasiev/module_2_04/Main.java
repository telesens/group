package com.github.telesens.group.afanasiev.module_2_04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by oleg on 12/9/15.
 */
public class Main {
    private static String dirSrc = "./resources/dirSrc";
    private static String dirDst = "./resources/dirDst";

    public static void main(String[] args) {
        System.out.printf("---------Try move (rename) dir \"%s\" to dir \"%s\"--------%n", dirSrc, dirDst);
        move();
    }

    private static void move() {
        Path pathSrc = Paths.get(dirSrc);
        Path pathDst = Paths.get(dirDst);

        try {
            Files.move(pathSrc, pathDst, StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }
}
