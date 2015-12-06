package com.github.telesens.group.afanasiev.module_2_04;

import java.io.*;
import java.util.*;

/**
 * Created by oleg on 12/6/15.
 */
public class Main {
    private static Collection<Integer> evenList;
    private static Collection<Integer> unevenList;
    private static String fSrcName = "./resources/src.txt";
    private static String fDstEven = "./resources/dst-even.dat";
    private static String fDstUneven = "./resources/dst-uneven.dat";

    public static void main(String[] args) {
        System.out.println("----------Read all integer numbers from src.txt and save: " +
                "even numbers to \"even.dat\", uneven numbers to \"uneven.dat\" ");

        readNumbers();
        saveNumbers();
    }

    private static void readNumbers() {
        evenList = new ArrayList<>();
        unevenList = new ArrayList<>();
        int nextInt;

        try(Scanner scanner = new Scanner(new FileReader(fSrcName))) {
            while (scanner.hasNextInt()) {
                nextInt = scanner.nextInt();
                if ( (nextInt & 1) == 0)
                    evenList.add(nextInt);
                else
                    unevenList.add(nextInt);
            }

            scanner.close();
        } catch(IOException | NoSuchElementException exc) {
            exc.printStackTrace();
        }
    }

    private static void saveNumbers() {
        try (DataOutputStream outEven = new DataOutputStream(new FileOutputStream(fDstEven));
                DataOutputStream outUnEven = new DataOutputStream(new FileOutputStream(fDstUneven))) {
            for (int iEven : evenList) {
                outEven.writeInt(iEven);
            }

            for (int iUneven : unevenList) {
                outUnEven.writeInt(iUneven);
            }

        } catch (IOException  exc ) {
            exc.printStackTrace();
        }
    }
}
