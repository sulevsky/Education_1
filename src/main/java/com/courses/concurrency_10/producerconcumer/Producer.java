package com.courses.concurrency_10.producerconcumer;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class Producer implements Runnable {

    public static final int NUM_OF_ITERATIONS = 100;
    private SyncStack syncStack;
    private int number;

    public Producer(SyncStack syncStack, int number) {
        this.syncStack = syncStack;
        this.number = number;
    }

    @Override
    public void run() {
        char c;
        for (int i = 0; i < NUM_OF_ITERATIONS; i++) {
            c = (char) (Math.random() * 26 + 'A');
            syncStack.push(c);
            System.out.println("Producer " + number + " " + c);
            try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
