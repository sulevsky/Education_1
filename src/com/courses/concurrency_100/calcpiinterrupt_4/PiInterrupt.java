package com.courses.concurrency_100.calcpiinterrupt_4;

import sun.awt.windows.ThemeReader;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class PiInterrupt implements Runnable{
    private double latestPiEstimate;
    @Override
    public void run() {
        System.out.println("for comparison, Math.PI " + Math.PI);
        try {
            calcPi(0.00000001);
        } catch (InterruptedException e) {
            Thread.currentThread().resume();
            System.out.println("Interrupted, latest pi = " + latestPiEstimate);
            return;
        }
        System.out.println("within accuracy latest Pi estimate " + latestPiEstimate);


    }

    private void calcPi(double accuracy) throws InterruptedException {
        latestPiEstimate = 0.0;
        long i = 0;
        int sign = -1;
        while(Math.abs(latestPiEstimate-Math.PI)>accuracy){
            if(Thread.interrupted()){
                throw new InterruptedException();
            }
            i++;
            sign *=-1;
            latestPiEstimate += sign * 4.0 /((2*i)-1);
        }
    }

    public static void main(String[] args) {
        PiInterrupt piInterrupt = new PiInterrupt();
        Thread thread = new Thread(piInterrupt);
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread ended");

    }
}
