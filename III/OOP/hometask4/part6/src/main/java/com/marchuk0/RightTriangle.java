package com.marchuk0;

public class RightTriangle extends Triangle {


    public RightTriangle(double a, double b) {
        super(a, b, Math.PI / 2);
    }

    @Override
    public double area() {
        return a * b / 2;
    }

    @Override
    public double perimeter() {
        return a + b + Math.sqrt(a * a + b * b);
    }
}
