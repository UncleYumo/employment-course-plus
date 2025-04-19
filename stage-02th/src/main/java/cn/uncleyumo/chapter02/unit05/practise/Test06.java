package cn.uncleyumo.chapter02.unit05.practise;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author uncle_yumo
 * @fileName Test06
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 * 请定义一个泛型类 MyMap<K,V>，包含两个成员变量 first 和 second，first的类型是K,second的类型是V，
 * ① 定义有参构造方法和first、second的get/set方法。
 * ② 新建一个测试类，在main方法中创建MyMap对象传入值，打印first和second
 * ③ 在MyMap类中定义一个无返回值的泛型方法print，接收一个泛型参数，并将接收到的泛型参数打印到控制台上
 */

public class Test06 {
    public static void main(String[] args) {
        MyMap<String, Integer> myMap = new MyMap<>("hello", 123);
        System.out.println(myMap.getFirst());
        System.out.println(myMap.getSecond());
        myMap.print(new MyMap("world", 12.10));
    }
}

@Data
@AllArgsConstructor
class MyMap<K, V> {
    private MyMap() {}
    private K first;
    private V second;
    public <T> void print(T t) {
        System.out.println(t);
    }
}