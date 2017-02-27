package com.courses.oop_3.animals.animals_test;

public class App {
    public static void main(String[] args) {
        Animal murka = new Cat(1,3,2.4,"Grey","Murka",true);


        Animal barsik = new Cat(2,5,3.0,"Ginger", "Barsik", true);
Animal tuzik = new Dog(2,5,3.0,"Ginger", "Tuzik", true);


        Zoo zoo = new Zoo();
//        zoo.addAnimal(murka);
//        zoo.addAnimal(barsik);
//        zoo.addAnimal(tuzik);

        murka = barsik;
//        zoo.voiceAll();
        System.out.println(murka.getVoice());
        System.out.println(barsik.getVoice());
        System.out.println(tuzik.getVoice());
    }
}
