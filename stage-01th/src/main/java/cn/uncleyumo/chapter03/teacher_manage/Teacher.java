package cn.uncleyumo.chapter03.teacher_manage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author uncle_yumo
 * @fileName Teacher
 * @createDate 2025/4/9 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher implements Serializable {
    private String id;
    private String name;
    private int age;
    private String birthday;
}
