package com.courses.oop_3.animals;

import com.courses.oop_3.animals.observable.Observer;
import com.courses.oop_3.animals.observers.HungryObserver;
import com.courses.oop_3.animals.observers.SicknessObserver;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by VSulevskiy on 09.07.2015.
 */
public class App {
    public static Giraffe giraffe;
    public static List init() {
        List zoo = new ArrayList();

        Cat cat = new Cat(1,3,3.4,"Grey","Murka",true);
        zoo.add(cat);
        Lion lion = new Lion(2,10,90,"Yellow",true);
        zoo.add(lion);
        Dog dog = new Dog(3,7,16,"Black","Tuzik",true);
        zoo.add(dog);
        Fish fish = new Fish(4,3,0.2,"Gold","Karas'",false);
        zoo.add(fish);
        GuideDog cleverDog = new GuideDog(5,10,10,"White","Sharik",true,true);
        zoo.add(cleverDog);
        GuideDog notCleverDog = new GuideDog(6,1,3,"Grey","Muhtar",true,false);
        zoo.add(notCleverDog);
        giraffe = new Giraffe(7,33,36,"Spot",false);
        zoo.add(giraffe);
        return zoo;

    }

    public static void main(String[] args) {
        Observer doctor = new SicknessObserver();
        Observer feeder = new HungryObserver();

        Hamster hamster = new Hamster();
        Fish fish = new Fish();

        hamster.addObserver(doctor);
        hamster.addObserver(feeder);

        fish.addObserver(feeder);


        hamster.notifyObservers();

        fish.notifyObservers();



    }






    private static void printStatus(List zoo) {
        if(isAnybodyHungry(zoo)){
            System.out.println("Go and  feed him");
        }
        else{
            System.out.println("Free time");
        }
    }

    public static boolean isAnybodyHungry(List zoo){

        return false;
    }

}
