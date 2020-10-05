package com.marchuk0;

public abstract class Figure {
    abstract public double perimeter();

    abstract public double area();

    public String toString() {
        return this.getClass().toString() +
                " " +
                "area : " + area() +
                ", parimeter : " + perimeter() +
                " ";
    }

    protected void testPositive(double a) {
        if (a <= 0) {
            throw new ArithmeticException(",ust be non negative");
        }
    }
}
