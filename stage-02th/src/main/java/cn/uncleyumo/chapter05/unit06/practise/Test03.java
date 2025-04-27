package cn.uncleyumo.chapter05.unit06.practise;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test03
 * @createDate 4/27/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 编写一个测试类，完成一下功能
 *  1.定义集合List，添加以下数据："王佳乐","张三丰","王思聪","张飞","刘晓敏","张靓颖","王敏"
 *  2.使用Stream流 筛选出所有的“张”姓学员并用Stream保存
 *  3.使用Stream流 筛选出所有的“王”姓学员并用Stream保存
 *  4.将两个流合并为一个流后找出名字是3个字的名字数量并将结果打印在控制台
 */

public class Test03 {
    public static void main(String[] args) {
        List<String> originalList = List.of("王佳乐", "张三丰", "王思聪", "张飞", "刘晓敏", "张靓颖", "王敏");
        Stream<String> stream01 = originalList.stream().filter(s -> s.startsWith("张"));
        Stream<String> stream02 = originalList.stream().filter(s -> s.startsWith("王"));
        Stream<String> finalStream = Stream.concat(stream01, stream02);
        finalStream.filter(s -> s.length() == 3).toList().forEach(System.out::println);
    }
}
