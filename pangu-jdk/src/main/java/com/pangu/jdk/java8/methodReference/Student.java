package com.pangu.jdk.java8.methodReference;

/**
 * @author LZG
 */
public class Student {

    private String name;
    private Integer age;

    public static int compareByAge(Student s1, Student s2) {
        return s1.age.compareTo(s2.age);
    }


    public void whoIam() {
        System.out.println("I am " + this.toString());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {

    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}

