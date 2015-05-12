package com.courses.concurrency_100.threads_and_executors_1.scheduled_executors_7;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by VSulevskiy on 08.05.2015.
 */
public class ScheduledExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = new SimpleRunnable();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        ScheduledFuture future = executor.schedule(task,3, TimeUnit.SECONDS);
        TimeUnit.MILLISECONDS.sleep(1211);
        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining delay: %sms \n", remainingDelay);

        Runnable periodicTask = new SimpleRunnable();
        int initialDelay = 0;
        int period = 1;
        executor.scheduleAtFixedRate(periodicTask,initialDelay,period,TimeUnit.SECONDS);
    }

    public static class SimpleRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("Scheduling: " + new Date());
        }
    }

}
