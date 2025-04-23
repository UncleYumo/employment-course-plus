package cn.uncleyumo.chapter03.unit01.practise;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Scanner;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test02
 * @createDate 4/23/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test02 {
    public static void main(String[] args) {
        Test02 test02 = new Test02();
        test02.practise04();
    }

    /**
     * 设计一个程序模拟计算机计算两个整数乘积的过程
     * ①通过键盘录入让用户输入两个整数，如果用户输入的不是整数，则提示用户重新输入
     * ②计算两个数的乘积，并将结果打印在控制台
     * （已知：如果我们使用nextInt方法让用户输入整数,但用户实际输入的不是整数的时候,会发生异常,
     * 而对于一个键盘输入对象来说,一旦发生异常,即使使用try{}catch(){}语句进行了处理,这个键盘输入对象也无法继续工作了,
     * 解决的办法就是重写创建新的键盘输入对象即可;）
     */
    private void practise04() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个整数：");
        int num01 = 0;
        while (true) {
            try {
                num01 = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("输入有误，请重新输入");
                scanner.nextLine();
            }
        }
        System.out.println("请输入第二个整数：");
        int num02 = 0;
        while (true) {
            try {
                num02 = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("输入有误，请重新输入");
                scanner.nextLine();
            }
        }
        System.out.println("乘积为：" + num01 * num02);
    }

    /**
     * 现在老师要统计学生信息，已知该班学生年龄在18-25之间，如果不在范围内，则输入错误，请编写代码模拟该过程
     * ①创建一个学生类（name，age），对学生的年龄赋值进行限制，如果输入的学生年龄不在范围内，则抛出异常
     * ②在测试类中完成创建学生对象，并对学生对象进行赋值，对学生的年龄输入一个非法数值，查看控制台输出
     */
    private void practise03() {
        try {
            Student stu = new Student("小明", 28);
            System.out.println(stu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Getter
    @ToString
    @EqualsAndHashCode
    class Student {
        private String name;
        private int age;
        private Student() { }
        public Student(String name, int age) throws Exception {
            if (age < 18 || age > 25) throw new Exception("非法的年龄: " + age + ", 学生的年龄只能在18-25之间!");
            this.name = name;
            this.age = age;
        }
        public void setAge(int age) throws Exception {
            if (age < 18 || age > 25) throw new Exception("非法的年龄: " + age + ", 学生的年龄只能在18-25之间!");
            this.age = age;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * 在一个程序中有1,2，3三个选项交给用户选择，用户输入其他选项时会给出友好提示，请设计一个程序模拟该过程
     * 1.在测试类中，使用键盘录入让用户输入选项1,2，3，通过if语句判断分别给出提示：选项一；选项二；选项三；
     * 2.若用户输入其他内容时抛出运行时异常，信息为：输入有误
     */
    private static void practise02() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("""
                        请选择：
                        1（打印Hello World）
                        2（获取当前时间）
                        3（退出程序）
                        
                        """.trim());
                int i = scan.nextInt();
                switch (i) {
                    case 1 -> System.out.println("Hello World");
                    case 2 -> System.out.println(System.currentTimeMillis());
                    case 3 -> {
                        System.out.println("退出程序");
                        return;
                    }
                    default -> throw new IllegalArgumentException("输入有误");
                }
            } catch (Exception e) {
                System.out.println("输入有误！" + e.getMessage());
                scan.nextLine();
            }
        }
    }
}