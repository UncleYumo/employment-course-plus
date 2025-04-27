package cn.uncleyumo.chapter06.unit04;

import cn.uncleyumo.utils.LogPrinter;

import java.io.*;
import java.util.List;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test02
 * @createDate 4/27/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */
public class Test02 {
    private static final String staticPath = cn.uncleyumo.chapter06.unit02.Test01.getStaticPath();

    public static void main(String[] args) {
        practise03();
    }

    private static void practise03() {
        try (Writer fw = new FileWriter(staticPath + "a.txt")) {
            fw.write("你好！\r\n中国！".toCharArray());
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise02() {
        try (Reader fr = new FileReader(staticPath + "a.txt")) {
            char[] buffer = new char[3];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                System.out.print(new String(buffer,  0, len));
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise01() {
        try (Reader fr = new FileReader(staticPath + "a.txt")) {
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print(
                        (char) c + "(" + c + ")"
                );
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    /**
     * 自动拼接路径分隔符
     */
    public static String autoSeparator(List<String> paths) {
        return paths.stream().reduce("", (a, b) -> a + File.separator + b) + File.separator;
    }
}
