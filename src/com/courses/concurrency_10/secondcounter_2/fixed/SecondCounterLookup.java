package com.courses.concurrency_10.secondcounter_2.fixed;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Created by VSulevskiy on 16.07.2015.
 */
public class SecondCounterLookup extends JComponent implements Runnable {
    private volatile boolean keepRunning;
    private Font textFont;
    private volatile String timeMessage;
    private volatile int arcLen;

    public SecondCounterLookup() {
        textFont = new Font("SansSerif", Font.BOLD, 14);
        timeMessage = "not started";
        arcLen = 0;
    }

    public void run(){
        runClock();
    }
    public void runClock() {
        System.out.println("Thread is running clock " + Thread.currentThread().getName());

        DecimalFormat format = new DecimalFormat("0.000");
        int normalSleepTime = 100;
        int counter = 0;
        keepRunning = true;

        while(keepRunning){
            try{
                Thread.sleep(normalSleepTime);
            }catch (InterruptedException e){
                // do nothing
            }
            counter++;
            double counterSecs = counter/10.0;
            timeMessage = format.format(counterSecs);
            arcLen =(((int)counterSecs%60)*360)/60;

            repaint();
        }
    }
    public void stopClock(){
        keepRunning =false;
    }
    @Override
    public void paint(Graphics g){
        System.out.println("Thread invoked the paint() " + Thread.currentThread().getName());
        g.setColor(Color.BLACK);
        g.setFont(textFont);
        g.drawString(timeMessage, 0, 15);
        g.fillOval(0, 20, 100, 100);

        g.setColor(Color.WHITE);
        g.fillOval(3, 23, 94, 94);

        g.setColor(Color.BLUE);
        g.fillArc(2,22,96,96,90,-arcLen);
    }
}
