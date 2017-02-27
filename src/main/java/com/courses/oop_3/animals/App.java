package com.courses.oop_3.animals;


public class App {
    public static Giraffe giraffe;
    public static Zoo init() {
        Zoo zoo = new Zoo();

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
//        Zoo zoo = init();
//        System.out.println(zoo.remove(2));
//        addGirafe(zoo);
//        System.out.println(zoo.get(6));
//        System.out.println(sum(5,5));



    }








}
