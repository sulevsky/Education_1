package com.courses.concurrency_100.secondcounter_2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by VSulevskiy on 16.07.2015.
 */

/**
 * IMPORTANT DOESN'T WORK LOCKS THE SYSTEM
 */
public class App extends JPanel {
    SecondCounterLookup counterLookup;
    JButton startButton;
    JButton stopButton;

    public App() {
        counterLookup = new SecondCounterLookup();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);

        startButton.addActionListener(e -> {
            startButton.setEnabled(false);
            counterLookup.runClock();

            stopButton.setEnabled(true);
            startButton.requestFocus();
        });
        stopButton.addActionListener(e -> {
            stopButton.setEnabled(false);
            counterLookup.stopClock();
            startButton.setEnabled(true);
            startButton.requestFocus();
        });
        JPanel innerButtonPanel = new JPanel();
        innerButtonPanel.setLayout(new GridLayout(0, 1, 0, 3));
        innerButtonPanel.add(startButton);
        innerButtonPanel.add(stopButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(innerButtonPanel, BorderLayout.NORTH);
        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.add(buttonPanel, BorderLayout.WEST);
        this.add(counterLookup,BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        App app = new App();
        JFrame frame = new JFrame("Second counter");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(app);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
