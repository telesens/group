package com.github.telesens.group.afanasiev.module_2_04;

import java.io.*;

/**
 * Created by oleg on 12/6/15.
 */
public class Main {
    private static Group group;
    private static Student st;
    private static String fGroup = "./resources/group.dat";
    private static String fStudent = "./resources/student.dat";

    public static void main(String[] args) {
        System.out.println("------------Test of serialization and deserialization------------");
        initGroup();
        serialize();
        deserialize();
    }

    private static void initGroup() {
        group = new Group(3);
        st = new Student("Katya", 19);

        group.addStudent(new Student("Oleg", 34));
        group.addStudent(new Student("Andry", 26));
        group.addStudent(st);
    }

    private static void serialize() {
        try (ObjectOutputStream outGroup = new ObjectOutputStream(new FileOutputStream(fGroup));
             ObjectOutputStream outStudent = new ObjectOutputStream(new FileOutputStream(fStudent))) {

            outGroup.writeObject(group);
            outStudent.writeObject(st);

        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void deserialize() {
        Student st;
        Group gr;
        try (ObjectInputStream inGroup = new ObjectInputStream(new FileInputStream(fGroup));
                ObjectInputStream inStudent = new ObjectInputStream(new FileInputStream(fStudent))) {

            st = (Student)inStudent.readObject();
            gr = (Group)inGroup.readObject();

            System.out.println(st);
            System.out.println(gr);
        } catch(IOException | ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }
}
