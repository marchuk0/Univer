package com.marchuk0.oopht;

interface Component {
    void operation();
}

class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("I am New Year Tree");
    }
}

abstract class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

class ConcreteDecorator1 extends Decorator {

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("I have toy!");
    }
}

class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("I have garland!");
    }

}

public class DecoratorApp {
    public static void main(String[] args) {
        new ConcreteDecorator2(
                new ConcreteDecorator1(
                        new ConcreteComponent()))
                .operation();


    }
}
