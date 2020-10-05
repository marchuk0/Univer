package com.marchuk0.commands;

import com.marchuk0.*;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class Commands {

    private Figure figure;

    @ShellMethod("createTriangle")
    public void createTriangle(@ShellOption double a,
                               @ShellOption double b,
                               @ShellOption double c){
        figure = new Triangle(a, b, c);
    }

    @ShellMethod("createCircle")
    public void createCircle(@ShellOption double radius)
    {
        figure = new Circle(radius);
    }

    @ShellMethod("createRectangle")
    public void createRectangle(@ShellOption double a, @ShellOption double b)
    {
        figure = new Rectangle(a, b);
    }

    @ShellMethod("createSquare")
    public void createSquare(@ShellOption double side)
    {
        figure = new Square(side);
    }

    @ShellMethod("createRhombus")
    public void createRhombus(@ShellOption double side, double angle)
    {
        figure = new Rhombus(side, angle);
    }

    @ShellMethod("info")
    public void info() {
        System.out.println(figure.toString());
    }








}