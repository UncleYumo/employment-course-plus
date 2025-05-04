package cn.uncleyumo.chapter08.unit01.parctise;

import cn.uncleyumo.utils.LogPrinter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 5/4/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class MyThread extends Thread {
    public MyThread(@NotNull String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000L);
            for (int i = 0; i <= 9; i++) {
                LogPrinter.INSTANCE.info(this.getName() + i);
                Thread.sleep(10L);
            }
        } catch (InterruptedException e) {
            LogPrinter.INSTANCE.error(this.getName() + e.getMessage());
        }
    }
}

public class Test01 {
    public static void main(String[] args) {
        practise03();
    }

    /**
     * 通过实现Runnable接口的形式创建线程，实现如下要求：
     * 1.每隔3秒打印当前线程的名称和当前的时间戳，打印10次
     * 2.设置线程名称为：测试线程
     * 3.在测试方法中等待线程执行结束
     */
    private static void practise03() {
        new Thread(() -> {
            LogPrinter.INSTANCE.info(
                    Thread.currentThread().getName() + " Start..."
            );
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    LogPrinter.INSTANCE.error(e.getMessage());
                }
                LogPrinter.INSTANCE.info("Current Thread: " + Thread.currentThread().getName());
            }
            LogPrinter.INSTANCE.info(
                    Thread.currentThread().getName() + " End..."
            );
        }, "测试线程").start();
    }

    /**
     * 创建一个测试类，观察线程的start（）和run（）方法的区别
     * ①创建一个类，继承Thread类，并重写里面的run()方法，实现在睡眠5s后控制台输出0-9
     * ②在测试类中，创建两个线程，分别调用run()方法，和启动两条线程
     */
    private static void practise02() {
        new MyThread("MyThread01\t").run();  // 非线程启动，阻塞调用方
        new MyThread("MyThread02\t").start();  // 线程启动，非阻塞调用方
//        new MyThread("MyThread01\t").start();
//        new MyThread("MyThread02\t").start();
    }

    /**
     * 创建一个测试类，模拟定时任务功能
     * ①使用实现Callable接口接口的方式创建一个线程
     * ②重写call()方法，在方法中每3秒在控制台输出 当前时间戳，输出10次进程停止
     * ③在主方法中启动该线程，
     */
    private static void practise01() {
        LogPrinter.INSTANCE.info("Start practise01");
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            Thread.sleep(1000L);
            return "Data of FutureTask(Callable)";
        });
        new Thread(futureTask).start();
        try {
            String call = futureTask.get();
            LogPrinter.INSTANCE.info("Get Call: " + call);
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}
