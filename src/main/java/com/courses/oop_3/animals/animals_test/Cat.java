package com.courses.oop_3.animals.animals_test;

/**
 * Created by Vovka on 24.11.2015.
 */
public class Cat extends Domestic {
    public Cat(int id, int age, double weight, String color, String name, boolean isVactinated) {
        super(id, age, weight, color, name, isVactinated);
    }

    public String getVoice() {
        return "Meow";
    }
}
