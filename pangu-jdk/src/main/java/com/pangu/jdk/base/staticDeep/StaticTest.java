package com.pangu.jdk.base.staticDeep;

/**
 * 深入理解static，下面例子理解明白了，static再无难点
 *
 * @author LZG
 * @date 2018/11/8
 */
public class StaticTest {

    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    //静态代码块
    static {
        System.out.println("1");
    }

    /*
     构造代码块
     如果类中有构造代码块，java编译器在编译时会先将构造代码块中的代码移到构造函数中执行，构造函数中原有的代码最后执行
     */ {
        System.out.println("2");
    }


    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    static int b = 112;
    int a = 110;


    /*
      运行结果：
      2
      3
      a=110,b=0
      1
      4
     */
}