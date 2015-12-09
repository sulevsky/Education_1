package com.courses.oop_3.oop_1;

public class Group {

    private Student[] students = new Student[0];

    public void add(Student student) {
        Student[] newArray = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newArray[i] = students[i];
        }
        newArray[students.length] = student;
        students = newArray;
    }

    public int getStudentsNum() {
        return students.length;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < students.length; i++) {
            result += students[i] + " ";
        }
        return result;
    }



}
