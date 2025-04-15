package cn.uncleyumo.chapter01.unit05;

/**
 * @author uncle_yumo
 * @fileName Test
 * @createDate 2025/4/15 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Test {
    public static void main(String[] args) {
        ClassManager classManager = new ClassManager();
        classManager.getOperator().printAllInfo(classManager.getStudents());
        classManager.getOperator().printAverageScore(classManager.getStudents());
    }
}
