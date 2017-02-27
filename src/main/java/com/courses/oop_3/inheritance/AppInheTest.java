package com.courses.oop_3.inheritance;

/**
 * Created by Vladimir Sulevskiy on 07.07.2015.
 */
public class AppInheTest {
    public static void main(String[] args) {
        Student student = new Student(100,
                "Ivanov",new int[]{1,2,2});
        student.toString();
        Person person = new Person();
    }
}
