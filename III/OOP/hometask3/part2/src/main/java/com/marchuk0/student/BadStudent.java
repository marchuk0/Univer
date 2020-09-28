package com.marchuk0.student;

public class BadStudent extends Student {
    public BadStudent(String name) {
        super(name);
        study();
        relax();
        relax();
        relax();
        relax();
        read();
    }

    @Override
    public void study() {
        concatToState("bad");
    }
}
