package com.courses.concurrency_10.atomic_13;

/**
 * Created by VSulevskiy on 04.09.2015.
 */
public class AtomicApp {

    public static void main(String[] args) {
        Incrementor incrementor = new Incrementor();

        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000_000; i++) {
                    incrementor.increment();
                }
            }
        };
        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000_000; i++) {
                    incrementor.increment();
                }
            }
        };
        Runnable runnableC = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000_000; i++) {
                    incrementor.increment();
                }
            }
        };
        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);
        Thread threadC = new Thread(runnableC);
        threadA.start();
        threadB.start();
        threadC.start();
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        incrementor.printResult();


    }

}
