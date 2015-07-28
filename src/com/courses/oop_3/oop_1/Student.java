package com.courses.oop_3.oop_1;

import java.util.Arrays;

public class Student {
    private int id;
    private String surname;
    private int[] marks;

    public Student(int i, String s, int[] m) {
        id = i;
        surname = s;
        marks = m;
    }
   public Student(int i, String s, int numOfMarks) {
        id = i;
        surname = s;
        marks = new int[numOfMarks];
    }

    public Student(int id, String surname) {
        this(id,surname,34);
    }

    public Student(Student st) {
        this.id = st.id;
        surname = new String(st.surname);
        marks = new int[st.marks.length];
        for (int i = 0; i < st.marks.length; i++) {
            marks[i] = st.marks[i];
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = (int) id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public void setMark(int lessonNum, int mark) {
        this.marks[lessonNum] = mark;
    }

    public int getMark(int lessonNum) {
        return this.marks[lessonNum];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
//        return Arrays.equals(marks, student.marks);
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
//        result = 31 * result + (marks != null ? Arrays.hashCode(marks) : 0);
        return result;
    }
}