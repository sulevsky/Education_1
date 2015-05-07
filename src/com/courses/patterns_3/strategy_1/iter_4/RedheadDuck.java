package com.courses.patterns_3.strategy_1.iter_4;

import com.courses.patterns_3.strategy_1.iter_4.fly.FlyWithWings;
import com.courses.patterns_3.strategy_1.iter_4.quack.Quack;

/**
 * Created by VSulevskiy on 07.05.2015.
 */
public class RedheadDuck extends Duck {
    public RedheadDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    @Override
    public void display() {
        System.out.println("I'm a redhead duck");
    }
}
