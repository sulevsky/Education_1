package com.courses.oop_3.animals.observers;

import com.courses.oop_3.animals.Giraffe;
import com.courses.oop_3.animals.observable.Observer;

public class Doctor implements Observer{
    @Override
    public void handle(Object object) {
        Giraffe giraffe = (Giraffe) object;
        giraffe.healed();

        System.out.println("You are healed");
    }
}
