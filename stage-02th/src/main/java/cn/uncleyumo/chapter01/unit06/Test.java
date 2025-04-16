package cn.uncleyumo.chapter01.unit06;

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
        System.out.println(GenderEnum.MALE.getGenderName());
        System.out.println(GenderEnum.getGenderEnum("男"));
        System.out.println(GenderEnum.getGenderEnum("xxx"));
    }
}
