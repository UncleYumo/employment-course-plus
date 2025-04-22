package cn.uncleyumo.chapter03.unit01;

import lombok.Data;

import java.util.Arrays;

import static cn.uncleyumo.chapter03.unit01.Student.compareByAge;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test02
 * @createDate 4/22/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

@Data
class Student {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    // 省略 getters and setters（lombok秒了）

    // 比较两个学生对象年龄的方法
    public static int compareByAge(Student s1, Student s2) {
        return s1.age.compareTo(s2.age);
    }
}
//假设我们现在有一个Student对象数组，要按照学生的年龄从小到大排序：

public class Test02 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Tom", 20),
                new Student("Jerry", 18),
                new Student("Lily", 19),
                new Student("Lucy", 22),
                new Student("kevin", 21)};
        // 使用匿名内部类
        /*
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getAge().compareTo(s2.getAge());
            }
        });
        */
        // 第一步，使用Lambda表达式改写
        Arrays.sort(students, (s1, s2) -> compareByAge(s1, s2));

        // 第二步，使用方法引用改写
        Arrays.sort(students, Student::compareByAge);

        // 遍历
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getAge());
        }
    }
}