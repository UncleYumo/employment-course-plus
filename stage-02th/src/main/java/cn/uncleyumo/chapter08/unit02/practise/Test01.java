package cn.uncleyumo.chapter08.unit02.practise;

import cn.uncleyumo.utils.LogPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 5/5/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class RedPacket implements Runnable {
    private final List<Integer> packets = new ArrayList<>();

    public RedPacket() {
        for (int i = 0; i < 3; i++) {
            packets.add(20);
        }
        LogPrinter.INSTANCE.info("红包初始化完成，红包剩余数量为：" + packets.size());
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    if (!packets.isEmpty()) {
                        LogPrinter.INSTANCE.debug("恭喜" + Thread.currentThread().getName() + ", 你成功抢到一个" + packets.remove(0) + "元红包");
                        Thread.sleep(10L);
                    } else {
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}

public class Test01 {
    public static void main(String[] args) {
        practise02();
    }

    /**
     * 某家庭聚会组织了"抢红包"的活动，现在某家庭成员打算发3个定额红包[3个20元红包]，现由5个家庭成员进行快抢，请使用多线程模拟该活动！
     * ①定义一个类，实现Runnable接口
     * ②在该类中定义一个int类型的变量，初始值为3，表示3个红包
     * ③重写Runnable接口中的run方法run方法的实现逻辑如下所示：
     * -判断红包的总数量是否大于0，如果是在控制台输出"恭喜xxx，你成功抢到一个20元的红包"，红包总数量减一
     * -如果红包的总数量小于等于0，此时在控制台输出"xxx抱歉，红包已经被抢完了"
     * ④在测试类中创建5个线程模拟5个家庭成员，并分别命名为“黄蓉”，“郭靖”，“黄药师”，“周伯通”，“瑛姑”。
     * ⑤在测试类中启动5个线程
     */
    private static void practise02() {
        RedPacket redPacket = new RedPacket();
        new Thread(redPacket, "黄蓉").start();
        new Thread(redPacket, "郭靖").start();
        new Thread(redPacket, "黄药师").start();
        new Thread(redPacket, "周伯通").start();
        new Thread(redPacket, "瑛姑").start();
    }

    /**
     * 某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
     * ①定义一个类SellTicket实现Runnable接口，里面定义一个成员变量：private int tickets = 100;
     * ②在SellTicket类中重写run()方法实现卖票，代码步骤如下
     * ③判断票数大于0，就卖票，并告知是哪个窗口卖的，卖了票之后，总票数要减1，票卖没了，线程停止
     * ④定义一个测试类SellTicketDemo，里面有main方法，代码步骤如下
     * ⑤创建SellTicket类的对象，创建三个Thread类的对象，把SellTicket对象作为构造方法的参数，并给出对应的窗口名称，启动线程
     */
    private static void practise01() {
        SellTicket sellTicket = new SellTicket();
        Thread thread1 = new Thread(sellTicket, "窗口1");
        Thread thread2 = new Thread(sellTicket, "窗口2");
        Thread thread3 = new Thread(sellTicket, "窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class SellTicket implements Runnable {
    private int tickets = 100;
    private boolean isSoldOut = false;

    @Override
    public void run() {
        while (!isSoldOut) {
            sellTicket(Thread.currentThread().getName());
        }
    }

    public void sellTicket(String threadName) {
        try {
            synchronized (this) {
                if (tickets > 0) {
                    tickets--;
                    Thread.sleep(10L);
                    LogPrinter.INSTANCE.debug(threadName + "卖出一张票，剩余票数为：" + tickets);
                } else {
                    LogPrinter.INSTANCE.info(threadName + "票已卖完");
                    isSoldOut = true;
                }
            }
        } catch (InterruptedException e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}