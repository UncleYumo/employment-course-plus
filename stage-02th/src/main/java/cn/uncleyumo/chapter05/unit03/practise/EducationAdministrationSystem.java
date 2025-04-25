package cn.uncleyumo.chapter05.unit03.practise;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dev.uncleyumo.cn
 * @fileName EducationAdministrationSystem
 * @createDate 4/25/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 学校的教务系统需要处理学生选课情况。需要实现以下功能：
 * ①每个学生可以选择一门或多门课程（使用可变参数），并将选课信息存储在集合中。
 * ②实现添加选课功能，确保同一门课程不会重复添加。
 * ③实现退选课程功能，学生可以选择退选已选的课程。
 * ④实现展示学生选课情况的功能，以便学生和教务人员可以查看选课信息。
 * ⑤编写测试方法，测试以上功能
 */

public class EducationAdministrationSystem {

    public void addCourses(Student student, Curriculum... curricula) {
        if (student.getCurriculumSet() == null) {
            student.setCurriculumSet(new HashSet<>());
        }
        for (Curriculum curriculum : curricula) {
            student.getCurriculumSet().add(curriculum);
        }
    }

    public void dropCourse(Student student, Curriculum curriculum) {
        if (student.getCurriculumSet() != null) {
            student.getCurriculumSet().remove(curriculum);
        }
    }

    public void displayCourses(Student student) {
        System.out.println("学生：" + student.getStuName() + " 的选课情况如下：");
        if (student.getCurriculumSet() == null || student.getCurriculumSet().isEmpty()) {
            System.out.println("暂无选课记录！");
        } else {
            for (Curriculum curriculum : student.getCurriculumSet()) {
                System.out.println("课程编号：" + curriculum.getCurId() + ", 课程名称：" + curriculum.getCurName());
            }
        }
    }

    public static void main(String[] args) {
        // 创建课程对象
        Curriculum math = new Curriculum("C001", "高等数学");
        Curriculum english = new Curriculum("C002", "大学英语");
        Curriculum physics = new Curriculum("C003", "大学物理");

        // 创建学生对象
        Student student = new Student();
        student.setStuId("S001");
        student.setStuName("张三");

        // 初始化教务系统
        EducationAdministrationSystem system = new EducationAdministrationSystem();

        // 测试添加选课功能
        system.addCourses(student, math, english, physics);
        system.displayCourses(student);

        // 测试退选课程功能
        System.out.println("\n退选大学英语后：");
        system.dropCourse(student, english);
        system.displayCourses(student);

        // 测试重复添加课程
        System.out.println("\n尝试重复添加高等数学：");
        system.addCourses(student, math);
        system.displayCourses(student);
    }
}

@Data
class Student {
    private String stuId;
    private String stuName;
    private Set<Curriculum> curriculumSet;
}

@Data
@AllArgsConstructor
class Curriculum {
    private String curId;
    private String curName;
}
