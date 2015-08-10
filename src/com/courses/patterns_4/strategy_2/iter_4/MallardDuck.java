package com.courses.patterns_4.strategy_2.iter_4;

import com.courses.patterns_4.strategy_2.iter_4.fly.FlyWithWings;
import com.courses.patterns_4.strategy_2.iter_4.quack.Quack;

/**
 * Created by VSulevskiy on 07.05.2015.
 */
public class MallardDuck extends Duck {
    public MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a mallard duck");
    }
}
