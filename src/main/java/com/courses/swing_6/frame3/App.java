package com.courses.swing_6.frame3;

import javax.swing.*;
import java.awt.*;

/**
 * Created by VSulevskiy on 03.08.2015.
 */
public class App {
    public static void main (String [] args) {
        JFrame myFrame = new MyFrame();
        JButton button = new JButton("Hello");
        Container container = myFrame.getContentPane();//Container
        container.add(button);
        myFrame.setVisible(true);
    }
}
