package org.pangu.jdk.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream是java8提供的用来处理集合数据的新方式
 * 可以像sql操作一样，用lambda表示出来
 * <p>
 * +--------------------+       +------+   +------+   +---+   +-------+
 * | stream of elements |-----> |filter|-> |sorted|-> |map|-> |collect|
 * +--------------------+       +------+   +------+   +---+   +-------+
 * <p>
 * 中间操作：map() filter() distinct()  sorted() limit() skip()
 * 结束操作：forEach() collect() max() min() count() toArray() reduce() anyMatch()等
 *
 * @author LZG
 */
public class StreamTest {

    //stream的创建
    public void streamCreate() {
        //1、使用数组创建流（或者数组的部分创建流）
        String[] arr = new String[]{"1", "2", "3", "4", "5"};
        Stream<String> entireArrayStream = Arrays.stream(arr);
        Stream<String> partArrayStream = Arrays.stream(arr, 1, 4);

        //2、使用集合创建流
        List<String> nameList = Arrays.asList("叶孤城", "西门吹雪", "司空摘星");
        Stream<String> nameStream = nameList.stream();

        //3、使用Stream.Builder()来创建流
        Stream<String> streamBuilder = Stream.<String>builder().add("1").add("2").add("3").build();

    }

    //2、stream的中间操作filer、map、limit/skip、sorted、distinct
    public void test1() {
        //(1)、filter用于通过设置的条件过滤出元素
        List<String> strList1 = Arrays.asList("hello", "world", "helloWorld");
        strList1.stream().filter(element -> element.startsWith("h")).forEach(element -> System.out.println(element));
        strList1.stream().filter(element -> element.endsWith("o")).forEach(System.out::println);

        //(2)、map用于映射每个元素到对应的结果
        List<Integer> mapNumberList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        mapNumberList.stream().map(i -> i * i).forEach(System.out::println);
        //9,4,4,9,49,9,25

        //(3)、limit返回Stream的前面n个元素；skip 则是扔掉前 n 个元素。
        List<Integer> limitNumberList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        limitNumberList.stream().limit(4).forEach(System.out::println);
        //3,2,2,3

        //(4)、sorted 方法用于对流进行排序
        List<Integer> sortedNumberList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        sortedNumberList.stream().sorted().forEach(System.out::println);
        //2,2,3,3,3,5,7

        //(5)、distinct主要用来去重
        List<Integer> distinctNumberList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        distinctNumberList.stream().distinct().forEach(System.out::println);
        //3,2,7,5
    }

    //3、stream的最终操作forEach、count、collect
    public void test2() {
        //(1)、count用来统计流中的元素个数
        List<String> countStrList = Arrays.asList("java", "php", "python", "ios", "c");
        System.out.println(countStrList.stream().count());

        //(2)、collect将流中的元素累积成一个汇总结果
        List<String> strList = Arrays.asList("java", "php", "python", "ios", "c");
        //可以用原来的strList接收，也可以再新建一个List<String> strList2来接收
        strList = strList.stream().filter(element -> element.startsWith("p")).collect(Collectors.toList());
        strList.forEach(System.out::println);
    }


    ///////////////////////////////////////////////////////////////////////////
    // 实战
    ///////////////////////////////////////////////////////////////////////////
    public void experience1() {
        //（1）、取某个List<Bean>的bean的某个属性成为集合
//        List<PubUserRoleKey> pubUserRoleList = pubUserRoleKeyService.getPubUserRoleList(userId);
//        List<String> roleIdList = pubUserRoleList.stream().map(element ->
//                element.getRoleId()).collect(Collectors.toList());
    }

}

