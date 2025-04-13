package cn.uncleyumo.chapter01.unit02.practise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author uncle_yumo
 * @fileName Person
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable {
    private String name;
    private Integer age;

    public void showMsg() {
        System.out.println("姓名" + name + "，年龄" + age);
    }
}
