package cn.uncleyumo.chapter01.unit01.practise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author uncle_yumo
 * @fileName Student
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
public class Student {
    private String name;
    private int age = 15;
    private LocalDate birthday;

    private Student() {

    }

    public Student(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public static void study() {
        System.out.println("好好学习，天天向上");
    }

    @Override
    public String toString() {
        return String.format("%s，%d岁，生日：%d月%d日", name, age, birthday.getMonthValue(), birthday.getDayOfMonth());
    }
}
