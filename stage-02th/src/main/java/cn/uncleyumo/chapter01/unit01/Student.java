package cn.uncleyumo.chapter01.unit01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author uncle_yumo
 * @fileName Student
 * @createDate 2025/4/11 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    public static String NAME;
    private int age;
    private String gender;
}

class TestStudent {
    public static void main(String[] args) {
        Student.NAME = "Tom";
        Student student01 = new Student();
        System.out.println("student01.NAME = " + Student.NAME);
        Student student02 = new Student();
        System.out.println("student02.NAME = " + Student.NAME);
        Student.NAME = "Jerry";
        System.out.println("student01.NAME = " + Student.NAME);
        System.out.println("student02.NAME = " + Student.NAME);
    }
}