package com.courses.swing_6.basics.fiveinnerclasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtonsApp {
    private JLabel jLabel;
    private int numOfButtonPushed = 0;
    private TestPanel testPanel = new TestPanel();
    public static void main(String[] args) {
        TwoButtonsApp app = new TwoButtonsApp();
        app.go();
    }

    private void go() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton labelButton = new JButton("Change label");
        labelButton.addActionListener(new LabelListener());

        JButton catButton = new JButton("Move cat");
        catButton.addActionListener(new CatListener());
//explain lambda  catButton.addActionListener((ActionEvent e)->{testPanel.moveCat();});


        jLabel = new JLabel("I am a label");

        jFrame.getContentPane().add(BorderLayout.SOUTH, catButton);
        jFrame.getContentPane().add(BorderLayout.CENTER, testPanel);
        jFrame.getContentPane().add(BorderLayout.EAST, labelButton);
        jFrame.getContentPane().add(BorderLayout.WEST, jLabel);
        jFrame.setSize(600, 600);
        jFrame.setVisible(true);
    }

    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numOfButtonPushed++;
            jLabel.setText("Pushed times: " + numOfButtonPushed);
        }
    }

    class CatListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            testPanel.moveCat();
//            jFrame.repaint();
        }
    }
}
