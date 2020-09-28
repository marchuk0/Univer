package com.marchuk0.commands;

import com.marchuk0.group.Group;
import com.marchuk0.student.BadStudent;
import com.marchuk0.student.GoodStudent;
import com.marchuk0.student.Student;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class AddStudentCommand {

    private final List<Student> studentList = new ArrayList<>();
    private final List<Group> groupList = new ArrayList<>();

    @ShellMethod("Add student")
    public void createStudent(@ShellOption(help = "type good|bad") String type,
                              @ShellOption(help = "name") String name) {
        if (type.equals("good")) {
            studentList.add(new GoodStudent(name));
        } else if (type.equals("bad")) {
            studentList.add(new BadStudent(name));
        } else {
            System.out.println("Wrong type option");
        }
    }

    @ShellMethod("List students")
    public void listStudents() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("Student " + i + " " + studentList.get(i).getFullInfo());
        }
    }

    @ShellMethod("Add group")
    public void createGroup(@ShellOption(help = "name") String name) {
        groupList.add(new Group(name));
    }

    @ShellMethod("List groups")
    public void listGroups(@ShellOption(defaultValue = "false") Boolean full) {
        for (int i = 0; i<groupList.size(); i++) {
            System.out.println("Group " + i + " " + (full ? groupList.get(i).getFullInfo(): groupList.get(i).getInfo()));
        }
    }

    @ShellMethod("Add student to group")
    public void addStudent(@ShellOption(help = "Student number") Integer studentNumber,
                           @ShellOption(help = "Group Number") Integer groupNumber) {
        if(studentNumber < studentList.size() && groupNumber < groupList.size()) {
            groupList.get(groupNumber).addStudent(studentList.get(studentNumber));
        } else {
            System.out.println("Incorrect params");
        }
    }

}