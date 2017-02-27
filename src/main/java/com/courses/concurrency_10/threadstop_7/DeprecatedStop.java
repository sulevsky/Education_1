package com.courses.concurrency_10.threadstop_7;

/**
 * Created by VSulevskiy on 20.07.2015.
 */
public class DeprecatedStop implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (true){
            System.out.println("Running... count= "+count);
            count++;
            try{
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        DeprecatedStop target = new DeprecatedStop();
        Thread thread = new Thread(target);
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
