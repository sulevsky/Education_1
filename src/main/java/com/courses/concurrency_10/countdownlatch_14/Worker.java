package com.courses.concurrency_10.countdownlatch_14;

import java.util.concurrent.CountDownLatch;

/**
 * Created by VSulevskiy on 23.09.2015.
 */
public class Worker extends Thread {
    private CountDownLatch countDownLatch;

    private String name;

    public Worker(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    public void run() {
        long start = System.currentTimeMillis();
        System.out.println(name + " working");
        long sleepTime = RandomGenerator.getRandom(1000, 3000);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        long duration = System.currentTimeMillis() - start;
        System.out.println(name + " time: " + duration + " ms");
    }

}
