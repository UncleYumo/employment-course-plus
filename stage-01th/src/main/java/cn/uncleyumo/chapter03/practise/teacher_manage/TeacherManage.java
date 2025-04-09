package cn.uncleyumo.chapter03.practise.teacher_manage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author uncle_yumo
 * @fileName TeacherManage
 * @createDate 2025/4/9 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class TeacherManage {
    private static final List<Teacher> TEACHER_LIST = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    
                    --------欢迎来到 <老师> 管理系统--------
                    请输入您的选择：1.添加老师 2.删除老师 3.修改老师 4.查看老师 5.退出
                    """);
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> addTeacher(scanner);
                case "2" -> deleteTeacher(scanner);
                case "3" -> updateTeacher(scanner);
                case "4" -> showTeacher();
                case "5" -> {
                    System.out.println("已退出！");
                    return;
                }
                default -> System.out.println("输入有误，请重新输入！");
            }
        }
    }

    private static void updateTeacher(Scanner scanner) {
        System.out.println("请输入老师id：");
        String id = scanner.nextLine();
        System.out.println("请输入老师姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入老师年龄：");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入老师生日：");
        String birthday = scanner.nextLine();
        Teacher teacher = getTeacherById(id);
        if (teacher == null) {
            System.out.println("老师不存在！将为您添加！");
            TEACHER_LIST.add(Teacher.builder().id(id).name(name).age(age).birthday(birthday).build());
            return;
        }
        teacher.setName(name);
        teacher.setAge(age);
        teacher.setBirthday(birthday);
        System.out.println("修改成功！");
    }

    private static void deleteTeacher(Scanner scanner) {
        System.out.println("请输入老师id：");
        String id = scanner.nextLine();
        Teacher teacher = getTeacherById(id);
        if (teacher == null) {
            System.out.println("老师不存在！");
            return;
        }
        TEACHER_LIST.remove(teacher);
        System.out.println("删除成功！");
    }

    private static void addTeacher(Scanner scanner) {
        System.out.println("请输入老师id：");
        String id = scanner.nextLine();
        Teacher teacherById = getTeacherById(id);
        if (teacherById != null) {
            System.out.println("老师已存在！");
            return;
        }
        System.out.println("请输入老师姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入老师年龄：");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入老师生日：");
        String birthday = scanner.nextLine();
        TEACHER_LIST.add(Teacher.builder().id(id).name(name).age(age).birthday(birthday).build());
        System.out.println("添加成功！");
    }

    private static void showTeacher() {
        System.out.println("学号\t\t姓名\t\t年龄\t\t生日");
        TEACHER_LIST.forEach(teacher -> {
            System.out.println(teacher.getId() + "\t\t" + teacher.getName() + "\t\t" + teacher.getAge() + "\t\t" + teacher.getBirthday());
        });
    }

    private static Teacher getTeacherById(String id) {
        return TEACHER_LIST.stream().filter(teacher -> teacher.getId().equals(id)).findFirst().orElse(null);
    }
}
