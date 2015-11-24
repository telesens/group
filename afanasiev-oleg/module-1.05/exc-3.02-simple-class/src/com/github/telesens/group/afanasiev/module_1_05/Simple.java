package com.github.telesens.group.afanasiev.module_1_05;

/**
 * Created by oleg on 11/24/15.
 */
public class Simple {
    private String name;
    private double price;

    public Simple(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f UAH", name, price);
    }

}
