package com.courses.swing_5.layout_6.manual_7;

import javax.swing.*;
import java.awt.*;

/**
 * Created by VSulevskiy on 03.08.2015.
 */
public class App {
    public static void main (String [] args) {
        JFrame myFrame = new MyFrame();

        JButton button = new JButton(".");
        button.setSize(10,10);
        button.setLocation(20, 20);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(button);
        myFrame.setContentPane(panel);
//        myFrame.pack();
        myFrame.setVisible(true);
        while(true){
            moveButton(panel,button);
        }
    }
    static int dx=1;
    static int dy=1;
    public static void moveButton(JPanel panel,JButton button) {
        double buttonX = button.getLocation().getX();
        double buttonY = button.getLocation().getY();
        if(buttonX+dx>=panel.getWidth() || buttonX+dx<=0){
            dx*=-1;
        }
        if(buttonY+dy>=panel.getHeight() || buttonY+dy<=0){
            dy*=-1;
        }
        buttonX+=dx;
        buttonY+=dy;
        button.setLocation((int)buttonX,(int)buttonY);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
