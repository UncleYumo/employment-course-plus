package cn.uncleyumo.chapter06.unit04.practise;

import cn.uncleyumo.utils.LogPrinter;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 4/27/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */
public class Test01 {
    private static final String staticPath = cn.uncleyumo.chapter06.unit02.Test01.getStaticPath();

    public static void main(String[] args) {
        practise02();
    }

    /**
     * 我们在开发过程中，为了保证来自键盘录入的信息不丢失，我们经常会使用字符流将来自键盘录入的信息进行保存到本地实现永久化存储，
     * 请按照以下要求模拟该过程：
     *  ①创建一个测试类，在测试类中通过Scanner实现键盘录入
     *  ②使用字符流将键盘录入的信息存储到本地文件中
     */
    private static void practise02() {
        try (Writer writer = new FileWriter(staticPath + "scanner.txt")) {
            Scanner scanner = new Scanner(System.in);
            String input = "";
            while (!":wq".equals(input)) {
                System.out.print(">>");
                if ("".equals(input)) {
                    input = scanner.nextLine();
                    continue;
                }
                writer.write((LocalDateTime.now() + "\t" + input + "\r\n").toCharArray());
                writer.flush();
                input = scanner.nextLine();
            }
            System.out.println("System Exit!");
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    /**
     * 在程序开发过程中，有些功能需要对文件进行备份，请在测试类中模拟该过程：
     *  ①将上一单元作业中创建的文本文件b.txt复制一份存储到当前项目下，并命名为c.txt
     *  ②使用try-catch-finally进行释放资源
     */
    private static void practise01() {
        try (
                InputStream is = new FileInputStream(staticPath + "b.txt");
                OutputStream os = new FileOutputStream(staticPath + "c.txt")
        ) {
            byte[] bytes = new byte[4];
            int len;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}
