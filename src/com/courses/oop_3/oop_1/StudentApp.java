package com.courses.oop_3.oop_1;

import org.hibernate.annotations.SourceType;

/**
 * Created by Vladimir Sulevskiy on 30.06.2015.
 */
public class StudentApp {
    public static void main(String[] args) {
        Student student1 = new Student(0, "Ivanov");
        Student student2 = new Student(1,"Petrov");
//        student1.setMark(2,5);
//        student2.setMark(6, 4);

        Group group = new Group();
//        group.add(student1);
//        group.add(student2) ;
//        System.out.println(group.toString());
//        System.out.println(group.getStudentsNum());
        System.out.println(student1);
        group.changeName(student1);
        System.out.println(student1);

//        int mark = 4;
//        System.out.println(mark);
//        group.changeMark(mark);
//        System.out.println(mark);
    }
}
