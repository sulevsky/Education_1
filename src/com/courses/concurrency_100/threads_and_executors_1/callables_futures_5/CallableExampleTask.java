package com.courses.concurrency_100.threads_and_executors_1.callables_futures_5;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by VSulevskiy on 08.05.2015.
 */
public class CallableExampleTask implements Callable<Integer>{
    @Override
    public Integer call() {
        try {
            TimeUnit.SECONDS.sleep(10);
//            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 42;
    }
}
