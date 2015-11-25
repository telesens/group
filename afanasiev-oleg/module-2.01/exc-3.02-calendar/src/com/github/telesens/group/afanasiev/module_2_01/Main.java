package com.github.telesens.group.afanasiev.module_2_01;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by oleg on 11/25/15.
 */
public class Main {
    private static final int N = 5;
    private static final int M = 5;
    private static Person[] persons;
    private static Employee[] employees;

    public static void main(String[] args) {
        System.out.println("------Test hierarchy of person---------");
        initPerson();
        printPersons();

        initEmployees();
        printEmployees();
    }

    private static void initPerson() {

        persons = new Person[N];

        persons[0] = new Person("Oleg", "Afanasiev", Gender.MALE, getCalendar(1981, Calendar.JUNE, 13));
        persons[1] = new Person("Katya", "Devyatkina", Gender.FEMALE, getCalendar(1989, Calendar.FEBRUARY, 3));
        persons[2] = new Person("Yakow", "Shestakov", Gender.MALE, getCalendar(1982, Calendar.AUGUST, 20));

        persons[3] = new Citizen("Vlad", "Petrow", Gender.MALE, getCalendar(1974, Calendar.DECEMBER, 23), "Ukraine");
        persons[4] = new Citizen("Ivan", "Sidorow", Gender.MALE, getCalendar(1995, Calendar.MAY, 5), "Russian");
    }

    private static void printPersons() {
        for (int i = 0; i < N; i++)
            System.out.println(persons[i]);
    }

    private static void initEmployees() {
        employees = new Employee[M];

        // Employees with fixed salary

        employees[0] = new EmployeeFixedSalary("Olya", "Kaznacheeva", Gender.FEMALE, getCalendar(1991, Calendar.AUGUST, 27), "Ukraine", "SoftServe", "HR", 12000);
        ((EmployeeFixedSalary)employees[0]).setPercBonus(5);

        employees[1] = new EmployeeFixedSalary(persons[0], "Ukriane", "telesens", "java developer", 14000);
        ((EmployeeFixedSalary)employees[1]).setPercBonus(3);

        employees[2] = new EmployeeFixedSalary(new Citizen("Kolya", "Narishko", Gender.MALE, getCalendar(1988, Calendar.JANUARY, 1), "USA"), "Sigma", "team lead", 65000);


        // Employees with per hours salary
        employees[3] = new EmployeeHoursSalary(persons[1], "Ukriane", "artJoker", "copywriter", 150);
        ((EmployeeHoursSalary)employees[3]).setHours(109);
        employees[4] = new EmployeeHoursSalary(new Citizen("Peter", "Sharikov", Gender.MALE, getCalendar(1983, Calendar.JULY, 17), "Belarus"), "Intetics", "QA", 80);
    }

    private static void printEmployees() {
        for (int i = 0; i < M; i++)
            System.out.println(employees[i]);
    }

    private static Calendar getCalendar(int year, int month, int day) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_WEEK, day);
        calendar.set(Calendar.MONTH, month);

        return calendar;
    }
}
