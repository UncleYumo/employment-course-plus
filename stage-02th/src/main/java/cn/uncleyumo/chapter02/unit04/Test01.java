package cn.uncleyumo.chapter02.unit04;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/21/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static void main(String[] args) {
        practise05();
    }

    // 使用Duration
    private static void practise05() {
        Duration between = Duration.between(
                LocalDateTime.of(2020, 4, 21, 9, 9, 9),
                LocalDateTime.now()
        );
        System.out.println(
                " Days: " + between.toDays() +
                "\n Hours: " + between.toHours() +
                "\n Minutes: " + between.toMinutes() +
                "\n Seconds: " + between.getSeconds()
        );
    }

    // 掌握Period
    private static void practise04() {
        LocalDate start = LocalDate.of(2020, 4, 21);
        LocalDate end = LocalDate.of(2020, 4, 22);
        Period between = Period.between(start, end);
        System.out.println("between: " + between);
        System.out.println("between.getDays(): " + between.getDays());
        System.out.println("between.getMonths(): " + between.getMonths());
        System.out.println("between.getYears(): " + between.getYears());
    }

    // 使用DateTimeFormatter
    private static void practise03() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);

        LocalDateTime now = LocalDateTime.now();
        String format1 = now.format(dateTimeFormatter);
        System.out.println(format1);

        DateTimeFormatter dateTimeFormatter02 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String dateStr = "2020年04月21日 09:09:09";
        LocalDateTime parse = LocalDateTime.parse(dateStr, dateTimeFormatter);
        System.out.println(parse);

    }

    // 使用Instant
    private static void practise02() {
        Instant now = Instant.now(); // 获取当前的时间信息
        long epochSecond = now.getEpochSecond();  // 获取秒数

        int nano = now.getNano();  // 获取纳秒数
        System.out.println("epochSecond: " + epochSecond);
        System.out.println("nano: " + nano);

        Instant instant = now.plusNanos(101010L);
        // 将instant转换成LocalDateTime
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println("zonedDateTime: " + zonedDateTime);
    }

    public static void practise01() {
        LocalDate now = LocalDate.now();
        System.out.println("Year of Now: " + now.getYear());
        System.out.println("Month of Now: " + now.getMonth());
        System.out.println("Day of Now: " + now.getDayOfMonth());
        System.out.println("Day of Week: " + now.getDayOfWeek());

        // 修改某个时间
        LocalDate localDate = now.withMonth(Month.AUGUST.getValue());
        System.out.println("Month of Now(localDate): " + localDate.getMonth());
        System.out.println("Month of Now(now): " + now.getMonth());
    }
}