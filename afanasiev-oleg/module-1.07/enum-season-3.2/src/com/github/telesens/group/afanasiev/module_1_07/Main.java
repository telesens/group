package com.github.telesens.group.afanasiev.module_1_07;

/**
 * Created by oleg on 11/22/15.
 */
enum Seasons {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN;

    static void printAll() {
        System.out.println("All seasons: ");
        for (Seasons s : values()) {
            System.out.println(s);
        }
    }

    Seasons next() {
        return values()[(ordinal() + 1) % values().length];
    }

    Seasons prev() {
        return values()[(ordinal() + 3) % values().length];
    }
}

public class Main {
    public static void main(String[] args) {
        Seasons.printAll();
        testNextSeason();
        testPreviousSeason();
    }

    private static void testNextSeason() {
        System.out.println("\n---test next season---\n");
        for (Seasons s : Seasons.values())
            System.out.printf("%s, next %s %n", s, s.next());
    }

    private static void testPreviousSeason() {
        System.out.println("\n---test prev season---\n");
        for (Seasons s : Seasons.values())
            System.out.printf("%s, prev %s %n", s, s.prev());
    }
}
