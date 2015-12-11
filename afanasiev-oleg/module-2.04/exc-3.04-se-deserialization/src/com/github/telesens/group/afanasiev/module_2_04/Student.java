package com.github.telesens.group.afanasiev.module_2_04;

import java.io.Serializable;

/**
 * Created by oleg on 12/6/15.
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -1L;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, age: %d %n", name, age);
    }
}
