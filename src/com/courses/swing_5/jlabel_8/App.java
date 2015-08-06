package com.courses.swing_5.jlabel_8;

import javax.swing.*;
import java.awt.*;
import java.net.NoRouteToHostException;

/**
 * Created by VSulevskiy on 03.08.2015.
 */
public class App {
    public static void main(String[] args) {
        JFrame myFrame = new MyFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel labelText = new JLabel("Hello guys");
        panel.add(labelText, BorderLayout.NORTH);
        JLabel labelImage =
                new JLabel("Hello guys",
                        new ImageIcon("resourses\\dropped.jpg"), SwingConstants.LEFT);
        panel.add(labelImage, BorderLayout.SOUTH);
        myFrame.setContentPane(panel);
        myFrame.setVisible(true);
    }
}
