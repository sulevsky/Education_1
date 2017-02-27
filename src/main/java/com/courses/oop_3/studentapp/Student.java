package com.courses.oop_3.studentapp;

 class Student {
    private String name;
    private String surname;
     int[] marks;

    public Student() {
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        marks = new int[10];
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

     public String getSurname() {
         return surname;
     }

     public void setSurname(String surname) {
         this.surname = surname;
     }

     public void printInfo() {
        System.out.println("My name is " + name + ", surname " + surname);
    }
}
