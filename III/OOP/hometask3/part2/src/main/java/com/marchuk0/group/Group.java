package com.marchuk0.group;

import com.marchuk0.student.Student;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final String name;
    private List<Student> students = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getName() {
        return "Group-name: " + name;
    }

    public String getInfo() {
        var builder = new StringBuilder(getName()).append(", Students: [");
        for (Student student: students) {
            builder.append(student.getInfo()).append(", ");
        }
        return builder.append("]").toString();
    }

    public String getFullInfo() {
        var builder = new StringBuilder(getName()).append(" Students: [");
        for (Student student: students) {
            builder.append(student.getFullInfo()).append(", ");
        }
        return builder.append("]").toString();
    }
}
