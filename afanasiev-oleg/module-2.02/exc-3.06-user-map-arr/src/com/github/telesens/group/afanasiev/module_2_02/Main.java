package com.github.telesens.group.afanasiev.module_2_02;

/**
 * Created by oleg on 12/2/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-----Hash array about users------");

        Users users = new Users();

        users.setPassword("Oleg", "bla-bla-bla");
        users.setPassword("Oleg", "bombibom");
        users.setPassword("Kolya", "qwerty");
        users.setPassword("Rita", "blyad'");

        System.out.printf("Oleg -> %s %n", users.getPassword("Oleg"));
        System.out.printf("Lena -> %s %n", users.getPassword("Lena"));

        System.out.println("All users: ");
        System.out.println(users);
    }
}
