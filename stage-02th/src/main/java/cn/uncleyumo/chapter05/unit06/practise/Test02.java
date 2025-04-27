package cn.uncleyumo.chapter05.unit06.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test02
 * @createDate 4/27/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 编写一个测试类，实现以下功能
 * ①随机生成10个10至20之间的随机数(数字允许重复),并将每个数字打印到控制台，
 * ②使用Stream流的技术,找出大于15的元素并打印出来;
 */

public class Test02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 10 + 11));
        }
        list.forEach(System.out::println);
        System.out.println("Nums that are greater than 15");
        list.stream().filter(num -> num > 15).forEach(System.out::println);
    }
}
