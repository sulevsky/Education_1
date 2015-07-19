package com.courses.concurrency_100.producerconcumer;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class SyncTest {
    public static void main(String[] args) {
        SyncStack syncStack = new SyncStack();
        Producer producer1 = new Producer(syncStack,1);
        Thread prodOneThread = new Thread(producer1);
        prodOneThread.start();

        Producer producer2 = new Producer(syncStack,2);
        Thread prodTwoThread = new Thread(producer2);
        prodTwoThread.start();

        Consumer consumer1 = new Consumer(syncStack,1);
        Thread consOneThread = new Thread(consumer1);
        consOneThread.start();

        Consumer consumer2 = new Consumer(syncStack,2);
        Thread consTwoThread = new Thread(consumer2);
        consTwoThread.start();

        //second iteration
        BlockingQueue queue = new ArrayBlockingQueue(3);
    }

}
