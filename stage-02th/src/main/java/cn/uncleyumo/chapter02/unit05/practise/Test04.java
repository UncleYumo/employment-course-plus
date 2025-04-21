package cn.uncleyumo.chapter02.unit05.practise;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test04
 * @createDate 4/21/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test04 {
    public static void main(String[] args) {
        practise03();
    }

    /**
     * 公司要根据年份和周数确定生产计划，请编写一个程序，实现一个根据年份和周数自动计算日期的计算器
     * ①使用Calendar类和SimpleDateFormat类
     * ②根据用户输入的年份和周数，计算出该周的周一和周日的日期
     * ③并输出格式为"yyyy-MM-dd"的日期字符串。
     * 提示：java里面星期日是一周的开始 ????????????你不早说？？？？？？靠！！！！！！！！！！！！
     */
    private static void practise03() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份和周数（格式为yyyy-ww）：");
        String input = scanner.nextLine();
        String[] split = input.split("-");
        try {
            int year = Integer.parseInt(split[0]);
            int week = Integer.parseInt(split[1]);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.WEEK_OF_YEAR, week);
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            Date monday = calendar.getTime();
            calendar.add(Calendar.DAY_OF_WEEK, -1);
            Date sunday = calendar.getTime();
            System.out.println("周一的日期：" + new SimpleDateFormat("yyyy-MM-dd").format(monday));
            System.out.println("周日的日期：" + new SimpleDateFormat("yyyy-MM-dd").format(sunday));
            scanner.close();
        } catch (Exception e) {
            System.out.println("输入错误，请重新输入！");
        }
    }

    /**
     * 公司周日周一要求必须有两个人值班，现在要进行排班，编写一个程序，实现一个星期计算器，计算出某个日期的周日和周一是哪一天。
     * ①要求使用Calendar类和SimpleDateFormat类
     * ②根据用户输入的日期字符串，计算出该日期所在周的周一和周日的日期
     * ③并输出格式为"yyyy-MM-dd"的日期字符串。
     * 提示：java里面星期日是一周的开始
     */
    @SneakyThrows
    private static void practise02() {
        // 1-2 实现周日和周一的计算
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个日期（格式为yyyy-MM-dd）：");
        String inputDate = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(inputDate);
        // 打印当前日期
        System.out.println("当前日期：" + dateFormat.format(date));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 根据周几计算出周一和周日的日期
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                calendar.add(Calendar.DAY_OF_MONTH, -6);
                break;
            case Calendar.MONDAY:
                break;
            case Calendar.TUESDAY:
                calendar.add(Calendar.DAY_OF_MONTH, -1);
                break;
            case Calendar.WEDNESDAY:
                calendar.add(Calendar.DAY_OF_MONTH, -2);
                break;
            case Calendar.THURSDAY:
                calendar.add(Calendar.DAY_OF_MONTH, -3);
                break;
            case Calendar.FRIDAY:
                calendar.add(Calendar.DAY_OF_MONTH, -4);
                break;
            case Calendar.SATURDAY:
                calendar.add(Calendar.DAY_OF_MONTH, -5);
                break;
        }
        // 获取周一的日期字符串
        Date mondayDate = calendar.getTime();
        String mondayDateStr = dateFormat.format(mondayDate);
        System.out.println("周一的日期：" + mondayDateStr);
        // 获取周日的日期字符串
        calendar.add(Calendar.DAY_OF_MONTH, 6);
        Date sundayDate = calendar.getTime();
        String sundayDateStr = dateFormat.format(sundayDate);
        System.out.println("周日的日期：" + sundayDateStr);
        scanner.close();
    }

    /**
     * 编写一个程序，实现日期、时间的格式化功能
     * ①使用Date类和Calendar类输出当前日期格式为"yyyy-MM-dd HH:mm:ss"。
     * ②计算在当前日期的基础上加上10天后的日期，格式为"yyyy-MM-dd HH:mm:ss"。
     */
    private static void practise01() {
        // ①使用Date类和Calendar类输出当前日期格式为"yyyy-MM-dd HH:mm:ss"。
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);
        System.out.println("当前日期: " + formattedDate);

        // ②计算在当前日期的基础上加上10天后的日期，格式为"yyyy-MM-dd HH:mm:ss"。
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Date futureDate = calendar.getTime();
        String formattedFutureDate = dateFormat.format(futureDate);
        System.out.println("10天后的日期: " + formattedFutureDate);
    }
}
