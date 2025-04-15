package cn.uncleyumo.chapter01.unit05.practise;

/**
 * @author uncle_yumo
 * @fileName Demo01
 * @createDate 2025/4/15 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Demo01 implements Inter {
    public static void main(String[] args) {
        new Demo01().method();
    }

    @Override
    public void method() {
        System.out.println("Inter.num = " + Inter.num);
    }
}

interface Inter {
    int num = 10;
    void method();
}
