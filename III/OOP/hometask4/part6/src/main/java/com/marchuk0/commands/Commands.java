package com.marchuk0.commands;

import com.marchuk0.IsoscelesTriangle;;
import com.marchuk0.RightTriangle;
import com.marchuk0.Triangle;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class Commands {

    private Triangle triangle;

    @ShellMethod("createRightTriangle")
    public void createRightTriangle(@ShellOption double a,
                                    @ShellOption double b) {
        triangle = new RightTriangle(a, b);
    }

    @ShellMethod("createIsoscelseTriangle")
    public void createIsoscelesTriangle(@ShellOption double a,
                                        @ShellOption double angle) {
        triangle = new IsoscelesTriangle(a, angle);
    }

    @ShellMethod("info")
    public void info() {
        System.out.println(triangle.toString());
    }


}