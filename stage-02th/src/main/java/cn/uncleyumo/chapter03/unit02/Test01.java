package cn.uncleyumo.chapter03.unit02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/22/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static void main(String[] args) {
//        checkPhone();
//        checkEmail();
        crawlText();
    }

    private static void crawlText() {
        String raw = """
                -n uncleyumo -b branch
                -d https://github.com/uncleyumo/java-learning/tree/master/chapter03/unit02
                """.trim();
//        System.out.println(raw);
        Pattern crawlN = Pattern.compile("-n\\s+\\w{2,}");
        Pattern crawlB = Pattern.compile("-b\\s+\\w{2,}");
        Pattern crawlD = Pattern.compile("-d\\s+\\w{2,}");
        Matcher matcher = crawlN.matcher(raw);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    private static void checkPhone() {
        while (true) {
            System.out.println("请输入您的手机或座机号");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if (s.matches("(1[3-9]\\d{9})|(0\\d{2,7}-?[1-9]\\d{4,19})")) {
                System.out.println("校验成功");
                break;
            } else {
                System.out.println("格式不正确");
            }
        }
    }

    private static void checkEmail() {
        while (true) {
            System.out.println("请输入您的邮箱");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if (s.matches("\\w{2,}@\\w{2,20}(\\.\\w{2,18}){1,2}")) {
                System.out.println("校验成功");
                break;
            } else {
                System.out.println("格式不正确");
            }
        }
    }
}
