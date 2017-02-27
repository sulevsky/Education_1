package com.courses.swing_6.basics.three;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vovka on 01.06.2015.
 */
public class LayoutTestApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Change colors");

        RepaintListener repaintListener = new RepaintListener(frame);
        button.addActionListener(repaintListener);
        JPanel randomColorOvalsPanel = new RandomColorDrawPanel();

        frame.getContentPane().add(BorderLayout.EAST,button);
        frame.getContentPane().add(BorderLayout.CENTER,randomColorOvalsPanel);

        frame.setSize(400,400);
        frame.setVisible(true);

        //try to  change window size

    }
}
