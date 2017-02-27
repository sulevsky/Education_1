package com.courses.oop_3.animals;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class Lion extends Wild implements Roarable {
    public Lion() {
    }

    public Lion(int id, int age, double weight, String color, boolean isPredator) {

        super(id, age, weight, color, isPredator);
    }

    @Override
    public void roar() {
        System.out.println("Lion ROAR");
    }
}
