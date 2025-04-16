package cn.uncleyumo.chapter01.unit07;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Arrays;

/**
 * @author uncle_yumo
 * @fileName Test
 * @createDate 2025/4/16 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@AllArgsConstructor
class OO {
    private String name;
}

/** @author uncle_yumo */
public class Test {
    public static void main(String... args) {
        Object[] list = getList(1, "2", 3.0, new OO("4"));
        Arrays.stream(list).toList().forEach(System.out::println);
    }

    @SafeVarargs  // 注解，表示该方法可以接受可变参数
    public static <T> T[] getList(T... arr) {
        return arr;
    }
}
