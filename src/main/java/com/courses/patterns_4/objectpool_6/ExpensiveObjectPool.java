package com.courses.patterns_4.objectpool_6;

/**
 * Created by VSulevskiy on 04.09.2015.
 */
public class ExpensiveObjectPool extends ObjectPool<ExpensiveObject>{
    private static int id;
    @Override
    protected ExpensiveObject create() {
        id++;
        System.out.println("Object: " + id + " created");
        return new ExpensiveObject(""+id);
    }
}
