package cn.uncleyumo.chapter01.unit03.practise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author uncle_yumo
 * @fileName Person
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Setter
@Getter
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String address;
    public void info() {

    }
}

class Student extends Person {
    public Student(String name, Integer age, String address) {
        super(name, age, address);
    }

    @Override
    public void info() {
        System.out.println("我是学生：" + this.getName() + "，年龄：" + this.getAge() + "，地址：" + this.getAddress());
    }
}

class Teacher extends Person {
    public Teacher(String name, Integer age, String address) {
        super(name, age, address);
    }

    @Override
    public void info() {
        System.out.println("我是老师：" + this.getName() + "，年龄：" + this.getAge() + "，地址：" + this.getAddress());
    }
}

class PersonTest {
    public static void main(String[] args) {
        Student student = new Student("张三", 20, "北京");
        student.info();
        Teacher teacher = new Teacher("王五", 30, "深圳");
        teacher.info();
    }
}