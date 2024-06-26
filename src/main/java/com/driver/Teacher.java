package com.driver;

public class Teacher {

    private String name;

    private int numberOfStudents;

    private int age;

    public Teacher(String name, int numberOfStudents, int age){
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                ", age=" + age +
                '}';
    }
}