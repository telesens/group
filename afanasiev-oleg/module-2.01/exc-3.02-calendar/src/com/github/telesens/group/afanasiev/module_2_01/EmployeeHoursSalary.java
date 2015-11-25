package com.github.telesens.group.afanasiev.module_2_01;

import java.util.Calendar;

/**
 * Created by oleg on 11/25/15.
 */
public class EmployeeHoursSalary extends Employee {
    private int hours = 168;
    private double payByHour;

    public EmployeeHoursSalary(String firstName, String lastName, Gender gender, Calendar birthday, String country, String company, String position, double payByHour) {
        super(firstName, lastName, gender, birthday, country, company, position);
        this.payByHour = payByHour;
    }

    public EmployeeHoursSalary(Person person, String country, String company, String position, double payByHour) {
        super(person, country, company, position);
        this.payByHour = payByHour;
    }

    public EmployeeHoursSalary(Citizen citizen, String company, String position, double payByHour) {
        super(citizen.getFirstName(), citizen.getLastName(), citizen.getGender(), citizen.getBirthday(), citizen.getCountry(), company, position);
        this.payByHour = payByHour;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getPayByHour() {
        return payByHour;
    }

    public void setPayByHour(double payByHour) {
        this.payByHour = payByHour;
    }

    @Override
    public double salaryByMonth() {
        return hours * payByHour;
    }

    @Override
    public String toString() {
        return String.format("%s, (company: %s, position: %s, salary: %.2f UAH)",
                super.toString(), getCompany(), getPosition(), salaryByMonth());
    }
}
