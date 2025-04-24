package cn.uncleyumo.chapter05.unit05;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

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
        practise02();
    }

    private static void practise02() {
        // 使用键找值遍历Map集合
        Map<String, Double> map = Map.of(
                "蜘蛛精", 145.7, "射手", 221.9,
                "天女散花", 165.8, "玉兔", 165.8,
                "王刚", 165.8, "后裔", 195.8
        );
        System.out.println(map);
        Set<String> strings = map.keySet();
        for (String s : strings) {
            System.out.println(s + ":" + map.get(s));
        }
        System.out.println("-------------------------");
        // 使用键值对遍历Map集合
        System.out.println(map.entrySet());
        for (Map.Entry<String, Double> stringDoubleEntry : map.entrySet()) {
            System.out.println(stringDoubleEntry.getKey() + ":" + stringDoubleEntry.getValue());
        }
        System.out.println("-------------------------");
        // 使用lambda表达式遍历Map集合
        map.forEach((k, v) -> System.out.println(k + ":" + v));
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
        Collection<Integer> values = map.values();
        Set<String> strings = map.keySet();
    }
}