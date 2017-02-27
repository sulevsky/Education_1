package com.courses.swing_6.basics.seventool;

/**
 * Created by VSulevskiy on 16.07.2015.
 */
public class Person {
    public String surname;
    public String name;
    public int age;

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String surname, String name, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }
}
