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
        practise08();
    }

    private static void practise08() {
        try (
                InputStream is = new FileInputStream(staticPath + "c.txt");
                OutputStream os = new FileOutputStream(staticPath + "e.txt")
        ) {
            while (is.available() > 0) {
                os.write(is.read());
            }
            os.flush();
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise07() {
        try (
                InputStream is = new FileInputStream(staticPath + "c.txt")
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise06() {
        try (
                InputStream is = new FileInputStream(staticPath + "c.txt")
        ) {
            while (is.available() > 0) {
                System.out.print(is.read() + " ");
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise05() {
        try (
                OutputStream os = new FileOutputStream(staticPath + "c.txt", true);
                InputStream is = new FileInputStream(staticPath + "c.txt")
        ) {
            for (int i = 0; i < 5; i++) {
                os.write("I love Golang\r\n".getBytes());
            }
            os.flush();
//            while (is.available() > 0) {
//                System.out.print((char) is.read());
//            }
            byte[] buffer = new byte[1042];
            int len;
            while ((len = is.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise04() {
        try (
                OutputStream os = new FileOutputStream(staticPath + "a.txt")
        ) {
            os.write("a".getBytes());
            os.flush();
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise03() {
        try (
                OutputStream os = new FileOutputStream(staticPath + "a.txt")
        ) {
            os.write('a');
            os.flush();
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
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
                InputStream bis = new BufferedInputStream(fileInputStream);
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
