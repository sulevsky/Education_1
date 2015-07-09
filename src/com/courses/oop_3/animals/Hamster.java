package com.courses.oop_3.animals;

import com.courses.oop_3.animals.Domestic;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class Hamster extends Domestic {
    public Hamster(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    public Hamster() {
    }
}
