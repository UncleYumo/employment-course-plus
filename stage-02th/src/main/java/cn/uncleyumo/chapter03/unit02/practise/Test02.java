package cn.uncleyumo.chapter03.unit02.practise;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test02
 * @createDate 4/23/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 设计一个成绩管理系统，
 * ①该系统使用数组记录多个学生的成绩信息
 * ②编写学生对象包含姓名、语文、数学、英语成绩，和查询总分的方法
 * ③编写测试类实现查询学生排名等功能。要求使用Lambda表达式
 * ⑥编写CompareByData类，在里面定义比较方法，使用实例方法引用简化lambda表达式。
 */
public class Test02 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Sa", 85, 90, 88));
        students.add(new Student("Sb", 78, 82, 80));
        students.add(new Student("Sc", 92, 100, 100));

        students.sort(Comparator.comparingInt(Student::getTotalScore).reversed());

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName() + " - Total Score: " + students.get(i).getTotalScore());
        }

        CompareByData compareByData = new CompareByData();
        students.sort(compareByData::compareByTotalScore);

        System.out.println("\n排序后的学生列表:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName() + " - Total Score: " + students.get(i).getTotalScore());
        }
    }
}

@Data
class Student {
    private String name;
    private int chinese;
    private int math;
    private int english;

    public Student(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public int getTotalScore() {
        return chinese + math + english;
    }
}

class CompareByData {
    public int compareByTotalScore(Student s1, Student s2) {
        return Integer.compare(s2.getTotalScore(), s1.getTotalScore());
    }
}
