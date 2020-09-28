package com.marchuk0.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld {
    private JButton helloButton;
    private JPanel panel;
    private JTextArea textArea1;

    public HelloWorld() {
        helloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    textArea1.selectAll();
                textArea1.replaceSelection("Hello World!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorld");
        frame.setContentPane(new HelloWorld().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
