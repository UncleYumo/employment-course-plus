package cn.uncleyumo.chapter02.unit04.practise;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
        practise03();
    }

    /**
     * 编写一个程序计算机票到达的目的地的当地时间
     * 1.输入出发日期和时间、目的地时区、旅行时间（小时数）
     * 2.计算并格式化输出到达目的地的当地日期和时间，时间格式为：yyyy-MM-dd HH:mm:ss
     * 代码实现可以使用DateTimeFormatter类、ZoneId类、ZonedDateTime类的相关方法。
     */
private static void practise03() {
    // 获取用户输入的出发地时间、目的地时区（如：America/New_York）、旅行时间（小时数）
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入出发日期和时间");
    String departureDateTime = scanner.nextLine();
    departureDateTime = departureDateTime.equals("q") ? "2025-01-01 00:00:00" : departureDateTime;
    System.out.println("请输入目的地时区（如：America/New_York）");
    String destinationZone = scanner.nextLine();
    destinationZone = destinationZone.equals("q") ? "Asia/Tokyo" : destinationZone;
    System.out.println("请输入旅行时间（小时数）");
    int travelTime = scanner.nextInt();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    ZoneId departureZoneId = ZoneId.of(ZoneId.systemDefault().getId());
    ZoneId destinationZoneId = ZoneId.of(destinationZone);
    LocalDateTime localDateTime = LocalDateTime.parse(departureDateTime, dateTimeFormatter);
    ZonedDateTime departureZonedDateTime = localDateTime.atZone(departureZoneId);
    ZonedDateTime destinationZonedDateTime = departureZonedDateTime.withZoneSameInstant(destinationZoneId);
    System.out.println("到达目的地的当地日期和时间：" + destinationZonedDateTime.plusHours(travelTime).format(dateTimeFormatter));
    scanner.close();
}


    /**
     * 编写一个程序，该程序应用于需要展示多个时区时间，要求使用LocalDateTime类和ZoneId类实现一个能显示多时区的电子时钟，要求如下：
     *
     * ①获取当前时区日期时间
     * ②将当前日期时间转换成纽约时区的日期时间
     * ③将当前日期时间转换成东京时区的日期时间
     * ④显示当前日期时间和纽约时区的日期时间之间的时间差（以小时为单位）
     * ⑤显示当前日期时间和东京时区的日期时间之间的时间差（以小时为单位）
     * 要求输出以上操作的结果。
     *
     * 提示：可以使用Duration类来计算时间差。
     */
    private static void practise02() {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        System.out.println("当前时区的日期与时间：" + zonedDateTime.toLocalDateTime());
        ZoneId newYorkZoneId = ZoneId.of("America/New_York");
        ZonedDateTime newYorkZonedDateTime = zonedDateTime.withZoneSameInstant(newYorkZoneId);
        System.out.println(
                "当前时区的日期与时间和纽约时区的日期时间之间的时间差（以小时为单位）：" +
                        Duration.between(zonedDateTime.toLocalDateTime(), newYorkZonedDateTime.toLocalDateTime())
                                .getSeconds() / 3600
        );
        ZoneId tokyoZoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime tokyoZonedDateTime = zonedDateTime.withZoneSameInstant(tokyoZoneId);
        System.out.println(
                "当前时区的日期与时间和东京时区的日期时间之间的时间差（以小时为单位）：" +
                        Duration.between(zonedDateTime.toLocalDateTime(), tokyoZonedDateTime.toLocalDateTime())
                                .getSeconds() / 3600
        );
    }

    /**
     * 编写一个Java程序，使用LocalDate、LocalTime、LocalDateTime、ZoneId、ZonedDateTime和Instant类完成以下操作：
     *
     * ①获取当前日期和时间，并输出当前日期，当前时间，当前日期和时间；
     * ②获取当前时区，并打印输出；
     * ③获取指定时区的指定时间（例如纽约时区），并打印输出；
     * ④将当前日期时间转换成指定时区（例如纽约时区）的日期时间，并打印输出；
     * ⑤获取当前时间戳，并打印输出；
     * ⑥将当前时间戳转换成指定日期时间和时区（例如上海时区）的日期时间，并打印输出。
     */
    private static void practise01() {
        // 1. 获取当前日期和时间，并输出当前日期，当前时间，当前日期和时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前日期：" + now.toLocalDate());
        System.out.println("当前时间：" + now.toLocalTime());
        System.out.println("当前日期和时间：" + now);

        // 2. 获取当前时区，并打印输出
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("当前时区：" + zonedDateTime.getZone());

        // 3. 获取指定时区的指定时间（例如纽约时区），并打印输出
        ZoneId newYorkZoneId = ZoneId.of("America/New_York");
        ZonedDateTime newYorkTime = ZonedDateTime.of(now, newYorkZoneId);
        System.out.println("纽约时区的当前时间：" + newYorkTime);

        // 4. 将当前日期时间转换成指定时区（例如纽约时区）的日期时间，并打印输出
        ZonedDateTime newYorkConvertedTime = now.atZone(ZoneId.systemDefault()).withZoneSameInstant(newYorkZoneId);
        System.out.println("当前时间转换为纽约时区：" + newYorkConvertedTime);

        // 5. 获取当前时间戳，并打印输出
        Instant instant = Instant.now();
        System.out.println("当前时间戳：" + instant);

        // 6. 将当前时间戳转换成指定日期时间和时区（例如上海时区）的日期时间，并打印输出
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime shanghaiTime = instant.atZone(shanghaiZoneId);
        System.out.println("当前时间戳转换为上海时区：" + shanghaiTime);
    }
}
