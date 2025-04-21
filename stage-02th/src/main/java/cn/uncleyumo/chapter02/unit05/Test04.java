package cn.uncleyumo.chapter02.unit05;

/**
 * @author uncle_yumo
 * @fileName Test04
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 * 某手机需完成闹钟功能（通过匿名内部类方式），需要如下：
 * ①定义一个铃声接口Bell，里面有个ring方法。
 * ②定义一个手机类Cellphone，具有闹钟功能alarmClock，参数是Bell类型
 * ③定义一个测试类，来测试手机类的闹钟功能，通过匿名内部类 ( 对象 ) 作为参数，打印：懒猪起床了
 * ④再在测试类中通过匿名内部类 ( 对象 ) 作为参数，打印：小伙伴上课了
 */

public class Test04 {
    public static void main(String[] args) {
        new Cellphone().alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        new Cellphone().alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}

interface Bell {
    void ring();
}

class Cellphone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}


