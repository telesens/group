package com.github.telesens.group.afanasiev.module_2_01;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
    private Calendar birthday;

    public Person(String firstName, String lastName, Gender gender, Calendar birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
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

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        Calendar calendarNow = GregorianCalendar.getInstance();
        calendarNow.setTime(new Date());

        return calendarNow.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, age: %d",
                firstName, lastName, gender.getName(), getAge());
    }
}
