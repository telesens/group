package com.github.telesens.group.afanasiev.module_2_04;

import java.io.*;

/**
 * Created by oleg on 12/6/15.
 */
public class Main {
    private static String fName = "./resources/arr.dat";
    private static GenArray<Institute> listInstitutes;

    public static void main(String[] args) {
        System.out.println("-----Serialize and deserialize of the generic array-----");
        init();
        serialize();
        deserialize();
    }

    private static void init() {
        listInstitutes = new GenArray<Institute>();
        listInstitutes.addEl(new Institute("HPI"));
        listInstitutes.addEl(new Institute("HNU"));
    }

    private static void serialize() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fName))) {
            out.writeObject(listInstitutes);
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void deserialize() {
        GenArray<Institute> arr;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fName))) {
            arr = (GenArray<Institute>)in.readObject();
            System.out.println(arr);
        } catch(IOException | ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }
}
