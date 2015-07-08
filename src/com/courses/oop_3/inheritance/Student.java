package com.courses.oop_3.inheritance;


public class Student extends Person{
    public Student(int id, String sur, int[] marks) {
        super();
        this.marks = marks;
        System.out.println(
                super.hashCode());
    }
    public void print(){
        System.out.println("Hello I am student");
    }

    private int[] marks = new int[34];

    public int[] getMarks() {
        System.out.println(this.id);
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }
}
