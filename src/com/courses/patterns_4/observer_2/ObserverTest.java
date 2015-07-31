package com.courses.patterns_4.observer_2;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ObserverTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Observer test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("Click!");
        ActionListener listener = new MyButtonListener();
        button.addActionListener(listener);
        ActionListener textChenger =
                new TextChanger(button);
        button.addActionListener(textChenger);
        frame.getContentPane().add(button);

        frame.setResizable(false);
        frame.setSize(300,300);
        frame.setVisible(true);


    }
}
