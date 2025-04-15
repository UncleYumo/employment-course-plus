package cn.uncleyumo.chapter01.unit05.practise;

/**
 * @author uncle_yumo
 * @fileName Demo02
 * @createDate 2025/4/15 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Demo02 {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.powerOn();
        laptop.powerOff();
        laptop.enable();
        laptop.disable();
    }
}


/**
 * USB接口类：（开启功能）、（关闭功能）
 */
interface USBInterface {
    void enable();
    void disable();
}

/**
 * 笔记本类：（开机功能）、（关闭功能）
 */
class Laptop extends Mouse {
    void powerOn() {
        System.out.println("笔记本开机");
    }

    void powerOff() {
        System.out.println("笔记本关闭");
    }
}

/**
 * 鼠标类：要符合USB接口规范
 */
class Mouse implements USBInterface {

    @Override
    public void enable() {
        System.out.println("连接鼠标的USB");
    }

    @Override
    public void disable() {
        System.out.println("断开鼠标的USB");
    }
}