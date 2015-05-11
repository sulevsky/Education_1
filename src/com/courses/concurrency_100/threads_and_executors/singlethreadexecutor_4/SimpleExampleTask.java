package com.courses.concurrency_100.threads_and_executors.singlethreadexecutor_4;

/**
 * Created by VSulevskiy on 08.05.2015.
 */
public class SimpleExampleTask implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello " + threadName);
    }
}
