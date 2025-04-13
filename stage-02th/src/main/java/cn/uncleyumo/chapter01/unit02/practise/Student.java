package cn.uncleyumo.chapter01.unit02.practise;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author uncle_yumo
 * @fileName Student
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Getter
@Setter
public class Student extends Person {
    private Integer grade;
    public void exam() {
        System.out.println(getName() + "学生考试得了：" + grade);
    }
}
