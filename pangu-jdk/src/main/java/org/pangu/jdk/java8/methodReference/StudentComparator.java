package org.pangu.jdk.java8.methodReference;

/**
 * @author LZG
 */
public class StudentComparator {

    public int compareStudentByAge(Student student1, Student student2) {
        return student2.getAge() - student1.getAge();
    }
}

