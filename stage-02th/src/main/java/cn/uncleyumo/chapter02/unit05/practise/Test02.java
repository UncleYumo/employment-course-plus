package cn.uncleyumo.chapter02.unit05.practise;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test02
 * @createDate 4/21/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 实现一个掷骰子的小游戏，记录六次投掷的结果，并计算6次结果的平均值，使用ArrayList，存储多个整数。
 * ①使用Math中的random方法生成6个在1~6之间的随机整数，将它们添加到ArrayList中。
 * ②使用BigDecimal类中的divide方法计算这些整数的平均值。
 * ③将结果四舍五入到小数点后两位。
 * ④最后使用StringBuilder将结果输出为如下格式的字符串："生成的随机数为X,X,X，平均值为YYY"
 * 其中，X,X,X为生成的随机数列表，YYY为计算出的平均值。
 *
 * 提示：使用StringBuilder的append方法进行字符串拼接，使用StringJoiner将随机数列表转化为字符串，
 * 使用BigDecimal的setScale方法设置小数点位数，使用BigDecimal的divide方法获取平均值。（方法的具体使用自行查看api文档）
 */
public class Test02 {
    public static void main(String[] args) {
        // ①使用Math中的random方法生成6个在1~6之间的随机整数，将它们添加到ArrayList中。
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            integers.add((int) (Math.random() * 6 + 1));
        }
        System.out.println(integers);
        // ②使用BigDecimal类中的divide方法计算这些整数的平均值。
        BigDecimal sum
                = BigDecimal.valueOf(integers.stream().mapToInt(Integer::intValue).sum());
        // ③将结果四舍五入到小数点后两位。(BigDecimal.的枚举已废弃)
        BigDecimal avg = sum.divide(BigDecimal.valueOf(integers.size()), 2, RoundingMode.HALF_UP);
        // ④最后使用StringBuilder将结果输出为如下格式的字符串："生成的随机数为X,X,X，平均值为YYY"
        StringJoiner stringJoiner = new StringJoiner(",");
        integers.forEach(num -> stringJoiner.add(num.toString()));
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append("生成的随机数为").append(
                stringJoiner
        ).append(", 平均值为").append(avg));
    }
}
