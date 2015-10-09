package com.courses.java8_15.fuctionalinterface.newkeyword;

/**
 * Created by VSulevskiy on 09.10.2015.
 */
public class App {
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Ivan","Ivanov");
        System.out.println(person);
    }
}
