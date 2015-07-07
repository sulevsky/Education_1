package com.courses.oop_1;

/**
 * Created by Vladimir Sulevskiy on 30.06.2015.
 */
public class StudentApp {
    public static void main(String[] args) {
        Student student1 = new Student(0, "Ivanov");
        Student student2 = new Student(1,"Petrov");
        student1.setMark(2,5);
        student2.setMark(6,4);

        Group group = new Group();
        group.addStudent(student1);
        group.addStudent(student2) ;
        group.addStudent("Sidorov");
        group.print();

    }
}
