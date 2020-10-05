package com.marchuk0;

public class Rhombus extends Figure {

    private double side, angle;

    public Rhombus(double side, double angle) {
        testPositive(side);
        testRhombusAngle(angle);
        this.side = side;
        this.angle = angle;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }

    @Override
    public double area() {
        return side * side * Math.sin(angle);
    }

    protected void testRhombusAngle(double angle) {
        if (angle <= 0 || angle >= Math.PI) {
            throw new ArithmeticException("wrong angle");
        }
    }
}
