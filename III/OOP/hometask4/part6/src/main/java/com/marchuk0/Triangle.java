package com.marchuk0;

public abstract class Triangle {

    protected double a;
    protected double b;
    protected double angle;

    public Triangle(double a, double b, double angle) {
        checkPositive(a);
        checkPositive(b);
        checkAngle(angle);
        this.a = a;
        this.b = b;
        this.angle = angle;
    }

    abstract public double area();

    abstract public double perimeter();

    @Override
    public String toString() {
        return this.getClass().toString() +
                " " +
                "a = " + a +
                ", b = " + b +
                ", angle : " + angle +
                ", area : " + area() +
                ", perimeter : " + perimeter() +
                " ";
    }

    private void checkPositive(double a) {
        if (a <= 0) {
            throw new ArithmeticException("must be positive");
        }
    }

    private void checkAngle(double angle) {
        if(angle <= 0 || angle >= Math.PI) {
            throw new ArithmeticException("Wrong angle");
        }
    }
}
