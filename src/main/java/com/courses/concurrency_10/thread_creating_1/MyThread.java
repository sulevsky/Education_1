package com.courses.concurrency_10.thread_creating_1;

/**
 * Created by VSulevskiy on 08.07.2015.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("User thread " + i );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
