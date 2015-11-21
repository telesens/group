package com.github.telesens.group.afanasiev.module_1_07;
/**
 * Created by oleg on 11/22/15.
 */
enum DaysOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    static void printAll() {
        System.out.println("----Days of week----");
        for (DaysOfWeek d : values())
            System.out.println(d);
    }

    static DaysOfWeek dayAfterTomorrow(DaysOfWeek dayToday) {
        return DaysOfWeek.values()[(dayToday.ordinal() + 2) % values().length];
    }

    static DaysOfWeek dayBeforeYestarday(DaysOfWeek dayToday) {
        return DaysOfWeek.values()[(dayToday.ordinal() + 5) % values().length];
    }
}

public class Main {
    public static void main(String[] args) {
        DaysOfWeek.printAll();
        testDaysAfterTomorrow();
        testDaysBeforeYestarday();
    }

    private static void testDaysAfterTomorrow() {
        System.out.println("\n-----test of days after tomorrow-----\n");
        for (DaysOfWeek day : DaysOfWeek.values()) {
            System.out.printf("today: %s, day after tomorrow: %s %n", day.toString(), DaysOfWeek.dayAfterTomorrow(day).toString());
        }
    }

    private static void testDaysBeforeYestarday() {
        System.out.println("\n-----test of days before yesterday-----\n");
        for (DaysOfWeek day : DaysOfWeek.values()) {
            System.out.printf("today: %s, day before yesterday: %s %n", day.toString(), DaysOfWeek.dayBeforeYestarday(day).toString());
        }
    }
}
