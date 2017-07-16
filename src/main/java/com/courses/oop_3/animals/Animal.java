package com.courses.oop_3.animals;

import com.courses.oop_3.animals.observable.Observable;

public  class Animal  {
    public int id;

    private int age;

    private double weight;

    private String color;

    public boolean isSick() {
        return isSick;
    }


    public void sick() {
        isSick = true;
    }
    public void healed() {
        isSick = false;
    }

    private boolean isSick;

    public Animal(int id, int age, double weight, String color) {
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Animal() {
    }

    public void say() {
        System.out.println(phrase());
    }

    public String phrase() {
        return "Hello ";
    }

    //    public abstract void move();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Animal{" +
               "age=" + age +
               ", id=" + id +
               '}';
    }

    //    @Override
    //    public int compareTo(Object o) {
    //        Animal thatObject = (Animal)o;
    //        if(this.age<thatObject.age) return -1;
    //        else if(this.age>thatObject.age) return 1;
    //        else return 0;
    //    }
}
