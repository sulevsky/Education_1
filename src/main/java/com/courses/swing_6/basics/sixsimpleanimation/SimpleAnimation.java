package com.courses.swing_6.basics.sixsimpleanimation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vovka on 13.06.2015.
 */
public class SimpleAnimation {
    private int frameSleepTime = 50;
    public static void main(String[] args){
        SimpleAnimation animation = new SimpleAnimation();
        animation.go();


    }

    private void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BallPanel drawPanel = new BallPanel();
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        JButton speedUp = new JButton("Speed up");
        speedUp.addActionListener(new FastButtonListener());
        JButton speedDown = new JButton("Slow down");
        speedDown.addActionListener(new SlowButtonListener());
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(BorderLayout.EAST,speedUp);
        buttonsPanel.add(BorderLayout.WEST, speedDown);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonsPanel);

        frame.setSize(500, 500);
        frame.setVisible(true);
        while(true){
            frame.setTitle("Frame sleep time is: "+frameSleepTime);
            drawPanel.moveBall();
            frame.repaint();
            try{
                TimeUnit.MILLISECONDS.sleep(frameSleepTime);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private class SlowButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frameSleepTime+=5;
        }
    }
    private class FastButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frameSleepTime-=5;
            //Important can set to less than 0
        }
    }


}
