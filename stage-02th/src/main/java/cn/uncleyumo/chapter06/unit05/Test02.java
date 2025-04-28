package cn.uncleyumo.chapter06.unit05;

import cn.uncleyumo.utils.ColorPrinter;
import cn.uncleyumo.utils.LogPrinter;

import java.io.*;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test02
 * @createDate 4/28/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test02 {
    public static String staticPath = Test01.staticPath;
    public static void main(String[] args) {
        practise02();
    }

    private static void practise02() {
        try (
                Writer writer = new FileWriter(staticPath + "a.txt");
                BufferedWriter bw = new BufferedWriter(writer)
        ) {
            bw.write("Huawei好呀Huawei美".toCharArray());
            bw.newLine();
            bw.write("华为给我增智慧".toCharArray());
            bw.flush();
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise01() {
        try (
                Reader fileReader = new FileReader(staticPath + "a.txt");
                BufferedReader br = new BufferedReader(fileReader)
        ) {
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println("---------------------------------------------");
            char[] buffer = new char[3];
            int len;
            while ((len = br.read(buffer)) != -1) {
                ColorPrinter.INSTANCE.printFontCyan(new String(buffer, 0, len));
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}
