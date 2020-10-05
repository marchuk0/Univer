package com.marchuk0.commands;

import com.marchuk0.EquilateralTriangle;
import com.marchuk0.Triangle;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class Commands {

    private Triangle triangle;

    @ShellMethod("createTriangle")
    public void createTriangle(@ShellOption double a,
                               @ShellOption double b,
                               @ShellOption double c){
        triangle = new Triangle(a, b, c);
    }

    @ShellMethod("create Equilateral Triangle")
    public void createEqTriangle(@ShellOption double side) {
        triangle = new EquilateralTriangle(side);
    }

    @ShellMethod("set side of triangle")
    public void setSide(@ShellOption(defaultValue = "a") sideEnum side, @ShellOption double sideLen) {
        switch (side) {
            case a:
                triangle.setA(sideLen);
                break;
            case b:
                triangle.setB(sideLen);
                break;
            case c:
                triangle.setC(sideLen);
                break;
        }
    }

    @ShellMethod("info")
    public void info() {
        System.out.println(triangle.toString());
    }

    enum sideEnum{
        a, b, c
    }

}