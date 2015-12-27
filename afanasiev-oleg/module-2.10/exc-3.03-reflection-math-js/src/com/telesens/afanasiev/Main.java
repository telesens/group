/*
    Создать программу, которая позволяет вводить математические выражения,
    вычислять и выводить результат. Выражение может состоять из констант,
    математических операций и скобок.
    Для реализации использовать средства пакета javax.script.

    Примечание. Синтаксис математических выражений JavaScript полностью аналогичен Java.
    Результат можно выводить с помощью функции print() без создания дополнительных переменных.
 */

package com.telesens.afanasiev;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

/**
 * Created by oleg on 12/27/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter math expression (example: 2+2*2-1):  ");
        String exp = new Scanner(System.in).nextLine();

        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            Object result = engine.eval("res = "+exp+";");
            System.out.printf("%s = %s %n",exp, result);
        } catch(ScriptException exc) {
            exc.printStackTrace();
        }
    }
}
