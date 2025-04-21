package cn.uncleyumo.chapter02.unit03;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/20/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static void main(String[] args) {
        practise04();
    }

    /**
     * 4.
     * 某共公司产品经理要求App需要有3款主题样式，用户选择不同的主题，展示时间的格式也要有不同的风格，请编写代码实现该功能。
     * 运行结果：
     * 请选择主题：1.xxxx年xx月xx日，2.xxxx-xx-xx，3.xxxx/xx/xx
     * 1
     * 主题切换成功,当前时间为：2018年12月10日
     *
     * 请选择主题：1.xxxx年xx月xx日，2.xxxx-xx-xx，3.xxxx/xx/xx
     * 4
     * 很抱歉，操作有误，已为您切换默认主题
     * 主题切换成功,当前时间为：2018年12月10日
     */
    private static void practise04() {
        List<String> dataFormatList = List.of("yyyy年MM月dd日", "yyyy-MM-dd", "yyyy/MM/dd");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("请选择主题：1.%s，2.%s，3.%s%n", dataFormatList.get(0), dataFormatList.get(1), dataFormatList.get(2));
            String choice = scanner.nextLine();
            try {
                int choiceInt = Integer.parseInt(choice);
                if (choiceInt < 0 || choiceInt > 3) {
                    System.out.println("很抱歉，操作有误，已为您切换默认主题");
                    choiceInt = 1;
                }
                if (choiceInt == 0) {
                    System.out.println("即将退出系统");
                    break;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dataFormatList.get(choiceInt - 1));
                System.out.printf("主题切换成功,当前时间为：%s%n", simpleDateFormat.format(new Date()));
            } catch (Exception e) {
                System.out.println("很抱歉，操作有误，已为您切换默认主题");
            }
        }
    }

    /**
     * 3.
     * 请编写程序，获取当前系统日期，并将结果打印到控制台，要求展示格式为：xxxx年xx月xx日
     * 运行结果：
     * 2088年2月15日
     */
    private static void practise03() {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(simpleDateFormat.format(time));
    }

    /** 获取当前的日期,并把这个日期转换为指定格式的字符串,如2088-08-08 08:08:08。*/
    public static void practise01() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
    }

    /** 使用SimpleDateFormat类,把2018-03-04转换为2018年03月04日 */
    public static void practise02() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse("2018-03-04");
            simpleDateFormat.applyPattern("yyyy年MM月dd日");
            System.out.println(simpleDateFormat.format(date));
        } catch (Exception e) {
            System.out.println("格式错误");
        }
    }
}