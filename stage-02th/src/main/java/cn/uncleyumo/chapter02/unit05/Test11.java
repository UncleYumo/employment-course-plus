package cn.uncleyumo.chapter02.unit05;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test11
 * @createDate 4/21/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test11 {
    public static void main(String[] args) {
        practise02();
    }

    private static void practise02() {
        @Data
        @AllArgsConstructor
        class Student implements Comparable<Student> {
            private String name;
            private int score;
            private int age;
            private Student() { }

            @Override
            public int compareTo(Student o) {
                // 制定排序规则
                return this.score - o.score;
            }
        }

        Student[] students = {
                new Student("张三", 100, 18),
                new Student("李四", 90, 19),
                new Student("王五", 80, 20)
        };
        Arrays.sort(students);
        Arrays.stream(students).forEach(System.out::println);

        Arrays.sort(students, (o1, o2) -> o2.age - o1.age);
        Arrays.stream(students).forEach(System.out::println);
    }

    private static void practise01() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(Arrays.copyOf(arr, 20)));

        Arrays.setAll(arr, (IntUnaryOperator) value -> (int) (value * 0.8));
        System.out.println(Arrays.toString(arr));
    }

}
