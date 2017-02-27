package com.courses.swing_6.basics.sixlayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by VSulevskiy on 16.07.2015.
 */
public class MyCheckBox implements ItemListener{
    JCheckBox checkBox;
    public static void main(String[] args) {
        MyCheckBox checkBox = new MyCheckBox();
        checkBox.go();
    }

    private void go() {
        JFrame frame = new JFrame();
        checkBox = new JCheckBox("Not checked");
        checkBox.addItemListener(this);
        frame.getContentPane().add(BorderLayout.NORTH,checkBox);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String text;
        if(checkBox.isSelected())text="on";
        else text="off";
        checkBox.setText(text);
    }
}
