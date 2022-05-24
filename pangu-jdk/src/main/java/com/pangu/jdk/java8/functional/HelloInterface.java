package com.pangu.jdk.java8.functional;

/**
 * 函数式接口
 * @author LZG
 * @date 2019/3/12
 */
@FunctionalInterface
public interface HelloInterface {

    String sayHello(String name);

    /**
     * 静态方法
     * <p>
     * java8中为接口新增了一项功能，定义一个或者多个静态方法。用法和普通的static方法一样
     * 注意：实现接口的类或者子接口不会继承接口中的静态方法。
     */
    static void staticMethod() {
        System.out.println("static method");
    }

    /**
     * default方法
     * <p>
     * java8在接口中新增default方法
     * 如果接口中的默认方法不能满足某个实现类需要，那么实现类可以覆盖默认方法。不用加default关键字，使用public
     */
    default void print() {
        System.out.println("hello default");
    }

}