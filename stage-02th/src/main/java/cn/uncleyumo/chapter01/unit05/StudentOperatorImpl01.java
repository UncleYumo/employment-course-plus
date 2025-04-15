package cn.uncleyumo.chapter01.unit05;

import java.util.List;

/**
 * @author uncle_yumo
 * @fileName StudentOperatorImpl01
 * @createDate 2025/4/15 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class StudentOperatorImpl01 implements StudentOperator{
    @Override
    public void printAllInfo(List<Student> students) {
        System.out.println("---------------全班全部学生信息---------------");
        students.forEach(student -> {
            System.out.println("姓名：" + student.getName() + " 性别：" + student.getSex() + " 成绩：" + student.getScore());
        });
        System.out.println("-------------------------------------------");
    }

    @Override
    public void printAverageScore(List<Student> students) {
        System.out.println("---------------打印全班平均分数---------------");
        double sum = students.stream().mapToDouble(Student::getScore).sum();
        System.out.println("全班平均分数：" + sum / students.size());
        System.out.println("-------------------------------------------");
    }
}
