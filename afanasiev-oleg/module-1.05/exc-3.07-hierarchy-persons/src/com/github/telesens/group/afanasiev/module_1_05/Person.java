package com.github.telesens.group.afanasiev.module_1_05;
import java.io.Serializable;

/**
 * Created by oleg on 11/25/15.
 */
enum Gender {
    MALE("male"),
    FEMALE("female");

    String name;

    Gender(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private Gender gender;

    public Person(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", firstName, lastName, gender.getName());
    }
}
