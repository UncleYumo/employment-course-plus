package cn.uncleyumo.chapter03.java;

import java.util.Arrays;

/**
 * @author uncle_yumo
 * @fileName Test02
 * @createDate 2025/4/7 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Test02 {
    public static void main(String[] args) {
        practise01();
    }

    public static void practise01() {
        String str = "acfhtksud";
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        System.out.println("Length：" + chars.length);
        System.out.println("chars: " + Arrays.toString(chars));
    }
}