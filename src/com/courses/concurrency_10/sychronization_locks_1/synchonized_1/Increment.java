package com.courses.concurrency_10.sychronization_locks_1.synchonized_1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Vladimir on 12.05.2015.
 */
public class Increment {
    public int count = 0;
    public void increment(){
        count++;
//        count = count + 1;
    }
    public synchronized void incrementSynchronized(){
        count = count + 1;
    }
    public void incrementSynchronizedBlock(){
        //some operations
        synchronized(this) {
            count = count + 1;
        }
        //some operations
    }
    public void incrementLock(){
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            count = count + 1;
        }
        finally {
            lock.unlock();
        }
    }
}
