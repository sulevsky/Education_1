package com.courses.swing_6.basics.three;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vovka on 01.06.2015.
 */
public class RepaintListener implements ActionListener{
    JFrame frame;
    public RepaintListener(JFrame frame){
        this.frame = frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
}
