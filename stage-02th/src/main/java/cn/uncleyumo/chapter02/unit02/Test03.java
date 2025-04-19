package cn.uncleyumo.chapter02.unit02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author uncle_yumo
 * @fileName Test03
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 * 编写一个测试类
 * ① 演示 Object 类中的 equals 方法、toString 方法
 * ② 演示 Person 类（属性：name,age） 重写Object中的 equals 方法、toString 方法和 clone 方法，并在测试类中进行演示
 * ③ 演示 Objects 类中的 equals 方法、isNull 方法和 nonNull 方法的使用
 */

public class Test03 {
    public static void main(String[] args) {
        // ① Object 类中的 equals 方法、toString 方法
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1.equals(obj2)); // false
        System.out.println(obj1.toString()); // java.lang.Object@1b6d97b9

        // ② Person 类（属性：name,age） 重写Object中的 equals 方法、toString 方法和 clone 方法，并在测试类中进行演示
        PersonOverride person1 = new PersonOverride("Tom", 20);
        PersonOverride person2 = new PersonOverride("Tom", 20);
        System.out.println(person1.equals(person2)); // true
        System.out.println(person1.toString()); // PersonOverride{name='Tom', age=20}

        // ③ Objects 类中的 equals 方法、isNull 方法和 nonNull 方法的使用
        String str1 = "Hello";
        String str2 = "World";
        System.out.println(Objects.equals(str1, str2)); // false
        System.out.println(Objects.isNull(str1)); // false
        System.out.println(Objects.nonNull(str1)); // true
        System.out.println(Objects.isNull(null)); // true
        System.out.println(Objects.nonNull(null)); // false

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person {
    private String name;
    private int age;
}

@Data
@AllArgsConstructor
class PersonOverride {
    private String name;
    private int age;

    public PersonOverride() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
