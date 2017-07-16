package com.courses.oop_3.animals;

import java.util.List;

import com.courses.oop_3.animals.observers.Doctor;

public class App {
    public static Giraffe giraffe;

    public static Zoo init() {
        Zoo zoo = new Zoo();

        Cat cat = new Cat(1, 3, 3.4, "Grey", "Murka", true);
        zoo.add(cat);
        Lion lion = new Lion(2, 10, 90, "Yellow", true);
        zoo.add(lion);
        Dog dog = new Dog(3, 7, 16, "Black", "Tuzik", true);
        zoo.add(dog);
        Fish fish = new Fish(4, 3, 0.2, "Gold", "Karas'", false);
        zoo.add(fish);
        GuideDog cleverDog = new GuideDog(5, 10, 10, "White", "Sharik", true, true);
        zoo.add(cleverDog);
        GuideDog notCleverDog = new GuideDog(6, 1, 3, "Grey", "Muhtar", true, false);
        zoo.add(notCleverDog);
        giraffe = new Giraffe(7, 33, 36, "Spot", false);
        zoo.add(giraffe);
        return zoo;
    }

    public static void main(String[] args) {
        Zoo zoo = init();
        Doctor doctor = new Doctor();

        giraffe.addObserver(doctor);










        giraffe.sick();

        System.out.println(giraffe.isSick());



        ///

        //        System.out.println(zoo.getAllSickAnimals());
        //        System.out.println(giraffe.isSick);
    }
}
