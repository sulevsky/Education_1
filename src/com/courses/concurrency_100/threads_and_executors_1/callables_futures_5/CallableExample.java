package com.courses.concurrency_100.threads_and_executors_1.callables_futures_5;

import java.util.concurrent.*;

/**
 * Created by VSulevskiy on 08.05.2015.
 */
public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer> future = executor.submit(new CallableExampleTask());
        System.out.println("is future done? " + future.isDone());
        Integer result = future.get();
//        Integer result = future.get(1,TimeUnit.SECONDS);
        System.out.println("is future done? " + future.isDone());
        System.out.println("result: " + result);
    }
}
