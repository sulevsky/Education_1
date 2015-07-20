package com.courses.concurrency_100.suspenderror_6;

/**
 * Created by VSulevskiy on 20.07.2015.
 */
public class AlternativeSuspendResume implements Runnable{
    private volatile int firstValue;
    private volatile int secondValue;
    private volatile boolean suspended;

    public boolean areValuesEqual(){
        return firstValue == secondValue;
    }

    @Override
    public void run() {
        try {
            suspended = false;
            firstValue = 0;
            secondValue = 0;
            workMethod();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void workMethod() throws InterruptedException {
        int val = 1;
        while (true){
            waitWhileSuspended();
            stepOne(val);
            stepTwo(val);
            val++;
            waitWhileSuspended();
            Thread.sleep(200);
        }
    }

    private void stepOne(int val) throws InterruptedException {
        firstValue = val;
        Thread.sleep(200);
    }
    private void stepTwo(int val) {
        secondValue = val;
    }

    public void suspendRequest(){
        suspended = true;
    }
    public void resumeRequest(){
        suspended = false;
    }
    private void waitWhileSuspended() throws InterruptedException {
        //busy wait has to be replaced by wait/notify
        while(suspended){
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) {
        AlternativeSuspendResume alternativeSuspendResume = new AlternativeSuspendResume();
        Thread thread  = new Thread(alternativeSuspendResume);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <10; i++) {
            alternativeSuspendResume.suspendRequest();
            try {
                //give time to notice suspencion request
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("are values equal " + alternativeSuspendResume.areValuesEqual());

            alternativeSuspendResume.resumeRequest();
            try {
                Thread.sleep((long)(Math.random()*2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}
