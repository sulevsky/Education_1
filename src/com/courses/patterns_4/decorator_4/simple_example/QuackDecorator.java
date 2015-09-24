package com.courses.patterns_4.decorator_4.simple_example;

/**
 * Created by Vovka on 18.09.2015.
 */
public class QuackDecorator implements Quackable{
    private static int num = 0;
    private Quackable quackable;
    public QuackDecorator(Quackable quackable){
        this.quackable = quackable;
    }

    public void quack() {
        num++;
        quackable.quack();
    }
    public static int getNum(){
        return num;
    }
}
