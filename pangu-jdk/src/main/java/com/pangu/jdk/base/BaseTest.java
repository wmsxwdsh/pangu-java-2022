package com.pangu.jdk.base;

/**
 * 基础
 * （1）不同类型命名
 * （2）位移计算
 *
 * @author LZG
 */
public class BaseTest {

    public void nameTest() {
        //不加f默认为double类型
        double d1 = 0.12345;
        float f1 = 0.12345f;
    }


    public void calculate() {
        /**
         * 7
         * 0011
         * 0100
         * 0111
         */
        int result = 3 | 4; //7
        System.out.println(result);
    }

    public static void main(String[] args) {
        BaseTest baseTest = new BaseTest();
        baseTest.calculate();
    }

}

