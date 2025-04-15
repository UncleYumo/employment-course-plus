package cn.uncleyumo.chapter01.unit05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uncle_yumo
 * @fileName ClassManager
 * @createDate 2025/4/15 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
public class ClassManager {
    private List<Student> students = new ArrayList<>();
    private StudentOperator operator = new StudentOperatorImpl02();
//    private StudentOperator operator = new StudentOperatorImpl02();

    public ClassManager() {
        students.add(new Student("Tom", '女', 99));
        students.add(new Student("Jerry", '男', 100));
        students.add(new Student("Lily", '女', 80));
        students.add(new Student("Lucy", '男', 60));
        students.add(new Student("Mike", '男', 60));
    }

}
