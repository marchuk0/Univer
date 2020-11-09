package com.marchuk0.oopht;

abstract class ShapesCreator {
    public abstract Shape createShape();
}

class RectanglesCreator extends ShapesCreator {

    @Override
    public Shape createShape() {
        return new Rectangle(10, 10);
    }
}

class TriangleCreator extends ShapesCreator {

    @Override
    public Shape createShape() {
        return new Triangle(10, 10, 10);
    }
}

public class FactoryMethodApp {
    public static void main(String[] args){
        ShapesCreator shapesCreator = new RectanglesCreator();
        shapesCreator.createShape().info();

        shapesCreator = new TriangleCreator();
        shapesCreator.createShape().info();
    }
}
