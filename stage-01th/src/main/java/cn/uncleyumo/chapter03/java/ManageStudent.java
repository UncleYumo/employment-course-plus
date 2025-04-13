package cn.uncleyumo.chapter03.java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author uncle_yumo
 * @fileName ManageStudent
 * @createDate 2025/4/8 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class ManageStudent {
    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    ====欢迎进入学生管理系统====
                    1、添加学生（add）
                    2、查看学生（query）
                    3、退出系统（exit、:wq）
                    请输入您的操作：
                    """.trim());
            String input = scanner.nextLine();
            switch (input) {
                case "add" -> addStudent(scanner);
                case "query" -> queryStudent(scanner);
                case "exit", ":wq" -> {
                    System.out.println("欢迎下次使用！");
                    return;
                }
                default -> System.out.println("输入有误，请重新输入！");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.println("请输入学生ID：");
        String id = scanner.nextLine();
        System.out.println("请输入学生姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入学生年龄：");
        int age = scanner.nextInt();
        scanner.nextLine(); // 跳过回车
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        students.add(student);
        System.out.println("添加成功！");
    }

    private static void queryStudent(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("暂无学生信息！");
        }
        for (Student student : students) {
            System.out.println("学生ID：" + student.getId());
            System.out.println("学生姓名：" + student.getName());
            System.out.println("学生年龄：" + student.getAge() + "\n");
        }
    }
}