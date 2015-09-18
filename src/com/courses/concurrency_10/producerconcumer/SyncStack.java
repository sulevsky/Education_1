package com.courses.concurrency_10.producerconcumer;

import java.util.Vector;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class SyncStack {
    private Vector buffer = new Vector(400, 200);

    public synchronized void push(char c) {
        buffer.addElement(c);
        this.notify();
        //TODO doesn't wait if produced too much
    }

    public synchronized char pop() {
        while (buffer.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return (char) (buffer.remove(buffer.size() - 1));
    }
}
