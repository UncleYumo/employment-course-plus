package cn.uncleyumo.chapter03.unit01;

import java.util.Arrays;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test03
 * @createDate 4/22/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test03 {
    public static void main(String[] args) {
        Integer[] arr = {2, 4, 6, 1, 9, 3, 0, 7};
//        Arrays.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer i1, Integer i2) {
//                return i2.compareTo(i1);
//            }
//        });
        Arrays.sort(arr, (i1, i2) -> i2.compareTo(i1));
        System.out.println(Arrays.toString(arr));
    }
}