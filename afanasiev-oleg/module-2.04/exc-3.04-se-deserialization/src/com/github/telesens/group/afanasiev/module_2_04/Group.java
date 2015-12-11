package com.github.telesens.group.afanasiev.module_2_04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by oleg on 12/6/15.
 */
public class Group implements Serializable{
    private static final long serialVersionUID = -1L;
    private int number;
    private Collection<Student> listStudents;

    public Group(int number) {
        this.number = number;
        listStudents = new ArrayList<>();
    }

    public void addStudent(Student student) {
        listStudents.add(student);
    }

    public void removeStudent(Student student) {
        listStudents.remove(student);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("List of students: \n");

        for (Student st : listStudents)
            sb.append(st);

        return sb.toString();
    }
}
