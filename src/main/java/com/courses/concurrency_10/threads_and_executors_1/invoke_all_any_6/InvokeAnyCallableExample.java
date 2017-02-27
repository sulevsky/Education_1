package com.courses.concurrency_10.threads_and_executors_1.invoke_all_any_6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by VSulevskiy on 08.05.2015.
 */
public class InvokeAnyCallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> callables = new ArrayList<Callable<String>>();
        callables.add(new TimeOutReturnTask("task1",2));
        callables.add(new TimeOutReturnTask("task2",3));
        callables.add(new TimeOutReturnTask("task3",1));
        String result = executor.invokeAny(callables);
        System.out.println(result);
    }

    private static class TimeOutReturnTask implements Callable<String> {
        private int timeout;
        private String name;

        public TimeOutReturnTask(String name, int timeout) {
            this.name = name;
            this.timeout = timeout;
        }

        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(timeout);
            return name + " " + timeout;
        }
    }
}
