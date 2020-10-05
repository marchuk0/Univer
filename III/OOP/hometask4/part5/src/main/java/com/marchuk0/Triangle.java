package com.marchuk0;

public class Triangle extends Figure {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        testPositive(a);
        testPositive(b);
        testPositive(c);
        testTriangle(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    protected void testTriangle(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a){
            throw new ArithmeticException("Not a triangle");
        }
    }
}
