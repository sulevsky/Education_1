package com.courses.patterns_4.objectpool_6;

/**
 * Created by VSulevskiy on 04.09.2015.
 */
public class App {
    public static void main(String[] args) {
        ExpensiveObjectPool pool = new ExpensiveObjectPool();

        ExpensiveObject object1 = pool.checkOut();
        ExpensiveObject object2 = pool.checkOut();
        ExpensiveObject object3 = pool.checkOut();
        ExpensiveObject object4 = pool.checkOut();

        pool.checkIn(object3);
        pool.checkIn(object2);

        ExpensiveObject object5 = pool.checkOut();
        ExpensiveObject object6 = pool.checkOut();


    }
}
