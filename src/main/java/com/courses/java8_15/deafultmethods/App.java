package com.courses.java8_15.deafultmethods;

/**
 * Created by VSulevskiy on 09.10.2015.
 */
public class App {
    public static void main(String[] args) {
        Formula formula = new HundredMultiplicator();

        System.out.println(calculator(formula, 100));
    }
    public static double calculator(Formula formula, int value){

        return formula.calculate(value);
    }
}
