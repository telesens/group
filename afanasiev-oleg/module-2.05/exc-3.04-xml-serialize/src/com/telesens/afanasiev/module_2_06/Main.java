package com.telesens.afanasiev.module_2_06;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by oleg on 12/26/15.
 */
public class Main {
    private static Group group;
    private static Group deserializedGroup;

    public static void main(String[] args) {
        System.out.println("------------Xml serialization and deserialization--------\n");
        init();
        System.out.println(group);
        serialization();
        deserialization();
        System.out.println(deserializedGroup);
    }

    private static void init() {
        group = new Group("MM-121");
        group.addStudent(new Student("Oleg", 34, "oleg.kh34@gmail.com"));
        group.addStudent(new Student("Kolya", 45, "kolya.kh45@gmail.com"));
        group.addStudent(new Student("Liza", 12, "liza.kh12@gmail.com"));
        group.addStudent(new Student("Alex", 23, "alex.kh23@gmail.com"));
        group.addStudent(new Student("Mikle", 22, "mikle.kh22@gmail.com"));
        group.addStudent(new Student("Helen", 18, "helen.kh18@gmail.com"));
    }

    private static void serialization() {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("./resources/group.xml"))) {
            xmlEncoder.writeObject(group);
            xmlEncoder.flush();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void deserialization() {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("./resources/group.xml"))) {
            deserializedGroup = (Group)xmlDecoder.readObject();
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }
}
