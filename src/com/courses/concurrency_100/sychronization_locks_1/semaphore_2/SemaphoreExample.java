package com.courses.concurrency_100.sychronization_locks_1.semaphore_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Vladimir on 12.05.2015.
 */
public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(5);
        List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
        for(int i = 0;i<15;i++){
            tasks.add(new LongRunningTask(semaphore));
        }
        executor.invokeAll(tasks);
    }



}
