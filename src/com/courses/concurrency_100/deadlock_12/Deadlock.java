package com.courses.concurrency_100.deadlock_12;

/**
 * Created by VSulevskiy on 01.09.2015.
 */
public class Deadlock {
    private String id;
    public Deadlock(String id){
        this.id = id;
    }

    public synchronized void checkOther(Deadlock other){
        print("entering checkOther()");

        //simulate some lengthy process
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("in checkOther() - about to invoke other action");
        other.action();
        print("leaving checkOther()");
    }

    private synchronized void action() {
        print("entering action()");
        //simulate some lengthy process
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("leaving action()");
    }

    private static void print(String s) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + s);
    }

    public static void main(String[] args) {
        Deadlock deadlock1 = new Deadlock("first object");
        Deadlock deadlock2 = new Deadlock("second object");

        Runnable runA =new Runnable() {
            @Override
            public void run() {
                deadlock1.checkOther(deadlock2);
            }
        };
        Thread threadA = new Thread(runA,"thread a");
        threadA.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Runnable runB = new Runnable() {
            @Override
            public void run() {
                deadlock2.checkOther(deadlock1);
            }
        };

        Thread threadB = new Thread(runB,"thread b");
        threadB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        print("finished sleeping");
        print("about to interrupt thread A");
        threadA.interrupt();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        print("about to interrupt thread B");
        threadB.interrupt();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        print("did that break the deadlock?");

//        System.exit(-1);

    }

}
