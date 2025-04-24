package cn.uncleyumo.chapter05.unit05;

import java.util.Map;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test
 * @createDate 4/24/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */
public class Test {
    public static void main(String[] args) {
        practise01();
    }

    private static void practise01() {
        Map<String, Integer> map = Map.of(
                "a", 1,
                "b", 2,
                "c", 3
        );
        System.out.println(map);
        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        System.out.println(map.get("a"));
        System.out.println(map.get("d"));
        System.out.println(map.getOrDefault("d", 0));
        System.out.println(map.containsKey("a"));
        System.out.println(map.containsKey("d"));
        System.out.println(map.containsValue(1));
        System.out.println(map.containsValue(4));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}