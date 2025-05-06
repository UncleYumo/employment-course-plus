package cn.uncleyumo.chapter08.unit03.practise;

import cn.uncleyumo.utils.LogPrinter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 5/6/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static void main(String[] args) {
        practise02();
    }

    /**
     * 在提供的素材文件中(images-url.txt)20000条网络图片地址数据。
     * 在素材文件夹中还给大家提供了下载这些图片的代码(DownLoadImage01.java)。
     * 现运行这段代码可以实现网络图片的下载功能，但是该程序下载完这些图片需要消耗大约7分钟的时间，耗时较长。
     * 请分析该程序耗时的主要原因并在提供的素材(DownLoadImage02.java)的指定位置补全代码提高下载图片的效率。
     */
    private static void practise02() {

    }

    /**
     * 在开发过程中，为了提高执行效率，我们会使用线程中用于执行一系列任务；按照以下要求完成代码
     * ①在测试类中创建一个大小为3的线程池，并提交十个任务交给线程池执行
     * ②创建一个类实现Runnable 接口，重写run方法，在该方法中让线程睡眠2秒，并在睡眠前后打印分别打印一条信息
     */
    private static void practise01() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                5,
                8L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        for (int i = 0; i < 10; i++) {
            pool.execute(new MyRunnable(i + ""));
        }
    }

    static class MyRunnable implements Runnable {
        private final String msg;

        public MyRunnable(String msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " (Start) message = " + msg);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                LogPrinter.INSTANCE.error(e.getMessage());
            }
            System.out.println(Thread.currentThread().getName() + " (End)");
        }
    }
}
