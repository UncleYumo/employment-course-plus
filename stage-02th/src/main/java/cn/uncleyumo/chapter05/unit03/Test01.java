package cn.uncleyumo.chapter05.unit03;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/24/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static void main(String[] args) {
        practise01();
    }

    private static void practise02() { }

    /**
     * 定义人类，包含姓名和年龄属性。创建4个人存储到HashSet中，姓名和年龄相同的人看做同一人不存储
     */
    private static void practise01() {
        Set<Human> set = new HashSet<>();
        Collections.addAll(set,
            new Human("张三", 18),
            new Human("李四", 19),
            new Human("张三", 17),
            new Human("李四", 19)
        );
        set.forEach(System.out::println);
    }
}

@Getter
@Setter
@ToString
class Human {
    private String name;
    private int age;

    private Human() { }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
