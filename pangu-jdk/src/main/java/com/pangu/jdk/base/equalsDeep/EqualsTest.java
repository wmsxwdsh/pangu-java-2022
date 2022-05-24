package com.pangu.jdk.base.equalsDeep;

/**
 * 深入理解equals方法
 *
 * @author LZG
 * @date 2019/3/4
 */
public class EqualsTest {

    /**
     * 用于存放编译期生成的各种字面量和符号引用，这部分内容将在类加载后存放到常量池中
     * 基本类型和包装类
     * 包装类不管理浮点型（float和double），整形只会管理-128到127）和String（也可以通过String.intern()方法强制将String放入常量池）
     */
    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abc";
        System.out.println("str1 == str2: " + (str1 == str2)); //true

        String str3 = new String("abc");
        System.out.println("str1 == str3: " + (str1 == str3)); //false
        System.out.println("str1 == str3.intern(): " + (str1 == str3.intern())); //true

        Integer num1 = 12;
        Integer num2 = 12;
        Integer num3 = new Integer(12);
        System.out.println("num1 == num2: " + (num1 == num2)); //true
        System.out.println("num1 == num3: " + (num1 == num3)); //false

        Integer num4 = 1234;
        Integer num5 = 1234;
        System.out.println("num4 == num5: " + (num4 == num5)); //false

        Double double1 = 11.11;
        Double double2 = 11.11;
        System.out.println("double1 == double2: " + (double1 == double2)); //false

        Float float1 = 20.89f;
        Float float2 = 20.89f;
        System.out.println("float1 == float2: " + (float1 == float2)); //false
    }

}