package com.marchuk0.lab4.io.utils;

public record Pair<U, V>(U first, V second) {

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

}
