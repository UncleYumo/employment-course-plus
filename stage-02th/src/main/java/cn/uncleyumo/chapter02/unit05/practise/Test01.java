package cn.uncleyumo.chapter02.unit05.practise;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/21/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 请使用StringBuilder类、StringJoiner类、Math类、BigDecimal类中的常用方法实现以下功能：
 * ①输入两个数，分别用BigDecimal表示
 * ②计算它们的乘积并对结果进行四舍五入
 * ③最后用StringBuilder将结果输出为如下格式的字符串："数字1与数字2的乘积为XXX"
 * 其中，数字1、数字2和XXX分别为对应的数值。
 * 提示：使用Math中的round方法对结果进行四舍五入，使用BigDecimal的multiply方法计算乘积，使用StringBuilder的append方法进行字符串拼接。
 */
public class Test01 {
    public static void main(String[] args) {
        // 输入两个数，分别用BigDecimal表示
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个数：");
        String num1 = "0.123123";
        String num2 = "0.1234234";
        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(num1));
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(num2));
        System.out.println("bigDecimal1: " + bigDecimal1 + " bigDecimal2: " + bigDecimal2);
        // 计算它们的乘积并对结果进行四舍五入
        BigDecimal result = bigDecimal1.multiply(bigDecimal2).setScale(10, BigDecimal.ROUND_HALF_UP);
        System.out.println("result: " + result);

        // 最后用StringBuilder将结果输出为如下格式的字符串："数字1与数字2的乘积为XXX"
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("数字1与数字2的乘积为");
        stringBuilder.append(result);
        System.out.println(stringBuilder);
    }
}
