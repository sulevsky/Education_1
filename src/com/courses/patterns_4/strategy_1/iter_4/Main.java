package com.courses.patterns_4.strategy_1.iter_4;

import com.courses.patterns_4.strategy_1.iter_4.fly.FlyNoWay;

/**
 * Created by VSulevskiy on 07.05.2015.
 */
public class Main {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        Duck redHead = new RedheadDuck();
        Duck rubber = new RubberDuck();
        mallard.swim();
        redHead.swim();
        rubber.swim();
        int mallardAge = 5;
        if(mallardAge > 3){

            mallard.setFlyBehavior(new FlyNoWay());
        }
        mallard.performQuack();
        redHead.performQuack();
        rubber.performQuack();


        mallard.performFly();
        redHead.performFly();
        rubber.performFly();

        mallard.display();
        redHead.display();
        rubber.display();
    }




}
