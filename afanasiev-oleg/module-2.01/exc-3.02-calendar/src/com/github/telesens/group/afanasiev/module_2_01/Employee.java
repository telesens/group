package com.github.telesens.group.afanasiev.module_2_01;

import java.util.Calendar;

/**
 * Created by oleg on 11/25/15.
 */
public abstract class Employee extends Citizen {
    private String company;
    private String position;

    public Employee(String firstName, String lastName, Gender gender, Calendar birthday, String country, String company, String position) {
        super(firstName, lastName, gender, birthday, country);
        this.company = company;
        this.position = position;
    }

    public Employee(Person person, String country, String company, String position) {
        super(person, country);
        this.company = company;
        this.position = position;
    }

    public Employee(Citizen citizen, String company, String position) {
        super(citizen.getFirstName(), citizen.getLastName(), citizen.getGender(), citizen.getBirthday(), citizen.getCountry());
        this.company = company;
        this.position = position;
    }

    abstract double salaryByMonth();

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
