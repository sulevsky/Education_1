package com.courses.concurrency_10.suspenderror_6;

/**
 * Class created to show possible inconsistent state caused by usage of suspend() resume()
 */
public class DeprecatedSuspendResume implements Runnable{
    private volatile int firstVal;
    private volatile int secondVal;
    public boolean areValuesEqual(){
        return firstVal == secondVal;
    }
    @Override
    public void run() {
        try {
            firstVal=0;
            secondVal=0;
            workMethod();
        }catch(InterruptedException e){
            System.out.println("interrupted in a work method");
        }

    }

    private void workMethod() throws InterruptedException {
        int val = 1;
        while (true){
            stepOne(val);
            stepTwo(val);
            val++;
            Thread.sleep(200);
        }
    }

    private void stepTwo(int val) {
        secondVal = val;
    }

    private void stepOne(int val) throws InterruptedException{
        firstVal= val;
        Thread.sleep(300);
    }

    public static void main(String[] args) {
        DeprecatedSuspendResume deprecatedSuspendResume = new DeprecatedSuspendResume();
        Thread thread = new Thread(deprecatedSuspendResume);
        thread.start();

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        for (int i = 0; i <10; i++) {
            thread.suspend();
            System.out.println("are values equal = " + deprecatedSuspendResume.areValuesEqual());
            thread.resume();
            try{
                Thread.sleep((long)(Math.random()*2000.0));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}
