package com.courses.oop_3.animals;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class Dog extends Domestic implements Roarable {
    public Dog(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    public Dog() {
    }

    public String phrase(){
        String result = super.phrase();
        result += " Woof!";
        return result;
    }

    @Override
    public void roar() {
        AnimalUtils.standardRoar();
    }

}
