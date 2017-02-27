package com.courses.oop_3.animals.animals_test;

public class Dog extends Domestic {
    public Dog(int id, int age, double weight, String color, String name, boolean isVactinated) {
        super(id, age, weight, color, name, isVactinated);
    }

    public String getVoice() {
        return "Woof";
    }
}
