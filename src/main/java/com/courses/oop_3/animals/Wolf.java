package com.courses.oop_3.animals;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class Wolf extends Wild implements Roarable{
    public Wolf(int id, int age, double weight, String color, boolean isPredator) {
        super(id, age, weight, color, isPredator);
    }

    public Wolf() {
    }

    @Override
    public void roar() {
        System.out.println("Wof ROAD");
    }
}
