package com.github.telesens.group.afanasiev.module_2_04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by oleg on 12/7/15.
 */
public class Group {
    private String name;
    private Collection<Student> students;

    public Group(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        if (!students.contains(student))
            students.add(student);
    }

    public void removeStudent(Student student) {
        if (students.contains(student))
            students.remove(student);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Group: %s%n", name));

        for (Student student : students) {
            sb.append(String.format("%s %n", student));
        }
        return sb.toString();
    }
}
