package cn.uncleyumo.chapter04.practise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dev.uncleyumo.cn
 * @fileName ExaminationManagementSystem
 * @createDate 4/25/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class ExaminationManagementSystem {
    public static void main(String[] args) {
        Map<Student, Integer> stuMap = new HashMap<>(Map.of(
                new Student("张三"), 100,
                new Student("李四"), 90,
                new Student("王五"), 80
        ));
        System.out.println("------------------------------------------------");
        stuMap.forEach((student, score) -> {
            System.out.println(student.getName() + "'s score is " + score);
        });
        System.out.println("------------------------------------------------");
        for (Map.Entry<Student, Integer> studentIntegerEntry : stuMap.entrySet()) {
            System.out.println(studentIntegerEntry.getKey().getName() + "'s score is " + studentIntegerEntry.getValue());
        }
        System.out.println("------------------------------------------------");
        System.out.println("Is student '李四' in the map?" + stuMap.containsKey(new Student("李四")));
        System.out.println("Is student '赵六' in the map?" + stuMap.containsKey(new Student("赵六")));
        System.out.println("------------------------------------------------");
        System.out.println("student '李四' score is " + stuMap.get(new Student("李四")));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private String name;
}