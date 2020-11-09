package com.marchuk0.oopht;

import java.util.concurrent.RecursiveAction;

abstract class Shape {
    abstract int perimetr();

    public abstract Shape clone();

    public abstract void info();
}

class Triangle extends Shape {

    private int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    int perimetr() {
        return a + b + c;
    }

    @Override
    public Shape clone() {
        return new Triangle(a, b, c);
    }

    @Override
    public void info() {
        System.out.printf("Triangle: perimetr = %d%n", perimetr());
    }
}

class Rectangle extends Shape {

    private int a, b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    int perimetr() {
        return a + b + a + b;
    }

    @Override
    public Shape clone() {
        return new Rectangle(a, b);
    }

    @Override
    public void info() {
        System.out.printf("Rectangle: perimetr = %d%n", perimetr());
    }
}


public class PrototypeApp {
    public static void main(String[] args) {
        Shape triangle = new Triangle(10, 10, 10);
        triangle.clone().info();
        Shape rectangle = new Rectangle(10, 10);
        rectangle.clone().info();
    }
}
