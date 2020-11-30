package com.marchuk0.lab2.parser;

import com.marchuk0.lab2.Car;

import java.io.File;
import java.util.List;

public interface Parser
{
    List<Car> parse(File file);
}
