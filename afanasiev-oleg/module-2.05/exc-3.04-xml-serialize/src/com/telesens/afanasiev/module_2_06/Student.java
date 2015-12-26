package com.telesens.afanasiev.module_2_06;

import java.io.Serializable;

/**
 * Created by oleg on 12/26/15.
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -1L;
    private String name;
    private int age;
    private String email;

    public Student() {

    }

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
