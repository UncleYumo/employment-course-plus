package cn.uncleyumo.chapter02.unit05.practise;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author uncle_yumo
 * @fileName Test10
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 * 定义一个动物类，有品种、年龄(age)等属性，用吃食物等行为
 * ①在动物类的子类，鲸鱼和狗（需重写吃食物的方法）
 * ②定义一个测试类，创建鲸鱼和狗对象，并分别调用eat方法，把信息输出到控制台
 */

public class Test10 {
    public static void main(String[] args) {
        testEat(new Animal("鲸鱼", 10) {
            @Override
            public void eat() {
                System.out.println(getAge() + "岁的" + getVariety() + "正在吃鱼肉");
            }
        });
        testEat(new Animal("狗", 5) {
            @Override
            public void eat() {
                System.out.println(getAge() + "岁的" + getVariety() + "正在吃骨头");
            }
        });
    }
    private static void testEat(Animal animal) {
        animal.eat();
    }
}

@Data
@AllArgsConstructor
abstract class Animal {
    private String variety;
    private int age;
    private Animal() {}
    public abstract void eat();
}