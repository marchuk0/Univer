package com.marchuk0.student;

public abstract class Student {
    private String name;
    private String state;

    public Student(String name) {
        this.name = name;
        this.state = "";
    }

    public String getInfo() {
        return "Student-name: " + name;
    }

    public String getFullInfo() {
        return getInfo() + " state: " + state;
    }

    void concatToState(String action) {
        state = state.concat(action);
        state = state.concat(" ");
    }

    public void relax() {
        concatToState("Relax");
    }
    public void read() {
        concatToState("Read");
    }
    public void write() {
        concatToState("Write");
    }
    public abstract void study();
}
