package com.github.telesens.group.afanasiev.module_1_05;

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

        persons[0] = new Person("Oleg", "Afanasiev", Gender.MALE);
        persons[1] = new Person("Katya", "Devyatkina", Gender.FEMALE);
        persons[2] = new Person("Yakow", "Shestakov", Gender.MALE);

        persons[3] = new Citizen("Vlad", "Petrow", Gender.MALE, "Ukraine");
        persons[4] = new Citizen("Ivan", "Sidorow", Gender.MALE, "Russian");
    }

    private static void printPersons() {
        for (int i = 0; i < N; i++)
            System.out.println(persons[i]);
    }

    private static void initEmployees() {
        employees = new Employee[M];

        // Employees with fixed salary

        employees[0] = new EmployeeFixedSalary("Olya", "Kaznacheeva", Gender.FEMALE, "Ukraine", "SoftServe", "HR", 12000);
        ((EmployeeFixedSalary)employees[0]).setPercBonus(5);

        employees[1] = new EmployeeFixedSalary(persons[0], "Ukriane", "telesens", "java developer", 14000);
        ((EmployeeFixedSalary)employees[1]).setPercBonus(3);

        employees[2] = new EmployeeFixedSalary(new Citizen("Kolya", "Narishko", Gender.MALE, "USA"), "Sigma", "team lead", 65000);


        // Employees with per hours salary
        employees[3] = new EmployeeHoursSalary(persons[1], "Ukriane", "artJoker", "copywriter", 150);
        ((EmployeeHoursSalary)employees[3]).setHours(109);
        employees[4] = new EmployeeHoursSalary(new Citizen("Peter", "Sharikov", Gender.MALE, "Belarus"), "Intetics", "QA", 80);
    }

    private static void printEmployees() {
        for (int i = 0; i < M; i++)
            System.out.println(employees[i]);
    }
}
