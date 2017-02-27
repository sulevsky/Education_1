package com.courses.oop_3.oop_1;

public class Teacher {
    private int id;
    private String surname;
    private double salary;

    public Teacher(int id, String surname, double salary) {
        this.id = id;
        this.surname = surname;
        this.salary = salary;
    }

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
