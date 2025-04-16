package cn.uncleyumo.chapter01.unit06;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author uncle_yumo
 * @fileName GenderEnum
 * @createDate 2025/4/15 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Getter
public enum GenderEnum {
    MALE("男"),
    FEMALE("女"),
    UNKNOWN("未知");
    private final String genderName;

    GenderEnum(String genderName) {
        this.genderName = genderName;
    }

    /**
     * 根据性别名称获取性别枚举
     */
    public static GenderEnum getGenderEnum(String genderName) {
        return Arrays.stream(GenderEnum.values())
                .filter(g -> g.getGenderName().equals(genderName))
                .findFirst()
                .orElse(null);
    }
}
