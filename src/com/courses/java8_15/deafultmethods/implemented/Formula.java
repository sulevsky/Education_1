package com.courses.java8_15.deafultmethods.implemented;

/**
 * Created by VSulevskiy on 09.10.2015.
 */
public interface Formula {
    double calculate(int a);
    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
