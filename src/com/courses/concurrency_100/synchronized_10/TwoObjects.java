package com.courses.concurrency_100.synchronized_10;

public class TwoObjects {
    private String id;

    public TwoObjects(String id) {
        this.id = id;
    }

    public synchronized void doStuff(int val) {
        print("entering doStuff()");
        int num = val*2 + id.length();
        print("in doStuff() - local variable num ="+num);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("in doStuff() - local variable num ="+num);
        print("leaving doStuff()");
    }

    private void print(String message) {
        threadPrint("id=" + id + "-" + message);
    }

    private static void threadPrint(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + message);
    }
    //third iteration
    public static void main(String[] args) throws InterruptedException {
        TwoObjects obj1 = new TwoObjects("obj1");
        TwoObjects obj2 = new TwoObjects("obj2");
        Runnable runnableA = () -> obj1.doStuff(3);
        Runnable runnableB = () -> obj2.doStuff(7);
        Thread threadA = new Thread(runnableA,"threadA");
        Thread threadB = new Thread(runnableB,"threadB");

        threadA.start();
        Thread.sleep(200);
        threadB.start();
    }
}
