package com.courses.oop_3.animals.animals_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vovka on 24.11.2015.
 */
public class Zoo {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Cat animal) {
        animals.add(animal);
    }
    public void voiceAll(){
        for (Animal animal : animals){
            System.out.println(animal.getVoice());
        }
    }
}
