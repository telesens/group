package com.github.telesens.group.afanasiev.module_2_04;

import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by oleg on 12/6/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--------------Trying to read double numbers from \"src.txt\" and save result to \"dst.txt\"");
        Collection<Double> list= readFromFile("./resources/src.txt");

        double absMult= calcAbsMultiply(list.toArray(new Double[]{}));
        saveResult("./resources/dst.txt", absMult);
    }

    private static Collection<Double> readFromFile(String fName) {
        Collection<Double> list = new ArrayList<>();
        double nextDouble;

        try(Scanner scanner = new Scanner(new FileReader(fName))) {
            while(scanner.hasNextDouble()) {
                nextDouble = scanner.nextDouble();
                list.add(nextDouble);
            }

        } catch(IOException | NoSuchElementException  exc) {
            exc.printStackTrace();
        }

        return list;
    }

    private static void saveResult(String fName, double value) {
        try (PrintWriter pw = new PrintWriter(fName)) {
            pw.println(value);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static double calcAbsMultiply(Double[] arr) {
        double result = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                result *= Math.abs(arr[i]);
        }

        return result;
    }
}
