package com.courses.oop_3.animals;

import com.courses.oop_3.animals.Wild;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class Lion extends Wild {
    public Lion() {
    }

    public Lion(int id, int age, double weight, String color, boolean isPredator) {

        super(id, age, weight, color, isPredator);
    }
}
