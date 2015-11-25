package com.github.telesens.group.afanasiev.module_2_01;

import java.util.Calendar;

/**
 * Created by oleg on 11/25/15.
 */
public class Citizen extends Person {
    private String country;

    public Citizen(String firstName, String lastName, Gender gender, Calendar birthday, String country) {
        super(firstName, lastName, gender, birthday);
        this.country = country;
    }

    public Citizen(Person person, String country) {
        super(person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthday());
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", super.toString(), country);
    }
}
