package cn.uncleyumo.chapter05.unit02;

import java.util.LinkedList;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test02
 * @createDate 4/23/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test02 {
    public static void main(String[] args) {
        practise02();
    }

    public static void practise02() {
        LocalStack<String> stringLocalStack = new LocalStack<>();
        stringLocalStack.push("a");  // | a
        stringLocalStack.push("b");  // | b, a
        stringLocalStack.push("c");  // | c, b, a
        System.out.println(stringLocalStack.peek());  // c | c, b, a
        System.out.println(stringLocalStack.peek());  // c | c, b, a
        System.out.println(stringLocalStack.pop());  // c | b, a
        System.out.println(stringLocalStack.pop());  // b | a
        stringLocalStack.push("d");  // d, a
        System.out.println(stringLocalStack.pop());  // d | a
        System.out.println(stringLocalStack.pop());  // a |
    }
    public static void practise01() {
        LocalQueue<String> stringLocalQueue = new LocalQueue<>();
        stringLocalQueue.add("a");  // a
        stringLocalQueue.add("b");  // a, b
        stringLocalQueue.add("c");  // a, b, c
        System.out.println(stringLocalQueue.peek());  // a | a, b, c
        System.out.println(stringLocalQueue.peek());  // a | a, b, c
        System.out.println(stringLocalQueue.poll());  // a | b, c
        System.out.println(stringLocalQueue.poll());  // b | c
        stringLocalQueue.add("d");  // c, d
        System.out.println(stringLocalQueue.poll());  // c | d
        System.out.println(stringLocalQueue.poll());  // d |
        System.out.println(stringLocalQueue.poll());  // null |
    }
}

class LocalQueue<T> {
    private final LinkedList<T> list = new LinkedList<T>();
    public void add(T t) {
        list.addLast(t);
    }
    public T poll() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }
    public T peek() {
        return list.peek();  // 获取第一个元素，但不移除
    }
    public int size() {
        return list.size();
    }
    public void clear() {
        list.clear();
    }
}

class LocalStack<T> {
    private final LinkedList<T> list = new LinkedList<T>();
    public void push(T t) {
        list.addFirst(t);
    }
    public T pop() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }
    public T peek() {
        return list.peek();
    }
    public int size() {
        return list.size();
    }
}