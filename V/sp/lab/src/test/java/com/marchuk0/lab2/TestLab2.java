package com.marchuk0.lab2;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class TestLab2 {
    private static File resourcesDirectory = new File("src/test/resources");

    @Test
    public void test1() throws FileNotFoundException {
        File file = new File(resourcesDirectory, "lab2_test1.txt"); 
        NFA nfa = new NFA(file);
        assertTrue(nfa.checkAllWords(1));
        assertFalse(nfa.checkAllWords(2));
    }

    @Test
    public void test2() throws FileNotFoundException {
        File file = new File(resourcesDirectory, "lab2_test2.txt");
        NFA nfa = new NFA(file);
        assertTrue(nfa.checkAllWords(1));
        assertTrue(nfa.checkAllWords(5));
        assertTrue(nfa.checkAllWords(9));
        assertTrue(nfa.checkAllWords(15));
        
        assertFalse(nfa.checkAllWords(2));
        assertFalse(nfa.checkAllWords(4));
        assertFalse(nfa.checkAllWords(6));
    }

    @Test
    public void test3() throws FileNotFoundException {
        File file = new File(resourcesDirectory, "lab2_test3.txt");
        NFA nfa = new NFA(file);
        for (int i = 1; i <=10; i++) {
            assertTrue(nfa.checkAllWords(i));
        }
    }
    
}
