package cn.uncleyumo.chapter01.unit04;

import lombok.Getter;
import lombok.Setter;

/**
 * @author uncle_yumo
 * @fileName Test02
 * @createDate 2025/4/11 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Test02 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        run(teacher);
    }
    public static void run(People o) {
        if (o instanceof Student) {
            Student student = (Student) o;
            student.go();
            return;
        }
        if (o instanceof Teacher) {
            Teacher teacher = (Teacher) o;
            teacher.go();
            return;
        }
        o.go();
    }
}

@Getter
@Setter
class People {
    String name;
    int age;
    public void go() {
        System.out.println("----------开始----------");
        System.out.println("People go");
        System.out.println("----------结束----------");
    }
}

class Student extends People {
    @Override
    public void go() {
        System.out.println("----------开始----------");
        System.out.println("Student go");
        System.out.println("----------结束----------");
    }
}

class Teacher extends People {
    @Override
    public void go() {
        System.out.println("----------开始----------");
        System.out.println("Teacher go");
        System.out.println("----------结束----------");
    }
}