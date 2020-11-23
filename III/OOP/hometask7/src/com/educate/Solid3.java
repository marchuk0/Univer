package com.educate;

public class Main
{
    public static void main(String[] args)
    {
        Square square = new Square();
        square.setSide(10);
        System.out.println(square.getArea());
    }
}

interface ShapeAreaInterface {
    int getArea();
}
interface RectanleInterface extends ShapeAreaInterface {
    int getWidth();
    void setWidth(int width);

    int getHeight();
    void setHeight(int height);

}
abstract class Rectangle implements RectanleInterface
{
    protected int width;
    protected int height;
    public abstract int getWidth();
    public abstract void setWidth(int width);

    public abstract int getHeight();
    public abstract void setHeight(int height);

    @Override
    public int getArea()
    {
        return width * height;
    }
}

interface SquareInterface {
    int getSide();
    void setSide(int side);
}
//квадрат наслідується від прямокутника!!!
//interface segregation principle is violated because we must override getWidth and getHeight that are useless in class Square
//we should create interface both for rectangle and square
class Square implements SquareInterface
{

    int side;
    @Override
    public int getSide() {
        return side;
    }

    @Override
    public void setSide(int side) {
        this.side = side;
    }


    @Override
    public int getArea() {
        return side * side;
    }
}