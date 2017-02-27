package com.courses.concurrency_10.sychronization_locks_1.semaphore_2;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vladimir on 12.05.2015.
 */
public class LongRunningTask implements Callable<Boolean> {
    Semaphore semaphore;
    public LongRunningTask(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    @Override
    public Boolean call() {
        boolean permit = false;
        try{
            permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
            if(permit){
                System.out.println("Semaphore acquired");
                TimeUnit.SECONDS.sleep(5);
            }
            else{
                System.out.println("Could not acquire semaphore");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            throw new IllegalStateException(e);
        }finally{
            if(permit){
                semaphore.release();
            }
        }
        return permit;

    }
}
