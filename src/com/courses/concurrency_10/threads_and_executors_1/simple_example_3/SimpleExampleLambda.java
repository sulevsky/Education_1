package com.courses.concurrency_10.threads_and_executors_1.simple_example_3;

/**
 * Created by VSulevskiy on 08.05.2015.
 */
public class SimpleExampleLambda {
    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("Done!");
    }


}
