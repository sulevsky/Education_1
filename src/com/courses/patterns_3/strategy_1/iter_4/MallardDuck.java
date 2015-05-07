package com.courses.patterns_3.strategy_1.iter_4;

import com.courses.patterns_3.strategy_1.iter_4.fly.FlyBehavior;
import com.courses.patterns_3.strategy_1.iter_4.fly.FlyWithWings;
import com.courses.patterns_3.strategy_1.iter_4.quack.Quack;
import com.courses.patterns_3.strategy_1.iter_4.quack.QuackBehavior;

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
