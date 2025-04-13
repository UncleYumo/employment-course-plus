package cn.uncleyumo.chapter01.unit01.practise;

import java.time.LocalDate;
import java.util.Random;

/**
 * @author uncle_yumo
 * @fileName PractiseTest
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class PractiseTest {
    public static void main(String[] args) {
        Beef b1 = Beef.builder().part("上脑").price(115).build();
        Beef b2 = Beef.builder().part("吊龙").price(120).build();
        System.out.println(b1.getCount(new Random().nextInt(1000) + 1));
        System.out.println(b2.getCount(new Random().nextInt(1000) + 1));
    }
}
