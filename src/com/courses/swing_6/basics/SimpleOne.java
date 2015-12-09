package com.courses.swing_6.basics;

import javax.swing.*;

public class SimpleOne {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JButton button = new JButton("Button text");
        ButtonActionListener listener = new ButtonActionListener();
        button.addActionListener(listener);
        jFrame.getContentPane().add(button);

        jFrame.setSize(400, 300);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    //single threaded
}
