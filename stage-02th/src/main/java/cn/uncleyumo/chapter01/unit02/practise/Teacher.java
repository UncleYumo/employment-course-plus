package cn.uncleyumo.chapter01.unit02.practise;

import lombok.*;

/**
 * @author uncle_yumo
 * @fileName Teacher
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Person {
    private String subject;
    public void teach() {
        System.out.println(getName() + "老师正在教授" + subject);
    }
}
