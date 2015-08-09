package com.courses.swing_6.layout_4;

import javax.swing.*;
import java.awt.*;

/**
 * Created by VSulevskiy on 03.08.2015.
 */
public class App {
    public static void main (String [] args) {
        JFrame myFrame = new MyFrame();
        Container container = myFrame.getContentPane();
        container.setLayout(new BorderLayout());
        JButton buttonUp = new JButton("Up");
        container.add(buttonUp, BorderLayout.NORTH);
        JButton buttonDown = new JButton("Down");
        container.add(buttonDown,BorderLayout.SOUTH);
        JButton buttonLeft = new JButton("Left");
        container.add(buttonLeft,BorderLayout.WEST);
        JButton buttonRight = new JButton("Right");
        container.add(buttonRight,BorderLayout.EAST);

        myFrame.setVisible(true);
    }
}
