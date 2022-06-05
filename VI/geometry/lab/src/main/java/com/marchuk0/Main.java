package com.marchuk0;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Max-area triangle");
        frame.add(new MainPanel());
        frame.setSize(1500, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }    
}