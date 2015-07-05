package com.courses.patterns_4.strategy_1.iter_1;

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

        mallard.display();
        redHead.display();
    }




}
