package cn.uncleyumo.chapter05.unit06;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/26/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static void main(String[] args) {
        practise05();
    }

    private static void practise05() {
        List<String> list01 = List.of("郭靖", "杨康");
        List<String> list02 = List.of("黄蓉", "穆念慈");
        Stream<String> stream01 = list01.stream();
        Stream<String> stream02 = list02.stream();
        Stream<String> concat = Stream.concat(stream01, stream02);
//        List<String> list = concat.toList();
        List<String> list = concat.collect(Collectors.toList());
        System.out.println(list);
    }

    private static void practise04() {
        List<Student> students = List.of(
                new Student("蜘蛛精", 18, 100.0),
                new Student("蜘蛛精", 18, 100.0),
                new Student("小龙女", 21, 92.5),
                new Student("紫霞", 15, 78.0),
                new Student("白晶晶", 35, 88.0),
                new Student("牛魔王", 49, 65.0),
                new Student("铁扇公主", 18, 80.0),
                new Student("至尊宝", 21, 95.0),
                new Student("玉刚", 23, 90.0),
                new Student("八戒", 25, 75.0),
                new Student("孙悟空", 29, 85.0)
        );
        System.out.println(
                "\nCalculate how many student's scores are greater than or equal to 80"
        );
        System.out.println(students.stream().filter(student -> student.getScore() >= 80).count());

        System.out.println("\nPlease find the one that whose score is at the top");
        System.out.println(students.stream().max(Comparator.comparing(Student::getScore)).get());

        System.out.println(
                "\nFind the students whose score is greater than or equal to 90, and" +
                        " collect them to a new List"
        );
        List<Student> collect = students.stream().filter(student -> student.getScore() >= 90).toList();
        System.out.println(collect);

        System.out.println(
                "\nFind the students whose score is greater than or equal to 90, and" +
                        " collect them to a new Set"
        );
        Set<Student> set = students.stream().filter(student -> student.getScore() >= 90).collect(Collectors.toSet());
        System.out.println(set);

        System.out.println(
                "\nFind out the students whose score exceeded 90," +
                        " and store their name and score to a new Map Collection as return"
        );
        Map<String, Double> map = students.stream().filter(student -> student.getScore() >= 90).distinct().collect(
                Collectors.toMap(Student::getName, Student::getScore)
        );
        System.out.println(map);
    }

    private static void practise03() {
        List<Student> students = List.of(
                new Student("蜘蛛精", 18, 100.0),
                new Student("蜘蛛精", 18, 99.0),
                new Student("小龙女", 21, 92.5),
                new Student("紫霞", 15, 78.0),
                new Student("白晶晶", 35, 88.0),
                new Student("牛魔王", 49, 65.0),
                new Student("铁扇公主", 18, 80.0),
                new Student("至尊宝", 21, 95.0),
                new Student("玉刚", 23, 90.0),
                new Student("八戒", 25, 75.0),
                new Student("孙悟空", 29, 85.0)
        );
        System.out.println(
                "\nFind the students whose age is greater than or equal to 23 and less than or equal to 30," +
                        " and output them in descending order of age"
        );
        students.stream()
                .filter(student -> student.getAge() >= 23 && student.getAge() <= 30)
                .sorted((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge()))
                .forEach(System.out::println);

        System.out.println("\nFind the top 3 students in terms of score and output them");
        students.stream()
                .sorted(Comparator.comparingDouble(Student::getScore).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\nFind the two students whose score are at the bottom");
        students.stream().sorted(Comparator.comparingDouble(Student::getScore).reversed())
                .skip(students.size() - 2).forEach(System.out::println);

        System.out.println(
                "\nFind the names of students whose scores exceed 90, and ask them to remove duplicates and output"
        );
        students.stream().filter(s -> s.getScore() >= 90)
                .map(Student::getName).distinct().forEach(System.out::println);
    }

    private static void practise02() {
        Map<String, String> map = Map.of("古力娜扎", "女", "赵丽颖", "女", "张三丰", "男");
        Stream<Map.Entry<String, String>> stream = map.entrySet().stream();
        Map<String, String> listStreamToMap = stream
                .filter(s -> s.getValue().equals("女"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(listStreamToMap);
    }

    private static void practise01() {
        List<String> list = List.of("张三丰", "张无忌", "赵敏", "周芷若", "赵敏");
        List<String> list01 = list.stream().filter(s -> s.startsWith("张") && s.length() == 3).toList();
        System.out.println(list01);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private String name;
    private Integer age;
    private Double score;
}
