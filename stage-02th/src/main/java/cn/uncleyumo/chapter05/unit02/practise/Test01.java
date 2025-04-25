package cn.uncleyumo.chapter05.unit02.practise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/25/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 创建一个ArrayList集合，并使用以下方式完成遍历
 * ①向其中添加多个字符串元素
 * ②使用for循环遍历集合
 * ③使用迭代器遍历集合并且演示迭代器可以删除元素
 * ④使用foreach循环遍历
 * ⑤使用Lambda表达式遍历，并打印元素长度
 */

public class Test01 {
    public static void main(String[] args) {
        practise01();
    }
    public static void practise01() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("test");

        // 使用for循环遍历集合
        System.out.println("-----------------------------------");
        for (String s : list) {
            System.out.println(s);
        }

        // 使用迭代器遍历集合并演示删除元素
        System.out.println("-----------------------------------");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("java".equals(next)) {
                iterator.remove();
                continue;
            }
            System.out.println(next);
        }

        //使用foreach遍历集合
        System.out.println("-----------------------------------");
        for (String s : list) {
            System.out.println(s);
        }

        // 使用Lambda表达式遍历，并打印元素长度
        System.out.println("-----------------------------------");
        list.forEach(System.out::println);
    }
}
