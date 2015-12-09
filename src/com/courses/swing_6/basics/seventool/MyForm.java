package com.courses.swing_6.basics.seventool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by VSulevskiy on 16.07.2015.
 */
public class MyForm extends JFrame implements ActionListener{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton submitButton;

    public MyForm(){
        super("Simple form");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setSize(300,300);
        setVisible(true);
    }


    public static void main(String[] args) {
        MyForm form = new MyForm();
        form.submitButton.addActionListener(form);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Person person = new Person(textField1.getText(),
                textField2.getText(),
                Integer.parseInt(textField3.getText()));
        System.out.println(person);
    }

}
