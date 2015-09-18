package com.courses.concurrency_10.synchronized_10;

public class BothInMethod {
    private String id;

    public BothInMethod(String id) {
        this.id = id;
    }

    public void doStuff(int val) {
        //next iteration add synchronized block
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
    //first iteration
    public static void main(String[] args) throws InterruptedException {
        BothInMethod bothInMethod = new BothInMethod("obj1");
        Runnable runnableA = () -> bothInMethod.doStuff(3);
        Runnable runnableB = () -> bothInMethod.doStuff(7);
        Thread threadA = new Thread(runnableA,"threadA");
        Thread threadB = new Thread(runnableB,"threadB");

        threadA.start();
        Thread.sleep(200);
        threadB.start();
    }

    //second iteration
    //same, but add synchronized block

}
