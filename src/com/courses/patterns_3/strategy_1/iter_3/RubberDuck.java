package com.courses.patterns_3.strategy_1.iter_3;

/**
 * Created by VSulevskiy on 07.05.2015.
 */
public class RubberDuck extends Duck {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
    @Override
    public void display() {
        System.out.println("I'm a rubber duck");
    }
}
