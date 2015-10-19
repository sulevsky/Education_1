package com.courses.java8_15.deafultmethods.implemented;

/**
 * Created by VSulevskiy on 09.10.2015.
 */
public class App {
    public static void main(String[] args) {
//        System.out.println(calculator((a)->10, 100));

    }
    public static double calculator(Formula formula, int value){

        return formula.calculate(value);
    }
}
