package com.courses.oop_3.animals;

import java.util.ArrayList;
import java.util.List;

import com.courses.oop_3.animals.observable.Observable;
import com.courses.oop_3.animals.observable.Observer;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class Giraffe extends Wild implements Observable {
    public Giraffe(int id, int age, double weight, String color, boolean isPredator) {
        super(id, age, weight, color, isPredator);
    }

    public Giraffe() {
    }

    public String toString() {
        String result = "";
        result += "Id: " + getId();
        result += " Age: " + getAge();
        result += " IsPredator: " + isPredator();
        return result;
    }

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void sick() {
        super.sick();
        System.out.println("I am sick - " + isSick());
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handle(this);
        }
    }
}
