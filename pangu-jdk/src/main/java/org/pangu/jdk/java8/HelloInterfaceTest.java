package org.pangu.jdk.java8;

/**
 * @author LZG
 */
public class HelloInterfaceTest {

    public static void main(String[] args) {

        //String name是函数式方法需要的参数。
        HelloInterface helloInterface = (String name) -> "hello " + name;
        System.out.println(helloInterface.sayHello("叶孤城"));

    }

}

