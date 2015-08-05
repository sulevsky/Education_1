package com.courses.swing_5.layout_6;

import javax.swing.*;
import java.awt.*;

/**
 * Created by VSulevskiy on 03.08.2015.
 */
public class App {
    public static void main (String [] args) {
        JFrame myFrame = new MyFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,4,5,5));
        JButton buttonUp = new JButton("Up");
        JButton buttonDown = new JButton("Down");
        JButton buttonLeft = new JButton("Left");
        JButton buttonRight = new JButton("Right");
        panel.add(buttonUp);
        panel.add(buttonDown);
        panel.add(buttonLeft);
        panel.add(buttonRight);
        myFrame.setContentPane(panel);
//        myFrame.pack();
        myFrame.setVisible(true);
    }
}
