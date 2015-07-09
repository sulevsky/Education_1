package com.courses.concurrency_100.thread_creating_1;

/**
 * Created by VSulevskiy on 08.07.2015.
 */
public class App {
    public static void main(String[] args) {
        //single threaded
        Thread thread = new MyThread();
        thread.run();
        printTenNumbersWithDelay();

        //multi threaded
        System.out.println("\n Another try\n");
        thread.start();
        printTenNumbersWithDelay();
    }

    public static void printTenNumbersWithDelay(){
        for (int i=0;i<10;i++) {
            System.out.println("Main thread "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
