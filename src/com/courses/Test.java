package com.courses;

import javax.swing.*;
import java.awt.*;

/**
 * Created by VSulevskiy on 31.07.2015.
 */
public class Test extends JFrame{
    private JButton button1;
    private JButton button2;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JPanel testPanel;

    public Test() throws HeadlessException {
        setContentPane(testPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();

    }

    public static void main(String[] args) {
        JFrame frame = new Test();

    }

}
