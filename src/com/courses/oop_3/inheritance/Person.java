package com.courses.oop_3.inheritance;

/**
 * Created by Vladimir Sulevskiy on 07.07.2015.
 */
public class Person  {
    public Person(int id, String surname) {
        this.id = id;
        this.surname = surname;
        System.out.println("constr 1");
    }
    public Person`(){
        this(100);
    }
    public Person(int id) {
        this.id = id;
        this.surname = "Ivanov";
        System.out.println("constr 2");
    }
    protected int id;
    private String surname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    public void print(){
//        System.out.println("Hello I am person");
//    }
}
