package com.marchuk0.oopht;

public class AbstractFactory {

    abstract static class Car {
        public abstract void info();
    }

    static class Ford extends Car {
        @Override
        public void info() {
            System.out.println("Ford");
        }
    }

    static class Toyota extends Car {
        @Override
        public void info() {
            System.out.println("Toyota");
        }
    }

    static class Mercedes extends Car {
        @Override
        public void info() {
            System.out.println("Mercedes");
        }
    }

    abstract static class Engine {
        public abstract void getPower();
    }

    static class FordEngine extends Engine {
        @Override
        public void getPower()
        {
            System.out.println("Ford Engine 4.4");
        }
    }

    static class ToyotaEngine extends Engine
    {
        @Override
        public void getPower()
        {
            System.out.println("Toyota Engine 3.2");
        }
    }

    static class MercedesEngine extends Engine
    {
        @Override
        public void getPower()
        {
            System.out.println("Mercedes Engine 6.3");
        }
    }

    //AbstractFactory
    interface CarFactory
    {
        Car createCar();
        Engine createEngine();
    }

    // ConcreteFactory1
    static class FordFactory implements CarFactory
    {
        // from CarFactory
        @Override
        public Car createCar() {
            return new Ford();
        }

        @Override
        public Engine createEngine() {
            return new FordEngine();
        }
    }

    static class ToyotaFactory implements CarFactory
    {
        // from CarFactory
        @Override
        public Car createCar() {
            return new Toyota();
        }

        @Override
        public Engine createEngine() {
            return new ToyotaEngine();
        }
    }

    static class MercedesFactory implements CarFactory {
        @Override
        public Car createCar() {
            return new Mercedes();
        }

        @Override
        public Engine createEngine() {
            return new MercedesEngine();
        }
    }


    public static void main(String[] args) {
        CarFactory carFactory = new ToyotaFactory();
        Car myCar = carFactory.createCar();
        myCar.info();
        Engine myEngine = carFactory.createEngine();
        myEngine.getPower();
        carFactory = new FordFactory();
        myCar = carFactory.createCar();
        myCar.info();
        myEngine = carFactory.createEngine();
        myEngine.getPower();

        carFactory = new MercedesFactory();
        myCar = carFactory.createCar();
        myCar.info();
        myEngine = carFactory.createEngine();
        myEngine.getPower();

    }
}
