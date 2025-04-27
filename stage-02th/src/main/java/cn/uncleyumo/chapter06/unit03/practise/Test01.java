package cn.uncleyumo.chapter06.unit03.practise;

import cn.uncleyumo.utils.LogPrinter;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 4/27/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    static String staticPath = System.getProperty("user.dir") + autoSeparator(List.of("stage-02th", "src", "main", "resources", "static"));

    public static void main(String[] args) {
        practise02();
    }

    /**
     * 为了保障通信安全，我们会将想要发送的信息进行加密处理：
     * ①现在同学A接收到了同学B发过来的加密文件，已知加密方式是将每个字符对应码表中数字的值+3.
     * ②请你将如下内容进行解密并打印在控制台
     * ③在当前项目下创建b.txt文件，文件中内容为：L#oryh#|rx#qrw#iru#zkr#|rx#duh/exw#iru#zkr#L#dp#zlwk#|rx1
     */
    private static void practise02() {
        File file = new File(staticPath + "b.txt");
        try (InputStream is = new FileInputStream(file)) {
            List<Integer> byteList = new ArrayList<>();
            byte[] bytes = new byte[4];
            int len;
            while ((len = is.read(bytes)) != -1) {
                for (int i = 0; i < len; i++) {
                    byteList.add(bytes[i] - 3);
                }
            }
            byteList.forEach(b -> {
                System.out.print((char) (int) b);
            });
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    /**
     * 在当前项目下编写一个a.txt文本，在其中添加内容I Love China ，编写一个测试类
     * 读取文件中内容，并将结果打印在控制台
     */
    @SuppressWarnings({"ResultOfMethodCallIgnored"})
    @SneakyThrows
    private static void practise01() {
        File file = new File(staticPath + "a.txt");
        file.createNewFile();
        // write content to file
        OutputStream fileOutputStream = new FileOutputStream(file, true);
        fileOutputStream.write("I Love China".getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        InputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fileInputStream.close();
    }

    /**
     * 自动拼接路径分隔符
     */
    public static String autoSeparator(List<String> paths) {
        return paths.stream().reduce("", (a, b) -> a + File.separator + b) + File.separator;
    }
}
