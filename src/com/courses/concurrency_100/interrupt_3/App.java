package com.courses.concurrency_100.interrupt_3;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class App {
    public static void main(String[] args) {
        SleepInterrupt sleepInterrupt = new SleepInterrupt();
        Thread t = new Thread(sleepInterrupt);
        t.start();

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            //
        }
        System.out.println("In main interrupting other thread");
        t.interrupt();
        System.out.println("In main leaving");

    }
}
