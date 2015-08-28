package com.courses.concurrency_100.accidentialcorruption_11;

import com.courses.concurrency_100.threads_and_executors_1.scheduled_executors_7.ScheduledExecutorExample;

/**
 * Created by VSulevskiy on 26.08.2015.
 */
public class CorruptWrite {
    private String firstName;
    private String lastName;
    public void setNames(String fName, String lName){
        print("Entering set names");
        this.firstName = fName;
        //A thread might be swapped here. This block exaggerate this.
        if(fName.length()<5){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.lastName = lName;

        print("leaving setNames() " + lastName + ", " + firstName);
    }

    private void print(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + message);
    }

    public static void main(String[] args) {
        CorruptWrite cw = new CorruptWrite();


        Runnable runnableFirst = new Runnable() {
            @Override
            public void run() {
                cw.setNames("George", "Washington");
            }
        };

        Runnable runnableSecond = new Runnable() {
            @Override
            public void run() {
                cw.setNames("Abe", "Lincoln");
            }
        };
        Thread threadGeorge = new Thread(runnableFirst);
        Thread threadAbe = new Thread(runnableSecond);

        threadGeorge.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadAbe.start();
    }
}
