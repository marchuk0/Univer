package com.marchuk0.oopht;

abstract class Mediator {
    public abstract void send(String message,
                              Colleague colleague);
}

// "ConcreteMediator"
class ConcreteMediator extends Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setColleague1(ConcreteColleague1 colleague) {
        colleague1 = colleague;
    }


    public void setColleague2(ConcreteColleague2 colleague) {
        colleague2 = colleague;
    }

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.receive(message);
        } else {
            colleague1.receive(message);
        }
    }
}

// "Colleague"
abstract class Colleague {
    protected Mediator mediator;

    // Constructor
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String message);

    public abstract void receive(String message);

}

// "ConcreteColleague1"
class ConcreteColleague1 extends Colleague {
    // Constructor
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        mediator.send(message, this);
    }
    @Override
    public void receive(String message) {
        System.out.println("Colleague1 gets message: "
                + message);
    }
}

// "ConcreteColleague2"
class ConcreteColleague2 extends Colleague {
    // Constructor
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }
    @Override
    public void send(String message) {
        mediator.send(message, this);
    }
    @Override
    public void receive(String message) {
        System.out.println("Colleague2 gets message: "
                + message);
    }
}


public class MediatorApp {
    public static void main(String[] args) {
        ConcreteMediator m = new ConcreteMediator();
        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);

        m.setColleague1(c1);
        m.setColleague2(c2);

        m.send("How are you?", c1);
        m.send("Fine, thanks", c2);
    }
}
