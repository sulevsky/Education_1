package com.courses.concurrency_10.secondcounter_2.fixed;

import javax.swing.*;

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
//
//        startButton.addActionListener(e -> {
//            startButton.setEnabled(false);
//            Thread counterThread = new Thread(counterLookup,"Second Counter");
//            counterThread.start();
//
//            stopButton.setEnabled(true);
//            startButton.requestFocus();
//        });
//        stopButton.addActionListener(e -> {
//            stopButton.setEnabled(false);
//            counterLookup.stopClock();
//            startButton.setEnabled(true);
//            startButton.requestFocus();
//        });
//        JPanel innerButtonPanel = new JPanel();
//        innerButtonPanel.setLayout(new GridLayout(0, 1, 0, 3));
//        innerButtonPanel.add(startButton);
//        innerButtonPanel.add(stopButton);
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new BorderLayout());
//        buttonPanel.add(innerButtonPanel, BorderLayout.NORTH);
//        this.setLayout(new BorderLayout(10, 10));
//        this.setBorder(new EmptyBorder(20, 20, 20, 20));
//        this.add(buttonPanel, BorderLayout.WEST);
//        this.add(counterLookup,BorderLayout.CENTER);
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
