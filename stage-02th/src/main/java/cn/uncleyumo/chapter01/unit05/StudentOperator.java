package cn.uncleyumo.chapter01.unit05;

import java.util.List;

/**
 * @author uncle_yumo
 * @fileName StudentOperator
 * @createDate 2025/4/15 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public interface StudentOperator {
    int num = 0;
    void printAllInfo(List<Student> students);
    void printAverageScore(List<Student> students);
    public static void showNum() {
//        num++;
        System.out.println("num = " + num);
    }
}
