package cn.uncleyumo.chapter02.unit04.practise;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test02
 * @createDate 4/22/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test02 {
    public static void main(String[] args) {
        practise02();
    }

    /**
     * 开发一个在线考试系统，要求对考生的成绩进行排名。
     * ①考生信息存储在一个数组中，每个元素包含考生姓名和成绩两个属性。
     * ②编写一个方法，能够接收一个考生信息数组，并按照成绩从高到低进行排序，然后输出每个考生的排名和姓名。
     *
     * 提示：可以使用Arrays类的sort方法进行排序，使用Comparator接口自定义排序规则，然后遍历排序后的数组，输出每个考生的排名和姓名。
     */
    private static void practise02() {

        @Data
        @AllArgsConstructor
        class Student implements Comparable<Student> {
            private String name;
            private int score;
            private Student() { }
            @Override
            public int compareTo(Student s) {
                return s.score - this.score;
            }
        }
        Student[] students = new Student[]{
                new Student("张三", 100),
                new Student("李四", 90),
                new Student("王五", 80),
                new Student("赵六", 70)
        };
        rankingStudents(students);
    }

    public static void rankingStudents(Object[] students) {
        Arrays.sort(students);
//        for (Object student : students) {
//            System.out.println(student);
//        }
        Arrays.stream(students).forEach(System.out::println);
    }

    /**
     * 定义一个类，实现以下操作
     * ①定义一个长度为10的整数数组，使用随机数对数组进行初始化。随机数范围是1-100
     * ②使用Arrays类的sort方法进行升序排序，并输出排序后的结果。
     * ③接着使用Arrays类的binarySearch方法，查找数组中值为5的元素，并输出其在数组中的位置。
     *
     * 提示：可以使用Random类生成随机数。
     */
    private static void practise01() {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 100) + 1;
        }
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        int index = Arrays.binarySearch(ints, 5);
        System.out.println(index != -1 ? index : "未找到");
    }
}
