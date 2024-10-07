package com.generation;

import java.util.ArrayList;
import java.util.List;

class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(15, "Orifjon"));
        students.add(new Student(16, "Oybek"));
        students.add(new Student(17, "Akmal"));
        students.add(new Student(18, "Abdushukur"));

        System.out.println(students);

    }
}
