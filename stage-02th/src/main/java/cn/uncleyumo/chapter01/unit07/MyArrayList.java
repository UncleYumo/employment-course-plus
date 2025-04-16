package cn.uncleyumo.chapter01.unit07;

/**
 * @author uncle_yumo
 * @fileName MyArrayList
 * @createDate 2025/4/16 April
 * @school 无锡学院
 * @studentID 22344131
 * @description 自定义泛型类
 */

@SuppressWarnings("unchecked")
public class MyArrayList<E> {
    private Object[] localArray = new Object[10];
    private int size = 0;
    public boolean add(E e) {
        if (size == localArray.length) {
            Object[] newArray = new Object[localArray.length * 2];
            System.arraycopy(localArray, 0, newArray, 0, size);
            localArray = newArray;
        }
        localArray[size++] = e;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        E e = (E) localArray[index];
        if (e == null) {
            throw new NullPointerException("Element is null");
        }
        return e;
    }

    public int size() {
        return size;
    }
}
