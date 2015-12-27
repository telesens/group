/*
    Создать классы с одинаково называющимися методами. Выбрать класс по имени и вызвать его метод.
 */
package com.telesens.afanasiev;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by oleg on 12/26/15.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("---------------Reflection call method--------------\n");

        ClassOne classOne = new ClassOne();
        ClassTwo classTwo = new ClassTwo();

        try {
            Method methodOne = Class.forName("com.telesens.afanasiev.ClassOne").getMethod("method");
            Method methodTwo = Class.forName("com.telesens.afanasiev.ClassTwo").getMethod("method");

            methodOne.invoke(classOne);
            methodTwo.invoke(classTwo);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException exc) {
            exc.printStackTrace();
        }
    }
}
