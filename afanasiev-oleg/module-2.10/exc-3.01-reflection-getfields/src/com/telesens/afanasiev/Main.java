/*
    Создать консольное приложение, в котором пользователь вводит имя класса и
    получает информацию обо всех полях этого класса (включая закрытые и защищенные).
 */

package com.telesens.afanasiev;

import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * Created by oleg on 12/26/15.
 */
public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("------------Getting list fields from the class------------\n");

        System.out.print("Enter name of same class (java.lang.String): ");
        String name = new Scanner(System.in).next().trim();

        try {
            Class<?> o = Class.forName(name);
            System.out.println(fieldsToString(o));
        } catch(ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }

    public static String fieldsToString(Class<?> o) {
        StringBuilder sb = new StringBuilder();
        Field[] fields = o.getFields();
        sb.append(String.format("[%n"));
        for (int i = 0; i < fields.length; i++) {
            sb.append(String.format("\"%s\"%n", fields[i]));
        }
        sb.append(String.format("]"));

        return sb.toString();
    }
}
