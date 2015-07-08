package com.courses.oop_3.oop_1;
public class Group {
    private Student[] students = new Student[10];
    private int numOfStudents = 0;
    public void addStudent(Student student) {
        if (numOfStudents < students.length - 1) {
            students[numOfStudents] = student;
            numOfStudents++;
        } else {
            Student[] newStudents =
                    new Student[students.length * 2];
            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
            }
            newStudents[numOfStudents] = student;
            numOfStudents++;
            students = newStudents;
        }
    }

    public void addStudent(String surname) {
        Student student = new Student(numOfStudents,surname);
        addStudent(student);
    }

    public void print() {
        for(int i = 0; i<numOfStudents;i++){
            System.out.print(students[i].getId()
                    + " " + students[i].getSurname()+"\n");
        }
    }
}
