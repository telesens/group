/*
    Создать консольное приложение, в котором пользователь вводит имя метода класса и
    получает информацию обо всех аннотациях, которыми помечен данный метод.
 */
package com.telesens.afanasiev.module_2_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by oleg on 12/27/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("------------Get annotations by method name------------\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input name of class (for example 'java.util.Date') # ");
        String className = scanner.nextLine();

        System.out.print("Input name of method ('UTC') # ");
        String methodName = scanner.nextLine();

        try {
            Class<?> cls = Class.forName(className);
            String name;
            for (Method method : cls.getMethods()) {
                name = method.getName();
                if (name.equals(methodName))
                    for (Annotation annotation : method.getAnnotations())
                        System.out.println(annotation);
            }
        } catch(ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }
}
