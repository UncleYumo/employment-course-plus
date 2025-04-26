package cn.uncleyumo.chapter06.unit02;

import cn.uncleyumo.utils.LogPrinter;
import lombok.Getter;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static cn.uncleyumo.chapter06.unit01.Test01.autoSeparator;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/26/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {

    @Getter
    public static String staticPath = System.getProperty("user.dir") + autoSeparator(List.of("stage-02th", "src", "main", "resources", "static"));
    public static Boolean flag = false;

    public static void main(String[] args) {
        practise06();
    }

    @SneakyThrows  // To ignore the exception
    private static void practise06() {
        File file = new File(staticPath + "test0.txt");
        if (!file.exists()) {
            System.out.println("File isn't exist!");
            return;
        }
        @SuppressWarnings("resource")
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = inputStream.readAllBytes();
        for (byte b : bytes) {
            System.out.print((char) b);
        }
    }

    private static void practise05() {
        List<Integer> byteList = List.of(97, -26, -120, -111, 98);
        // list to byte array
        byte[] byteArray = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            byteArray[i] = byteList.get(i).byteValue();
        }
        System.out.println(Arrays.toString(byteArray));
        System.out.println(new String(byteArray, StandardCharsets.UTF_8));
    }

    private static void practise04() {
        String data = "a我b";
        byte[] bytes = data.getBytes();
        System.out.println(Arrays.toString(bytes));
        @SuppressWarnings("OptionalGetWithoutIsPresent")
        String maxLengthKey = Charset.availableCharsets()
                .keySet().stream()
                .max(Comparator.comparing(String::length))
                .get();
        Charset.availableCharsets()
                .forEach((k, v) -> System.out.println(String.format("%-" + maxLengthKey.length() + "s", k) + "\t:" + v));
    }


    private static void practise03() {
        searchFile(new File(staticPath), "test10.txt");
    }

    /**
     * Search the specified file in the target directory
     *
     * @param dir      The target directory
     * @param fileName The specified file name
     */
    private static void searchFile(File dir, String fileName) {
        if (flag) return;
        if (dir == null || !dir.exists() || !dir.isDirectory()) {
            LogPrinter.INSTANCE.error("The target dir is not correct");
            return;
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().contains(fileName)) {
                        LogPrinter.INSTANCE.warn("Found " + fileName + " in: " + file.getAbsolutePath());
                        flag = true;
                        return;
                    } else {
                        LogPrinter.INSTANCE.info("Not match: " + file.getAbsolutePath());
                    }
                } else {
                    searchFile(file, fileName);
                }
            }
        }
    }

    private static int practise02(int n) {
        if (n == 1) {
            System.out.print(n);
            return 1;
        }
        ;
        System.out.print(n + " * ");
        return n * practise02(n - 1);
    }

    private static void practise01(List<Integer> list) {
        if (list.size() > 10) {
            System.out.println("Max: " + list.stream().max(Integer::compareTo).get());
            return;
        }
        ;
        System.out.println(list);
        list.add((int) (Math.random() * 100 + 1));
        practise01(list);
    }
}
