package cn.uncleyumo.chapter02.unit05.practise;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author uncle_yumo
 * @fileName Test05
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 * 小明家是果农，因为针对不同品相的苹果收购价格不同，现需要实现苹果按照品相分级，
 *   需要工人挑苹果，按照不同品相完成定价；为完成品相分级这一功能，请按照需求完成代码：
 * ①定义苹果类需包含属性：大小，颜色；提供基本的构造方法和get方法，set方法
 * ②定义接口CompareAble包含定义默认方法compare，挑选较大苹果。
 * ③定义接口实现类Compare。
 * ④定义工人类要有成员方法：挑选苹果Apple pickApple(CompareAble，Apple a1，Apple a2)。
 * ⑤测试类：创建Worker对象、创建两个Apple对象，一个Apple(5，"青色"),一个Apple(3，"红色")；
 *  需实现默认挑选大的苹果，打印苹果信息；指定颜色挑选，通过匿名内部类实现。
 */

public class Test05 {
    public static void main(String[] args) {
        System.out.println(new Worker().pickApple(new Compare(), new Apple(3, "青色"), new Apple(5, "红色")));
        System.out.println(new Worker().pickApple(new CompareAble() {
            @Override
            public Apple compare(Apple a1, Apple a2) {
                return "青色".equals(a1.getColor()) ? a1 : a2;
            }
        }, new Apple(5, "青色"), new Apple(3, "红色")));
    }
}

@Data
@AllArgsConstructor
class Apple {
    private int size;
    private String color;
    private Apple() {
    }

    @Override
    public String toString() {
        return "Apple{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}

interface CompareAble {
    default Apple compare(Apple a1, Apple a2) {
        if (a1.getSize() > a2.getSize()) {
            return a1;
        } else {
            return a2;
        }
    }
}

class Compare implements CompareAble {
}

class Worker {
    public Apple pickApple(CompareAble compare, Apple a1, Apple a2) {
        return compare.compare(a1, a2);
    }
}