package com.courses.patterns_4.objectpool_6;

import java.util.concurrent.TimeUnit;

/**
 * Created by VSulevskiy on 04.09.2015.
 */
public class ExpensiveObject {
    private String name;
    public ExpensiveObject(String name){
        this.name = name;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ExpensiveObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
