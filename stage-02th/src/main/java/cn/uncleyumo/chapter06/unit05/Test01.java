package cn.uncleyumo.chapter06.unit05;

import cn.uncleyumo.utils.LogPrinter;

import java.io.*;
import java.util.List;

import static cn.uncleyumo.chapter06.unit04.Test02.autoSeparator;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 4/27/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static String staticPath =
            System.getProperty("user.dir") +
                    autoSeparator(List.of("stage-02th", "src", "main", "resources", "static"));

    public static void main(String[] args) {
        practise02();
    }

    private static void practise02() {
        try (
                OutputStream outputStream = new FileOutputStream(staticPath + "a.txt");
                OutputStream bos = new BufferedOutputStream(outputStream);
        ) {
            List<String> stringList = List.of("Hello World\r\n", "Hello World\r\n", "Hello World\r\n");
            stringList.forEach(s -> {
                try {
                    bos.write(s.getBytes());
                } catch (IOException e) {
                    LogPrinter.INSTANCE.error(e.getMessage());
                }
            });
            bos.flush();
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise01() {
        try (
                InputStream fileInputStream = new FileInputStream(staticPath + "a.txt");
                OutputStream outputStream = new FileOutputStream(staticPath + "c.txt");
                InputStream bis = new BufferedInputStream(fileInputStream);
                OutputStream bos = new BufferedOutputStream(outputStream);
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                System.out.print(new String(buffer));
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}
