package cn.uncleyumo.chapter03.unit01.practise;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/23/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static void main(String[] args) {
        practise02();
    }

    /**
     * 使用Arrays.sort方法，对一个字符串数组进行升序排序，要求忽略首字符大小写排序，
     * 请特定类型的方法引用简化lambda写法
     */
    private static void practise02() {
        List<String> strArray = List.of("asdf", "asd", "asdfg", "asdfgh", "asdfghj", "asdfghjk", "asdfghjkl");
        String[] array = strArray.toArray(new String[0]);
        Arrays.sort(array, Comparator.comparing(String::toLowerCase));
        System.out.println(Arrays.toString(array));
    }

    /**
     * 使用Arrays.sort方法，对一个字符串数组进行排序，要求按照字符串长度从小到大排序。分别用下面两种方式实现
     * ①使用lambda表达式实现
     * ②编写CompareByData类，在里面定义静态比较方法，使用静态方法引用简化lambda写法
     */
    private static void practise01() {
        List<String> strArray = List.of("asdf", "asd", "asdfg", "asdfgh", "asdfghj", "asdfghjk", "asdfghjkl");
        String[] array = strArray.toArray(new String[0]);
        Arrays.sort(array, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(array));

        // 编写CompareByData类，在里面定义静态比较方法，使用静态方法引用简化lambda
        System.out.println("--------------------------------------------");
        Arrays.sort(array, CompareByData::compare);
        System.out.println(Arrays.toString(array));
    }

    static class CompareByData {
        // 从大到小排序
        static int compare(String s1, String s2) {
            return s2.length() - s1.length();
        }
    }
}