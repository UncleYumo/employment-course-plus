package cn.uncleyumo.chapter01.unit06;

import lombok.Data;

/**
 * @author uncle_yumo
 * @fileName Outer
 * @createDate 2025/4/15 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
public class Outer {
    private String age;

    @Data
    public class Inner {
        private String name;

        public void sayHello() {
            System.out.println("Hello, " + name + "!");
            System.out.println("I am " + age + " years old.");
        }
    }
}