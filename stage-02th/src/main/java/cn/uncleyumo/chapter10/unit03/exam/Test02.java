package cn.uncleyumo.chapter10.unit03.exam;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test02
 * @createDate 5/22/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 在开发过程中，使用线程池可以控制线程的并发数量，降低服务器压力。请按照如下要求模拟该过程：
 * ①在测试类中定义一个线程池，设置最大线程数为3，任务容器的容量为1 ,空闲线程的最大存在时间为20s，拒绝策略为AbortPolicy
 * ②提交5个任务，在控制台打印执行任务的线程名字
 */

class Project implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Test02 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                3,
                20,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        try {
            for (int i = 0; i < 5; i++) {
                pool.submit(new Project());
            }
        } catch (Exception e) {
            System.out.println("发生异常：" + e.getMessage());
        }
    }
}
