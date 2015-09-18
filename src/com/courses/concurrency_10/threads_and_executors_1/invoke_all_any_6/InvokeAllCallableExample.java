package com.courses.concurrency_10.threads_and_executors_1.invoke_all_any_6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by VSulevskiy on 08.05.2015.
 */
public class InvokeAllCallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> callables = new ArrayList<Callable<String>>();
        callables.add(new StringReturnTask("task1"));
        callables.add(new StringReturnTask("task2"));
        callables.add(new StringReturnTask("task3"));
        List<Future<String>> futures = executor.invokeAll(callables);
        for (Future future : futures) {
            System.out.println(future.get());
        }
    }

    private static class StringReturnTask implements Callable<String> {
        private String name;

        public StringReturnTask(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            return name;
        }
    }
}
