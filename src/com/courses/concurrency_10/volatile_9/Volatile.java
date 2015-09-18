package com.courses.concurrency_10.volatile_9;

/**
 * Created by VSulevskiy on 06.08.2015.
 */
public class Volatile implements Runnable {
    private int value;
    private volatile boolean missedIt;
    private long creationTime;

    public Volatile() {
        value = 10;
        missedIt = false;
        creationTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        print("entering run");
        //each time check to see if 'value' is different
        while (value < 20) {
            //used to break out the loop if change to value is missed
            if (missedIt) {
                int currentValue = value;

                //Simply execute a synchronized statement on arbitrary object to see the effect
                Object lock = new Object();
                synchronized (lock) {
                    //do nothing
                }
                int valueAfterSync = value;
                print("in run() - see value=" + currentValue + ", but rumor has it that it changed!");
                print("in run() - valueAfterSync=" + valueAfterSync);

                break;
            }

        }
        print("leaving run()");
    }

    public void workMethod() throws InterruptedException {
        print("entering workMethod()");
        print("in workMethod() - about to sleep for 2 seconds");
        Thread.sleep(2000);
        value = 50;

        print("in workMethod() - just set value=" + value);
        print("in workMethod() - is about to sleep for 5 seconds");
        Thread.sleep(5000);

        missedIt = true;
        print("in workMethod() - just set missedIt=" + missedIt);
        print("in workMethod() - is about to sleep for 3 seconds");
        Thread.sleep(3000);

        print("leaving workMethod()");
    }

    private  void print(String message) {
        long interval = System.currentTimeMillis() - creationTime;
        String tempString = "    " + (interval / 1000.0) + "000";
        int pos = tempString.indexOf(".");
        String secondString = tempString.substring(pos - 2, pos + 4);

        String nameString = "    " + Thread.currentThread().getName();
        nameString = nameString.substring(nameString.length() - 8, nameString.length());

        System.out.println(secondString + " " + nameString + ":" + message);
    }

    public static synchronized void main(String[] args) throws InterruptedException {
        Volatile aVolatile = new Volatile();
        Thread.sleep(100);

        Thread thread = new Thread(aVolatile);
        thread.start();

        Thread.sleep(1000);
        aVolatile.workMethod();

    }
}
