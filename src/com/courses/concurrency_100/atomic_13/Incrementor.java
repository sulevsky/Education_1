package com.courses.concurrency_100.atomic_13;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by VSulevskiy on 04.09.2015.
 */
public class Incrementor {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

//    public synchronized void increment(){
//        count  = count+1;
//    }

//    public void increment(){
//        int localCount = count;
//        localCount = localCount+1;
//        count = localCount;
//    }

    public  void increment(){
        atomicInteger.incrementAndGet();
    }

    public void printResult() {
        System.out.println("count is " + atomicInteger.get());
    }
}
