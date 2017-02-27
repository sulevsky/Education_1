package com.courses.java8_15.deafultmethods.implemented;

/**
 * Created by VSulevskiy on 09.10.2015.
 */
public class HundredMultiplicator implements  SecondFormula {

    @Override
    public double calculate(int a) {
        return a * 100;
    }

    @Override
    public double sqrt(int a) {
        return 0;
    }
}
