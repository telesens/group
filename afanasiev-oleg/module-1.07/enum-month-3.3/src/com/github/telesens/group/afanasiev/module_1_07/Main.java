package com.github.telesens.group.afanasiev.module_1_07;

/**
 * Created by oleg on 11/22/15.
 */
enum Seasons {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN;

    @Override
    public String toString() {
        switch (this) {
            case WINTER:
                return "\"Зима\"";

            case SPRING:
                return "\"Весна\"";

            case SUMMER:
                return "\"Лето\"";

            case AUTUMN:
                return "\"Осень\"";

            default:
                return "";
        }
    }
}

enum Months {
    JANUARY (31, "Январь", "Сiчень"),
    FEBRUARY (28, "Февраль", "Лютий"),
    MARCH (31, "Март", "Березень"),
    APRIL (30, "Апрель", "Квiтень"),
    MAY (31, "Май", "Травень"),
    JUNE (30, "Июнь", "Червень"),
    JULY (31, "Июль", "Липень"),
    AUGUST (31, "Август", "Серпень"),
    SEPTEMBER (30, "Сентябрь", "Вересень"),
    OCTOBER (31, "Октябрь", "Жовтень"),
    NOVEMBER (30, "Ноябрь", "Листопад"),
    DECEMBER (31, "Декабрь", "Грудень");

    private int countDays;
    private String rusName;
    private String ukrName;

    Months(int countDays, String rusName, String ukrName) {
        this.countDays = countDays;
        this.rusName = rusName;
        this.ukrName = ukrName;
    }

    public Months next() {
        return values()[(ordinal() + 1) % values().length];
    }

    public Months prev() {
        return values()[(ordinal() + 11) % values().length];
    }

    public String getRusName() {
        return this.rusName;
    }

    public String getUkrName() {
        return this.ukrName;
    }

    public Seasons getSeason() {
        switch (this) {
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                return Seasons.WINTER;

            case MARCH:
            case APRIL:
            case MAY:
                return Seasons.SPRING;

            case JUNE:
            case JULY:
            case AUGUST:
                return Seasons.SUMMER;

            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
                return Seasons.AUTUMN;
        }

        return null;
    }

    @Override
    public String toString() {
        return String.format("%s (%s), days %d, season %s", getRusName(), getUkrName(), countDays, getSeason());
    }

    public static void printAll() {
        for (Months m : values())
            System.out.println(m);
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("\n---Test enum month---\n");
        Months.printAll();
        testNextPrev();
    }

    private static void testNextPrev() {
        System.out.println("\n---test prev()/next() and getRusName()/getUkrName()---\n");
        for (Months m : Months.values()) {
            System.out.println(String.format("%s, next %s, prev %s", m.getRusName(), m.next().getRusName(), m.prev().getRusName()));
            System.out.println(String.format("%s, next %s, prev %s %n", m.getUkrName(), m.next().getUkrName(), m.prev().getUkrName()));
        }
    }
}
