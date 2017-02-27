package com.courses.swing_6.basics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource().getClass());
        ((JButton)(e.getSource())).setText("Pushed");


	}
}
