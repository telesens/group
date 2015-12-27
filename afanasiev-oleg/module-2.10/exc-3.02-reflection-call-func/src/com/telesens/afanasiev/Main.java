/*
    Создать классы с одинаково называющимися методами. Выбрать класс по имени и вызвать его метод.
 */
package com.telesens.afanasiev;

/**
 * Created by oleg on 12/26/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---------------Reflection call method--------------\n");

        new ClassOne().method();
        new ClassTwo().method();
    }
}
