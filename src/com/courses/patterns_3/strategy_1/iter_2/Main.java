package com.courses.patterns_3.strategy_1.iter_2;

/**
 * Created by VSulevskiy on 07.05.2015.
 */
public class Main {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        Duck redHead = new RedheadDuck();
        mallard.swim();
        redHead.swim();

        mallard.quack();
        redHead.quack();

        mallard.fly();
        redHead.fly();

        mallard.display();
        redHead.display();
    }




}
