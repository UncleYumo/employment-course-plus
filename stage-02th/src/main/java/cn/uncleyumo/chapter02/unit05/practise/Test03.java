package cn.uncleyumo.chapter02.unit05.practise;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test03
 * @createDate 4/21/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 设计一个小程序，根据用户输入的身高体重，计算出BMI指数，并根据BMI指数输出相应的健康建议。最后使用StringBuilder将结果输出为如下格式的字符串：
 *
 * "您的身高为XXX m，体重为XXX kg，BMI指数为XXX，健康建议为XXX。"
 *
 * 其中，XXX为对应的数值和文字描述。
 *
 * 提示：使用BigDecimal的divide方法计算BMI指数，使用compareTo方法进行BMI指数比较，BMI指数保留1位小数及四舍五入，
 * 使用StringBuilder的append方法进行字符串拼接，根据BMI指数输出相应的信息。并给出测试代码
 */
public class Test03 {
    public static void main(String[] args) {
        String heightStr = "1.75";
        String weightStr = "40.0";

        BigDecimal height = new BigDecimal(heightStr);
        BigDecimal weight = new BigDecimal(weightStr);

        // 计算BMI指数
        BigDecimal bmi = weight.divide(height.pow(2), 1, RoundingMode.HALF_UP);

        String suggestion;
        if (bmi.compareTo(new BigDecimal("18.5")) < 0) {
            suggestion = "体重过轻";
        } else if (bmi.compareTo(new BigDecimal("24.9")) <= 0) {
            suggestion = "正常";
        } else if (bmi.compareTo(new BigDecimal("29.9")) <= 0) {
            suggestion = "超重";
        } else {
            suggestion = "肥胖";
        }

        // 使用StringBuilder将结果格式化输出
        StringBuilder result = new StringBuilder();
        result.append("您的身高为").append(heightStr).append(" m，")
                .append("体重为").append(weightStr).append(" kg，")
                .append("BMI指数为").append(bmi).append("，")
                .append("健康建议为").append(suggestion).append("。");
        System.out.println(result.toString());
    }
}
