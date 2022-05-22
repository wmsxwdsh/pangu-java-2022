package com.pangu.utils.reflect;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://juejin.cn/post/6844903551618007054
 * <p>
 * reflect    : 设置要反射的类
 * newInstance: 实例化反射对象
 * field      : 设置反射的字段
 * method     : 设置反射的方法
 * get        : 获取反射想要获取的
 *
 * @author LZG
 */
public class ReflectUtilsTest {

    private static String s1 = new String("hello");
    private static Integer i1 = 5;

    // 实例化反射对象
    @Test
    public void reflectObject() {
        String str1 = ReflectUtils.reflect(String.class).newInstance().get();
        // equals: String str1 = new String();

        String str2 = ReflectUtils.reflect("java.lang.String").newInstance("abc").get();
        // equals: String str2 = new String("abc");
        Assert.assertEquals("不相等", "abc", str2);

        String str3 = ReflectUtils.reflect(String.class).newInstance("abc".getBytes()).get();
        // equals: String str3 = new String("abc".getBytes());
    }

    // 实例化反射方法
    @Test
    public void reflectMethod() {
        String str1 = ReflectUtils.reflect((Object) "1234").method("substring", 2).get();
        // equals: String str1 = "1234".substring(2);

        String str2 = ReflectUtils.reflect((Object) "1234").method("substring", 0, 2).get();
        // equals: String str1 = "1234".substring(0, 2);
    }

    // 设置反射的字段
    @Test
    public void reflectSetField() {
        ReflectUtils.reflect(ReflectUtilsTest.class).field("s1", "world")
                .field("i1", 10);

        // 反射获取 s1
        Object s1Obj = ReflectUtils.reflect(ReflectUtilsTest.class).field("s1").get();
        System.out.println(s1Obj.toString());

        //反射获取 i2
        Object i1obj = ReflectUtils.reflect(ReflectUtilsTest.class).field("i1").get();
        System.out.println(i1obj);
    }

}

