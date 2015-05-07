package com.courses.patterns_3.strategy_1.iter_3;

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

        mallard.quack();
        redHead.quack();
        rubber.quack();

        mallard.fly();
        redHead.fly();
        rubber.fly();//flies but should not

        mallard.display();
        redHead.display();
        rubber.display();
    }




}
