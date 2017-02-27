package com.courses.oop_3.oop_1;

public class Student extends Person{
    public int[] marks;

    public Student(int id, String surname) {
        super(id, surname);
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }
    public String getSurname(){
        return super.getSurname();
    }


}
