package com.marchuk0;

public class Rectangle extends Figure {

    private double a, b;

    public Rectangle(double a, double b) {
        testPositive(a);
        testPositive(b);
        this.a = a;
        this.b = b;
    }

    @Override
    public double perimeter() {
        return 2 * (a + b);
    }

    @Override
    public double area() {
        return a * b;
    }
}
