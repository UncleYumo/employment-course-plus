package cn.uncleyumo.chapter03.practise.java;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author uncle_yumo
 * @fileName Student
 * @createDate 2025/4/8 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private int age;
}
