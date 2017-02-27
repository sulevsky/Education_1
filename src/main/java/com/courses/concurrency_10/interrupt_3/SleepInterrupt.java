package com.courses.concurrency_10.interrupt_3;

/**
 * Created by VSulevskiy on 18.07.2015.
 */
public class SleepInterrupt implements Runnable {
    @Override
    public void run() {
        System.out.println("in run is about to sleep for 20 seconds");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted while sleeping");
            return;
        }
        System.out.println("Doing stuff after nap");
        System.out.println("Leaving normally");
    }
}
