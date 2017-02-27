package com.courses.java8_15.deafultmethods.implemented;

/**
 * Created by Vovka on 09.10.2015.
 */
public interface SecondFormula {
    double calculate(int a);
    default double sqrt(int a){
        return a;
    }

}
