package com.marchuk0;

public class EquilateralTriangle extends Triangle {
    private double area;

    public EquilateralTriangle(double a) {
        super(a, a, a);
        recalcArea();
    }

    @Override
    public void setA(double a) {
        this.a = this.b = this.c = a;
        recalcArea();
    }

    @Override
    public void setB(double b) {
        this.setA(b);
    }

    @Override
    public void setC(double c) {
        this.setA(c);
    }

    public double getArea() {
        return area;
    }

    private void recalcArea() {
        area = Math.sqrt(3) * getA() / 4;
    }

    @Override
    public String toString() {
        return super.toString() + " area= " + getArea();
    }
}
