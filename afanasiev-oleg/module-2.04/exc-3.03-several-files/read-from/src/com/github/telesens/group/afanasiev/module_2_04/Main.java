package com.github.telesens.group.afanasiev.module_2_04;

import java.io.*;
import java.util.PriorityQueue;

/**
 * Created by oleg on 12/6/15.
 */
public class Main {
    private static PriorityQueue<Integer> queue;
    private static String fSrcEven = "./resources/dst-even.dat";
    private static String fSrcUnEven = "./resources/dst-uneven.dat";
    private static String fDst = "./resources/order.txt";

    public static void main(String[] args) {
        System.out.println("----------Read from \"*.data\" and save to \"order.txt\"");

        readFrom();
        saveTo();
    }

    private static void readFrom() {
        queue = new PriorityQueue<>((i1, i2)->(i2.compareTo(i1)));
        int nextInt;

        // read even numbers
        try(DataInputStream inEven = new DataInputStream(new FileInputStream(fSrcEven))) {
            while(true) {
                nextInt = inEven.readInt();
                queue.add(nextInt);
            }
        } catch(IOException exc) {
        }

        // read uneven numbers
        try (DataInputStream inUneven = new DataInputStream(new FileInputStream(fSrcUnEven))) {
            while(true) {
                nextInt = inUneven.readInt();
                queue.add(nextInt);
            }

        } catch(IOException exc) {
        }
    }

    private static void saveTo() {
        try (PrintWriter pw = new PrintWriter(fDst)) {
            pw.println("The numbers ordered by descend: ");

            while (queue.peek() != null)
                pw.printf("%d ", queue.poll());

            pw.close();
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }
}
