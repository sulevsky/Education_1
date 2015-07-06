package com.courses.patterns_4.strategy_1.iter_4;

import com.courses.patterns_4.strategy_1.iter_4.fly.FlyBehavior;
import com.courses.patterns_4.strategy_1.iter_4.quack.QuackBehavior;

/**
 * Created by VSulevskiy on 07.05.2015.
 */
public class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){

    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("Swim");
    }
    public void display(){
        System.out.println("I'm a usual duck");
    }
    public void performFly() {
        flyBehavior.fly();
    }

}
