package com.courses.swing_6.basics.sixlayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by VSulevskiy on 16.07.2015.
 */
public class MyTextArea implements ActionListener {
    JTextArea textArea;
    public static void main(String[] args) {
        MyTextArea textArea = new MyTextArea();
        textArea.go();

    }

    private void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Click and test");
        button.addActionListener(this);
        textArea = new JTextArea(10,20);
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scrollPane);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH,button);

        frame.setSize(600,600);
        frame.setVisible(true);
    }

    @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append("Button is clicked\n");
        }
}
