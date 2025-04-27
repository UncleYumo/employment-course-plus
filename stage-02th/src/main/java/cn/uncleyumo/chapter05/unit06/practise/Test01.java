package cn.uncleyumo.chapter05.unit06.practise;

import java.util.List;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 4/27/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * /**
 * 创建一个类，在main方法中完成如下操作
 *   ①创建一个集合，存储多个字符串元素{"张三丰", "张无忌", "张翠山", "王二麻子", "张良", "谢广坤"}
 *   ②使用stream流把集合中所有以"张"开头的元素进行打印
 *   ③使用stream流把"张"开头的集合中的元素长度为3的元素进行遍历打印
*/


public class Test01 {
    public static void main(String[] args) {
        List<String> nameList = List.of("张三丰", "张无忌", "张翠山", "王二麻子", "张良", "谢广坤");
        System.out.println("----------②----------");
        nameList.stream().filter(it -> it.startsWith("张")).forEach(System.out::println);
        System.out.println("----------③----------");
        nameList.stream()
                .filter(it -> it.startsWith("张"))
                .filter(it -> it.length() == 3)
                .forEach(System.out::println);
    }
}
