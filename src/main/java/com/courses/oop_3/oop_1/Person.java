package com.courses.oop_3.oop_1;

/**
 * Created by Vovka on 20.11.2015.
 */
public class Person {
    private int id;
    private String surname;



    public Person(int id, String surname) {
        this.id = id;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
