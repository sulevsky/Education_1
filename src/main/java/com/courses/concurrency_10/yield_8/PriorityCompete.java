package com.courses.concurrency_10.yield_8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VSulevskiy on 22.07.2015.
 */
public class PriorityCompete {
    private volatile int count;
    private boolean yield;
    private Thread internalThread;
    private volatile boolean noStopRequested;

    public PriorityCompete(String name, int priority, boolean yield) {
        count = 0;
        this.yield = yield;
        noStopRequested = true;
        Runnable target = new Runnable() {
            @Override
            public void run() {
                try {
                    runWork();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        internalThread = new Thread(target, name);
        internalThread.setPriority(priority);

    }

    private List<Double> list = new ArrayList<Double>();
    private void runWork() throws InterruptedException {
        Thread.yield();
        while (noStopRequested) {
            if (yield) {
                Thread.yield();
            }
            count++;
            for (int i = 0; i < 1000; i++) {
                double x = i * Math.PI / Math.E;
                x+=1;
                list.add(x);
                list.clear();

            }
        }
    }
    public void startRequest() {
        internalThread.start();
    }

    public void stopRequest() {
        noStopRequested = false;
    }

    public int getCount() {
        return count;
    }

    public String getNameAndPriority() {
        return internalThread.getName() + ": priority=" + internalThread.getPriority();
    }

    private static void runSet(int setSize, boolean yield) {

        PriorityCompete[] priorityCompetes = new PriorityCompete[setSize];
        priorityCompetes[0] = new PriorityCompete("PC"+0, 1, yield);
        for (int i = 1; i < setSize; i++) {
            priorityCompetes[i] = new PriorityCompete("PC"+i, 6, yield);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (PriorityCompete priorityCompete : priorityCompetes) {
            priorityCompete.startRequest();
        }
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (PriorityCompete priorityCompete : priorityCompetes) {
            priorityCompete.stopRequest();
        }
        long stopTime = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalCount = 0;
        for (PriorityCompete priorityCompete : priorityCompetes) {
            totalCount += priorityCompete.getCount();
        }
        System.out.println("Total count = " + totalCount + ", count/ms=" + (double) totalCount / (stopTime - startTime));
        for (PriorityCompete pc : priorityCompetes) {
            double perc = 100.0 * pc.getCount() / totalCount;
            System.out.println(pc.getNameAndPriority() + ", " + perc + "%, count= " + pc.getCount());
        }

    }

    public static void main(String[] args) {
        int setSize = 2;//check 16
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Run without using yield()");
                System.out.println("=========================");
                runSet(setSize,false);
                System.out.println("Run with using yield()");
                System.out.println("========================");
                runSet(setSize,true);
            }
        };
        Thread thread = new Thread(runnable,"Priority compete");
        thread.setPriority(Thread.MAX_PRIORITY-1);
        thread.start();
    }
}
