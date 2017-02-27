package com.courses.java8_15.deafultmethods;

/**
 * Created by VSulevskiy on 09.10.2015.
 */
public class HundredMultiplicator implements Formula {

    @Override
    public double calculate(int a) {
        return a * 100;
    }
}
