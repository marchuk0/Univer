package com.marchuk0;

public class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double a, double angle) {
        super(a, a, angle);
    }

    @Override
    public double area() {
        return a * a * Math.sin(angle);
    }

    @Override
    public double perimeter() {
        return a + a + Math.sqrt(2 * a * a * (1 - Math.cos(angle)));
    }
}
