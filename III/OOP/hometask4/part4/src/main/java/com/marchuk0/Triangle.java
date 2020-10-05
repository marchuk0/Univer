package com.marchuk0;

public class Triangle {

    protected double b;
    protected double c;
    protected double a;

    public Triangle(double a, double b, double c) {
        checkTriangleAndThrowException(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private void checkTriangleAndThrowException(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new ArithmeticException("Wrong sides for triangle");
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new ArithmeticException("Sides must be positive");
        }
    }

    private double findAngle(double a, double b, double c) {
        return Math.acos((a * a + b * b - c * c) / (2 * a * b));
    }


    public double getA() {
        return a;
    }

    public void setA(double a) {
        checkTriangleAndThrowException(a, b, c);
        this.a = a;
    }

    public double getAngleA() {
        return findAngle(b, c, a);
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        checkTriangleAndThrowException(a, b, c);
        this.b = b;
    }

    public double getAngleB() {
        return findAngle(a, c, b);
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        checkTriangleAndThrowException(a, b, c);
        this.c = c;
    }

    public double getAngleC() {
        return findAngle(a, b, c);
    }

    public double perimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
            return this.getClass().toString() +
                    " " +
                    "a : side=" + a + " angle=" + getAngleA() +
                    ", b : " + b + " angle=" + getAngleB() +
                    ", c : " + c + " angle=" + getAngleC() +
                    " ";
    }
}
