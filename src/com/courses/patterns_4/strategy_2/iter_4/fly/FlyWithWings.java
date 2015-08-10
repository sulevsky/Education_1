package com.courses.patterns_4.strategy_2.iter_4.fly;

/**
 * Created by VSulevskiy on 07.05.2015.
 */
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
