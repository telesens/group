package com.github.telesens.group.afanasiev.module_2_01;

import java.util.Calendar;

/**
 * Created by oleg on 11/25/15.
 */
public class EmployeeFixedSalary extends Employee {
    private double salary;
    private int percBonus;

    public EmployeeFixedSalary(String firstName, String lastName, Gender gender, Calendar birthday, String country, String company, String position, double salary) {
        super(firstName, lastName, gender, birthday, country, company, position);
        this.salary = salary;
        this.percBonus = 0;
    }

    public EmployeeFixedSalary(Person person, String country, String company, String position, double salary) {
        super(person, country, company, position);
        this.salary = salary;
        this.percBonus = 0;
    }

    public EmployeeFixedSalary(Citizen citizen, String company, String position, double salary) {
        super(citizen.getFirstName(), citizen.getLastName(), citizen.getGender(), citizen.getBirthday(), citizen.getCountry(), company, position);
        this.salary = salary;
        this.percBonus = 0;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPercBonus() {
        return percBonus;
    }

    public void setPercBonus(int percBonus) {
        this.percBonus = percBonus;
    }

    @Override
    public double salaryByMonth() {
        return salary + salary * percBonus /100;
    }

    @Override
    public String toString() {
        return String.format("%s, job: [company: %s, position: %s, salary: %.2f UAH]",
                super.toString(), getCompany(), getPosition(), salaryByMonth());
    }
}
