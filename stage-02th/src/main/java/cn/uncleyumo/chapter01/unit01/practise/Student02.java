package cn.uncleyumo.chapter01.unit01.practise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author uncle_yumo
 * @fileName Student02
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student02 {
    private String name;
    private int age;
    private int yuwen;
    private int shuxue;
    private static String banji = "尊享无忧班级";

    public static void study() {
        System.out.println("好好学习，天天向上");
    }

    @Override
    public String toString() {
        if (name == null || name.isEmpty() || age == 0 || yuwen == 0 || shuxue == 0) {
            return "学生信息不完整";
        }
        return name + "，" + age + "岁，语文成绩：" + yuwen + "，数学成绩：" + shuxue + "，班级：" + banji;
    }
}
