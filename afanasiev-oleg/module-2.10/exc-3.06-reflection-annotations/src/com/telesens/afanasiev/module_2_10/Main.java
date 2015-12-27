/*
    Модифицировать пример 2.5 так, чтобы метод вызывался только
    если сам класс помечен аннотацией @Contains и
    значение свойства run аннотации @ToInvoke равно true
    (соответствующую аннотацию необходимо модифицировать).
 */
package com.telesens.afanasiev.module_2_10;

import ua.in.iwanoff.lesson210.LaunchIfAnnotated;

/**
 * Created by oleg on 12/27/15.
 */
public class Main {
    public static void main(String[] args) {
        LaunchIfAnnotated.invkeFromClass("ua.in.iwanoff.lesson210.ATest");
        LaunchIfAnnotated.invkeFromClass("ua.in.iwanoff.lesson210.BTest");
    }
}
