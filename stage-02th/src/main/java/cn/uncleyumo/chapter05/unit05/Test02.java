package cn.uncleyumo.chapter05.unit05;

import lombok.Data;

import java.util.*;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test02
 * @createDate 4/25/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test02 {
    public static void main(String[] args) {
        practise();
    }

    private static void practise() {
        Map<String, Integer> map = new HashMap<>(Map.of(
                "A", 0,
                "B", 0,
                "C", 0,
                "D", 0
        ));
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            students.add(new Student());
        }
        students.forEach(student -> {
            switch (student.getChoice()) {
                case 1:
                    map.put("A", map.get("A") + 1);
                    break;
                case 2:
                    map.put("B", map.get("B") + 1);
                    break;
                case 3:
                    map.put("C", map.get("C") + 1);
                    break;
                case 4:
                    map.put("D", map.get("D") + 1);
                    break;
            }
        });
        System.out.println(map);
        students.forEach(stu -> System.out.println(stu.getName() + " - " + stu.getChoice()));
    }
}

@Data
class Student {
    private String name;
    private int choice;
    public Student() {
        this.name = UUID.randomUUID().toString().substring(0, 8);
        this.choice = (int) (Math.random() * 4) + 1;
    }
}