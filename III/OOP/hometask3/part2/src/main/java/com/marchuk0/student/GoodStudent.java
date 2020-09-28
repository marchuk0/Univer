package com.marchuk0.student;

public class GoodStudent extends Student {
    public GoodStudent(String name) {
        super(name);
        study();
        read();
        write();
        read();
        write();
        relax();
    }

    @Override
    public void study() {
        concatToState("good");
    }
}
