package com.courses.patterns_4.strategy_1.iter_4.fly;

/**
 * Created by VSulevskiy on 07.05.2015.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        //do nothing or
        System.out.println("I can't fly");
    }
}
