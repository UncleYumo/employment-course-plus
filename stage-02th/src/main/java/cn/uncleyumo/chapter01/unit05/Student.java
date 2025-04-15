package cn.uncleyumo.chapter01.unit05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author uncle_yumo
 * @fileName Student
 * @createDate 2025/4/15 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private char sex;
    private double score;
}
