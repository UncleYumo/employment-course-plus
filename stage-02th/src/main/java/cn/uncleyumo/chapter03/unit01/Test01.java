package cn.uncleyumo.chapter03.unit01;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/22/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static void main(String[] args) {
        Swimming swimming = () -> System.out.println("This is an anonymous inner Class");
        swimming.swim();

        Swimming swimming2 = () -> {
            System.out.println("This is an anonymous inner Class");
        };
        swimming2.swim();
    }
}

interface Swimming {
    void swim();
}
