package com.courses.oop_3.animals;

import java.util.ArrayList;

/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class App {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[7];
        Cat cat = new Cat(1,3,3.4,"Grey","Murka",true);
        zoo[0]=cat;
        Lion lion = new Lion(2,10,90,"Yellow",true);
        zoo[1]=lion;
        Dog dog = new Dog(3,7,16,"Black","Tuzik",true);
        zoo[2]=dog;
        Fish fish = new Fish(4,3,0.2,"Gold","Karas'",false);
        zoo[3]=fish;
        GuideDog cleverDog = new GuideDog(5,10,10,"White","Sharik",true,true);
        zoo[4]=cleverDog;
        GuideDog notCleverDog = new GuideDog(6,1,3,"Grey","Muhtar",true,false);
        zoo[5]=notCleverDog;
        Giraffe giraffe = new Giraffe(7,33,36,"Spot",false);
        zoo[6]=giraffe;


        System.out.println(cat.id);


    }
}
