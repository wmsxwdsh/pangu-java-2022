package org.pangu.jdk.java8.methodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用，分四类
 * 1、类名::静态方法名
 * 2、对象::实例方法名
 * 3、类名::实例方法名
 * 4、类名::new
 *
 * @author LZG
 */
public class MethodReferenceTest {

    private static List<Student> list = new ArrayList<>();

    static {
        list.add(new Student("张三", 22));
        list.add(new Student("李四", 40));
        list.add(new Student("王五", 31));

    }

    /**
     * 1、类名::静态方法名
     */
    public void test1() {
        // 演化第1步：自己去实现函数式接口
        list.sort((o1, o2) -> o1.getAge().compareTo(o2.getAge()));

        // 演化第2步：调用已有的静态方法实现
        list.sort((o1, o2) -> Student.compareByAge(o1, o2));

        // 演化第3步：静态方法引用
        list.sort(Student::compareByAge);

        list.forEach(element -> System.out.println(element.toString()));
    }

    /**
     * 2、对象::实例方法名
     */
    public void test2() {
        StudentComparator studentComparator = new StudentComparator();
        list.sort(studentComparator::compareStudentByAge);
        list.forEach(element -> System.out.println(element.toString()));
    }

    /**
     * 3、类名::实例方法名
     */
    public void test3() {
        list.forEach(element -> {
            element.whoIam();
        });
        System.out.println("----- 上面的 = 下面的 -----");

        list.forEach(Student::whoIam);
    }

    /**
     * 4、类名::new
     */
    public void test4() {
        // 前提是Student类中存在无参构造方法
        Supplier<Student> supplier = Student::new;
        Student student = supplier.get();
        System.out.println(student);
    }


    public static void main(String[] args) {
        MethodReferenceTest test = new MethodReferenceTest();
        test.test1();
        test.test2();
        test.test3();
        test.test4();
    }

}

