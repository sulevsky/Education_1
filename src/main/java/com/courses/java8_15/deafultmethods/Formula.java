package com.courses.java8_15.deafultmethods;

/**
 * Created by VSulevskiy on 09.10.2015.
 */
@FunctionalInterface
public interface Formula {
    double calculate(int a);
    default double sqrt(int a){
        return 0.0;
    }
}
