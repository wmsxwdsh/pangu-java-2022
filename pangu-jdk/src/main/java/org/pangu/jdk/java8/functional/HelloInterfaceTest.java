package org.pangu.jdk.java8.functional;

/**
 * @author LZG
 */
public class HelloInterfaceTest {

    public static void main(String[] args) {
//        HelloInterfaceTest test = new HelloInterfaceTest();
//        test.testFunctionalInterface();;
//        test.testRunnableInterface();
    }

    // 自定义的函数式接口
    public void testFunctionalInterface() {
        /**
         * // 无参数，无返回值
         * () -> log.info("Lambda")
         *
         *  // 有参数，有返回值
         * (int a, int b) -> { a+b }
         */
        HelloInterface helloInterface = (String name) -> "hello " + name;
        System.out.println(helloInterface.sayHello("叶孤城"));
    }

    public void testRunnableInterface() {
        new Thread(() -> {
            System.out.println("快速新建并启动一个线程");
        }).start();

        // 上面的  =  下面的


        //Runnable本身就是一个函数式接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("快速新建并启动一个线程");
            }
        }).start();
    }


}

