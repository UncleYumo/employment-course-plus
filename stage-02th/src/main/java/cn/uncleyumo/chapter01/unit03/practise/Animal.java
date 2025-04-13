package cn.uncleyumo.chapter01.unit03.practise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author uncle_yumo
 * @fileName Animal
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Getter
@Setter
@AllArgsConstructor
public class Animal {
    private String breed;
    private Integer age;
    public void action() {
        System.out.println("动物做动作");
    }
}

class Whale extends Animal {
    public Whale(String breed, Integer age) {
        super(breed, age);
    }

    @Override
    public void action() {
        System.out.println(getAge() + "岁的" + getBreed() + "在正在吃东西");
    }
}

class Dog extends Animal {
    public Dog(String breed, Integer age) {
        super(breed, age);
    }

    @Override
    public void action() {
        System.out.println(getAge() + "岁的" + getBreed() + "在正在吃东西");
    }
}

class AnimalTest {
    public static void main(String[] args) {
        Whale whale = new Whale("虎鲸", 2);
        whale.action();
        Dog dog = new Dog("柴犬", 3);
        dog.action();
    }
}