package com.courses.concurrency_10.suspendresume_5;

import javax.swing.*;
import java.awt.*;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class VisualSuspendResume extends JPanel implements Runnable {
    private static final String[] symbolList = {"|", "/", "-", "\\"};

    private Thread runThread;
    private JTextField symbolTextField;

    public VisualSuspendResume() {
        symbolTextField = new JTextField();
        symbolTextField.setEditable(false);
        symbolTextField.setFont(new Font("Monospaced", Font.BOLD, 26));
        symbolTextField.setHorizontalAlignment(JTextField.CENTER);

        JButton suspendButton = new JButton("Suspend");
        suspendButton.addActionListener(e -> suspendNow());
        JButton resumeButton = new JButton("Resume");
        resumeButton.addActionListener(e -> resumeNow());
        JPanel innerStackPanel = new JPanel();
        innerStackPanel.setLayout(new GridLayout(0, 1, 3, 3));
        innerStackPanel.add(symbolTextField);
        innerStackPanel.add(suspendButton);
        innerStackPanel.add(resumeButton);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(innerStackPanel);
    }

    private void resumeNow() {
        if (runThread != null) {
            runThread.resume();
        }
    }

    private void suspendNow() {
        if (runThread != null) {
            runThread.suspend();
        }
    }

    @Override
    public void run() {
        try {
            runThread = Thread.currentThread();
            int count = 0;
            while (true) {
                Thread.sleep(200);
                symbolTextField.setText(symbolList[count % symbolList.length]);
                count++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            runThread = null;
        }
    }

    public static void main(String[] args) {
        VisualSuspendResume visualSuspendResume = new VisualSuspendResume();
        Thread thread = new Thread(visualSuspendResume);
        thread.start();
        JFrame frame =  new JFrame("Visual suspend resume");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setContentPane(visualSuspendResume);
        frame.setSize(400,400);
        frame.setVisible(true);

    }
}
