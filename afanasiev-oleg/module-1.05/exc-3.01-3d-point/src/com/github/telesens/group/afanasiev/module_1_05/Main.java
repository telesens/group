package com.github.telesens.group.afanasiev.module_1_05;

/**
 * Created by oleg on 11/24/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("----test of 3D-point class------");
        Point3D p1 = new Point3D(3, 4, 3);
        System.out.println(p1.distance());
        Point3D p2 = new Point3D(4, 5, 6);
        System.out.println(Point3D.distance(p1, p2));

        System.out.printf("p1 = %s %n", p1);
        System.out.printf("p1.distanse = %.2f %n %n", p1.distance());

        System.out.printf("p2 = %s %n", p2);
        System.out.printf("p2.distance = %.2f %n%n", p2.distance());

        System.out.printf("distance between p1 and p2 = %.2f %n", Point3D.distance(p1, p2));
    }
}
