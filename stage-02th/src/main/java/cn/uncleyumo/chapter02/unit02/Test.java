package cn.uncleyumo.chapter02.unit02;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author uncle_yumo
 * @fileName Test
 * @createDate 2025/4/16 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Test {
    public static void main(String[] args) {
//        String arrayData = getArrayData(new int[]{1234512345,12341234,12341234,123});
//        System.out.println(arrayData);
//        testStringJoiner();
//        getArrayDataPlus(new int[]{1234512345, 12341234, 123});
        System.out.println(new Object());
    }

    public static String getArrayData(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Arrays.stream(arr).forEach(i -> sb.append(i).append(", "));
        return sb.substring(0, sb.length() - 2) + "]";
    }

    public static void testStringJoiner() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        stringJoiner.add("apple").add("banana").add("orange").add("grape").add("pear");
        System.out.println(stringJoiner);
    }

    public static void testStringBuilder() {
        long frequency = 10000000L;
        LocalDateTime startTime = LocalDateTime.now();
        StringBuilder str = new StringBuilder();
        for (long i = 0; i < frequency; i++) {
            str.append(i);
        }
        String string = str.toString();
        System.out.println("String length: " + string.length());
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Time used: " + (endTime.getNano() - startTime.getNano()) / 1000000 + "ms");
    }

    public static void getArrayDataPlus(int[] arr) {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        Arrays.stream(arr).forEach(i -> sj.add(String.valueOf(i)));
        System.out.println(sj);
    }
}
