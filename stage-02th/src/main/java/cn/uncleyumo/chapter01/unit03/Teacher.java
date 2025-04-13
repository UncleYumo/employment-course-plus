package cn.uncleyumo.chapter01.unit03;

import lombok.Getter;
import lombok.Setter;

/**
 * @author uncle_yumo
 * @fileName Teacher
 * @createDate 2025/4/11 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Setter
@Getter
public class Teacher {
    private String name;
    private int age;

    public Teacher() {
    }
    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void teach() {
    }

    @Override
    public String toString() {
        return name + "老师..." + age;
    }
}

class BaseTeacher extends Teacher {

    public BaseTeacher() {
        super();
    }

    public BaseTeacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("基础班老师讲JavaSE");
    }
}

class WorkTeacher extends Teacher {
    public WorkTeacher() {
        super();
    }

    public WorkTeacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("就业班老师讲JavaEE");
    }
}

class TestTeacher {
    public static void main(String[] args) {
//        BaseTeacher baseTeacher = new BaseTeacher("张三", 25);
//        WorkTeacher workTeacher = new WorkTeacher("李四", 30);
//        System.out.println(baseTeacher.toString());
//        baseTeacher.teach();
//        System.out.println(workTeacher.toString());
//        workTeacher.teach();

        Teacher t1 = new BaseTeacher("张三", 25);
        t1.teach();
        System.out.println(t1.toString());
        Teacher t2 = new WorkTeacher("李四", 30);
        t2.teach();
        System.out.println(t2.toString());
    }
}