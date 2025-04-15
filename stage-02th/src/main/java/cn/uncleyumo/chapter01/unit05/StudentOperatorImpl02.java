package cn.uncleyumo.chapter01.unit05;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author uncle_yumo
 * @fileName StudentOperatorImpl02
 * @createDate 2025/4/15 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class StudentOperatorImpl02 implements StudentOperator {

    @Override
    public void printAllInfo(List<Student> students) {
        System.out.println("---------------全班全部学生信息---------------");
        // 统计男生数量
        long countMale = students.stream().filter(student -> student.getSex() == '男').count();
        long countFemale = students.size() - countMale;
        students.forEach(student -> {
            System.out.println("姓名：" + student.getName() + " 性别：" + student.getSex() + " 成绩：" + student.getScore());
        });
        System.out.println("-------------------------------------------");
    }

    @Override
    public void printAverageScore(List<Student> students) {
        System.out.println("---------------打印全班平均分数---------------");
        // 计算去掉一个最高分和一个最低分后的平均分数
        double sum = students.stream()
                .sorted(Comparator.comparingDouble(Student::getScore))  // 默认升序
                .skip(1)  // 去掉一个最低分
                .limit(students.size() - 2)  // 确保只考虑去掉最高分和最低分后的学生
                .mapToDouble(Student::getScore)
                .sum();

        // 打印最高分
        students.stream().max(Comparator.comparingDouble(Student::getScore)).ifPresentOrElse(
                student -> System.out.println("全班最高分：" + student.getScore()),
                () -> System.out.println("没有找到最高分。")
        );

        // 打印最低分
        students.stream().min(Comparator.comparingDouble(Student::getScore)).ifPresentOrElse(
                student -> System.out.println("全班最低分：" + student.getScore()),
                () -> System.out.println("没有找到最低分。")
        );

        // 打印平均分数
        System.out.println("全班平均分数：" + sum / (students.size() - 2));
        System.out.println("-------------------------------------------");
    }
}
