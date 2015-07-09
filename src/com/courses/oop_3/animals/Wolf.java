package com.courses.oop_3.animals;

import com.courses.oop_3.animals.Wild;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class Wolf extends Wild {
    public Wolf(int id, int age, double weight, String color, boolean isPredator) {
        super(id, age, weight, color, isPredator);
    }

    public Wolf() {
    }
}
