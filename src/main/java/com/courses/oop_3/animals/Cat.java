package com.courses.oop_3.animals;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class Cat extends Domestic {
//    int id=1000;
    public Cat(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    @Override
    public String phrase() {
        String result = super.phrase();
        for (int i = 0; i < 10; i++) {
            result += " Meow!";
        }
        return result;
    }
}
