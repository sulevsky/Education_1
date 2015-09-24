package com.courses.concurrency_10.countdownlatch_14;

import java.util.concurrent.CountDownLatch;

/**
 * Created by VSulevskiy on 23.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(4);

        Worker sand = new Worker(countDownLatch, "Sand");
        Worker water = new Worker(countDownLatch, "Water");
        Worker cement = new Worker(countDownLatch, "Cement");
        Worker stone = new Worker(countDownLatch, "Stone");

        sand.start();
        water.start();
        cement.start();
        stone.start();

        System.out.println("Waiting all workers");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All workers finished. Now we can prepare concrete");

        long duration = System.currentTimeMillis() - start;
        System.out.println("Program time: " + duration + " ms");

    }
}
