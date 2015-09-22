package com.courses.mvc_12.view;

import javax.swing.*;


public class BeatBar extends JProgressBar implements Runnable {

    private Thread thread;

    public BeatBar() {
        thread = new Thread(this);
        thread.setDaemon(true);
        setMaximum(100);
        thread.start();
    }

    @Override
    public void run() {
        while(true){
            int value = getValue();
            value = (int)(value*0.75);
            setValue(value);
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
