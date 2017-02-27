package com.courses.swing_6.sweingmodern;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by VSulevskiy on 07.08.2015.
 */
public class Test1 extends JFrame {
    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    private JPanel panel1;
    public JTextField textField1;
    private JPasswordField passwordField1;

    public static void main(String[] args) {
        Test1 frame = new Test1();
        frame.setContentPane(frame.getPanel1());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        operate(frame.textField1);
        frame.setVisible(true);
    }

    public static void operate(JTextField field) {
        field.addActionListener((ActionEvent e)-> System.out.println("printed"));
    }
}
