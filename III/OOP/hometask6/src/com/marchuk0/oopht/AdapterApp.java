package com.marchuk0.oopht;

interface USPlug{
    void plugToUsSocket();
}
class ConcreteUSPlug implements USPlug {

    @Override
    public void plugToUsSocket() {
        System.out.println("I am plugged to US Socket");
    }
}

interface EUPlug {
    void plugToEuSocket();
}
class EUToUSAdapter implements EUPlug {

    USPlug adaptee;
    public EUToUSAdapter(USPlug usPlug) {
        adaptee = usPlug;
    }
    @Override
    public void plugToEuSocket() {
        System.out.println("Using EU to US Adapter");
        adaptee.plugToUsSocket();
    }
}

class User {
    public static void chargePhone() {
        System.out.println("Charging phone with EU plug and Us Socket");
        USPlug usPlug = new ConcreteUSPlug();
        EUPlug euPlug = new EUToUSAdapter(usPlug);
        euPlug.plugToEuSocket();
    }
}



public class AdapterApp {
    public static void main(String[] args) {
        User.chargePhone();
    }
}
