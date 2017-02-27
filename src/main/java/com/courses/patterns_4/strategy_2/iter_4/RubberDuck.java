package com.courses.patterns_4.strategy_2.iter_4;

import com.courses.patterns_4.strategy_2.iter_4.fly.FlyNoWay;
import com.courses.patterns_4.strategy_2.iter_4.quack.Squeak;

/**
 * Created by VSulevskiy on 07.05.2015.
 */
public class RubberDuck extends Duck {
    public RubberDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }
    @Override
    public void display() {
        System.out.println("I'm a rubber duck");
    }
}
