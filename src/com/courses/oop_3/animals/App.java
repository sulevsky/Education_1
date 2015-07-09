package com.courses.oop_3.animals;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class App {
    public static void main(String[] args) {
        Cat cat = new Cat(1,3,3.4,"Grey","Murka",true);
        Lion lion = new Lion(2,10,90,"Yellow",true);
        Dog dog = new Dog(3,7,16,"Black","Tuzik",true);
        Fish fish = new Fish(4,3,0.2,"Gold","Karas'",false);
        GuideDog cleverDog = new GuideDog(5,10,10,"White","Sharik",true,true);
        GuideDog notCleverDog = new GuideDog(6,1,3,"Grey","Muhtar",true,false);

        cat.say();
        lion.say();
        dog.say();
        fish.say();
        cleverDog.say();
        notCleverDog.say();

    }
}
