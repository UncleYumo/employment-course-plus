package cn.uncleyumo.chapter06.unit05.practise;

import cn.uncleyumo.utils.LogPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static cn.uncleyumo.chapter06.unit04.Test02.autoSeparator;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 4/28/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */
public class Test01 {
    public static String staticPath = System.getProperty("user.dir") + autoSeparator(List.of("stage-02th", "src", "main", "resources", "static"));

    public static void main(String[] args) {
        practise02();
    }

    /**
     * 设计一个程序，模拟随机点名器
     * ①创建一个stu.txt，在文件中填入一些学生名字，每个学生名字单独一行
     * ②在主方法中读取文件内容，将学生信息保存到集合中
     * ③生成一个随机数，作为集合元素的索引
     * ④根据该索引从集合中获取一个员工姓名，并将该员工从集合中移除掉
     * ⑤将集合中剩余的员工姓名通过BufferedWriter再一次写入到stu.txt文件中
     */
    private static void practise02() {
        List<String> newNameList = new ArrayList<>();
        try (Reader reader = new FileReader(staticPath + "stu.txt"); BufferedReader br = new BufferedReader(reader)) {
            List<String> nameList = br.lines().toList();
            LogPrinter.INSTANCE.info("nameList: " + nameList);
            int randomIndex = (int) (Math.random() * nameList.size());
            for (int i = 0; i < nameList.size(); i++) {
                if (i == randomIndex) {
                    LogPrinter.INSTANCE.info("Name: " + nameList.get(i) + "(" + i + ") is about to be removed!");
                    continue;
                }
                newNameList.add(nameList.get(i));
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }

        try (Writer writer = new FileWriter(staticPath + "stu.txt"); BufferedWriter bw = new BufferedWriter(writer);) {
            bw.write("++");
            bw.write(String.join("\n++", newNameList));
            bw.flush();
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    /**
     * 设计一个程序，使用字符缓冲输入流读取文件内容并打印到控制台，要求如下：
     * 1.创建一个a.txt,在里面填充古诗内容《静夜思》
     * 2.在测试类中实现将该文件中内容打印到控制台
     */
    private static void practise01() {
        try (BufferedReader bis = new BufferedReader(new FileReader(staticPath + "a.txt"))) {
            bis.lines().forEach(System.out::println);
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}
