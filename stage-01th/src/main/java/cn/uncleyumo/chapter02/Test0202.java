package cn.uncleyumo.chapter02;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.StreamSupport;

/**
 * @author uncle_yumo
 * @fileName Test0202
 * @createDate 2025/4/5 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Test0202 {
    public static void main(String[] args) {
//        Teacher teacher1 = new Teacher("王老师", 32);
//        Teacher teacher2 = new Teacher("李老师", 33);
//        teacher1.showInfo();
//        teacher2.showInfo();
//        Student student1 = new Student();
//        student1.setChinese(90);
//        student1.setMath(85);
//        student1.setLikes(new String[]{"唱", "跳", "rap", "篮球"});
//        student1.showInfo();
//        Student student2 = new Student();
//        student2.setChinese(93);
//        student2.setMath(90);
//        student2.setLikes(new String[]{"抽烟", "喝酒", "烫头"});
//        student2.showInfo();
//        Fruit fruit1 = new Fruit("草莓", 20);
//        fruit1.showInfo();
//        Fruit fruit2 = new Fruit("香蕉", 6);
//        fruit2.showInfo();
//        int money = 120;
//        int maxBanana = money / fruit2.getPrice();
//        int maxApple = money / fruit1.getPrice();
        RollCallSystem.start();
    }
}

/*定义一个老师（Teacher）类，这个老师类有姓名和年龄两个属性，有一个方法能展示姓名（name）和年龄（age）。
创一个测试类，并完成如下内容：
    创建两个老师对象通过成员方法将他们的信息打印到控制台上。（格式如下）
    王老师的年龄是32
    李老师的年龄是33*/
class Teacher {
    private String name;
    private int age;

    public Teacher() {

    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println(name + "的年龄是" + age);
    }
}

class Student {
    private String name;
    private int chinese;
    private int math;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public String[] getLikes() {
        return likes;
    }

    public void setLikes(String[] likes) {
        this.likes = likes;
    }

    private int english;
    private String[] likes;

    public Student() {

    }

    public Student(String name, int chinese, int math, int english, String[] likes) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.likes = likes;
    }

    public void showInfo() {
        if (chinese != 0) {
            System.out.println(name + "的语文分数是" + chinese);
        }
        if (math != 0) {
            System.out.println(name + "的数学分数是" + math);
        }
        if (english != 0) {
            System.out.println(name + "的英语分数是" + english);
        }
        if (likes != null && likes.length > 0) {
            System.out.println(name + "的兴趣爱好有：" + likes[0]);
            for (int i = 1; i < likes.length; i++) {
                System.out.println("    " + likes[i]);
            }
        }
    }
}

/*6. 题干
    超市里面新进一批水果，请定义一个水果类Fruit，有成员属性分别是品种（brandName），价格（price int类型），
    创建一个测试类FruitTest类，并完成如下内容：
    ① 创建两个水果对象通过成员方法将水果信息打印到控制台上。（格式如下）
    草莓==20元/斤
    香蕉==6元/斤
    ② 在main方法中键盘录入一个1-1000钱数（整数、单位：元），问最多能购买多少斤香并输出在控制台上，
    最多能购买多少斤草莓并输出在控制台上。（不足1斤，则舍掉）
    最终结果例如：
    120元能买6斤草莓
    120元能买20斤香蕉*/
class Fruit {
    private String brandName;
    private int price;

    public Fruit() {
    }

    public Fruit(String brandName, int price) {
        this.brandName = brandName;
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void showInfo() {
        System.out.println(brandName + "==" + price + "元/斤");
    }
}

/*老师要制作一个点名系统，录入班级里面有5名同学的信息，包括姓名（name）和年龄（age）。
    5个学生分别是：小明、13岁，小张、12岁，小红、13岁，小军、13岁，小白、12岁，
    每次都随机从这5个同学随机抽取一位并将他们的姓名和年龄输出到控制台上。
    输出格式如下：
    小红==13岁*/
class RollCallSystem {
    private static final Student[] STUDENTS = new Student[5];

    public static void start() {
        Random random = new Random();
        int flag = STUDENTS.length;
        while (flag > 0) {
            int index = random.nextInt(flag);
            Student student = STUDENTS[index];
            System.out.println(student.getName() + "==" + student.getAge() + "岁");
            flag--;
        }
    }

    static {
        STUDENTS[0] = new Student("小明", 13);
        STUDENTS[1] = new Student("小张", 12);
        STUDENTS[2] = new Student("小红", 13);
        STUDENTS[3] = new Student("小军", 13);
        STUDENTS[4] = new Student("小白", 12);
    }

    static class Student {
        private String name;
        private int age;

        public Student() {

        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}