package cn.uncleyumo.chapter02.unit05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uncle_yumo
 * @fileName Test07
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 * 编写一个泛型接口 DataStructure
 * ① 定义一个抽象方法 void push(E element)，表示向数据结构中添加元素。
 * ② 再定义一个抽象方法 E pop()，表示从数据结构中取出一个元素并返回。
 * ③ 编写一个泛型类 Stack，实现 DataStructure 接口，并完成 push 和 pop 方法的实现。
 * ④ 新建一个测试类，在main方法中测试调用xxx类的 push (存一个数据)和 pop（取出一个数据）
 */

public class Test07 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

interface DataStructure<E> {
    void push(E element);
    E pop();
}

class Stack<E> implements DataStructure<E> {
    private final List<E> list = new ArrayList<>();

    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
    public E pop() {
        if (list.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }
}
