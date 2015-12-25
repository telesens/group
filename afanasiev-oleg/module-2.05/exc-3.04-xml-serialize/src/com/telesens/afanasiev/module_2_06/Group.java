package com.telesens.afanasiev.module_2_06;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by oleg on 12/26/15.
 */
public class Group implements Serializable {
    private static final long serialVersionUID = -1L;
    private String name;
    private Collection<Student> students;

    public Group() {
        students = new ArrayList<>();
    }

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

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("                  Группа: \"%s\" %n", name));
        sb.append(String.format("+----------------+----------------+-----------------------+%n"));
        sb.append(String.format("|       Имя      |     Возраст    |           email       |%n"));
        sb.append(String.format("+----------------+----------------+-----------------------+%n"));

        for (Student student : students) {
            sb.append(String.format("| %-14s | %-14s | %-21s | %n",
                    student.getName(), student.getAge(), student.getEmail()));
        }

        sb.append(String.format("+----------------+----------------+-----------------------+%n"));

        return sb.toString();
    }
}
