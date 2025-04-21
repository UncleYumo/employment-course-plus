package cn.uncleyumo.chapter02.unit05;

import lombok.*;

/**
 * @author uncle_yumo
 * @fileName Test09
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 * ① 定义一个图形类Picture（抽象类），需包含属性：边长（sideLength）、边数（sideCount），
 *  需包含抽象方法：求周长getPerimeter方法、求面积getArea方法、显示图形信息show方法
 * ② 定义图形类Picture的两个子类：圆形类Circle 和 矩形类Rect
 * 圆形类Cirle需包含属性：圆心x（centerX）、圆心y （centerY）、半径（radius），
 *  重写求周长、求面积方法、显示信息方法,矩形类Rect需包含属性：长（length）、宽（width），重写求周长、求面积方法、显示信息方法
 * ③ 定义测试类：测试方法中用多态的形式创建圆形类Cirle对象 和 矩形类Rect对象，分别调用show方法显示信息
 */

public class Test09 {
    public static void main(String[] args) {
        Picture circle = new Circle(5, 3, 4);
        circle.show();

        Picture rect = new Rect(10, 4, 5, 3);
        rect.show();
    }
}

@Data
@AllArgsConstructor
abstract class Picture {
    private int sideLength;
    private int sideCount;
    private Picture() {}
    abstract double getPerimeter();
    abstract double getArea();
    abstract void show();
}

@Getter
@Setter
class Circle extends Picture {
    private int centerX;
    private int centerY;
    private int radius;

    public Circle(int centerX, int centerY, int radius) {
        super(0, 0);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    void show() {
        System.out.printf("""
                
                圆形 -> 圆心: (%d, %d) 半径: %d
                周长: %f 面积: %f
                
            """.trim(), centerX, centerY, radius, getPerimeter(), getArea());
    }
}

@Getter
@Setter
class Rect extends Picture {
    private int length;
    private int width;

    public Rect(int sideLength, int sideCount, int length, int width) {
        super(sideLength, sideCount);
        this.length = length;
        this.width = width;
    }

    @Override
    double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    double getArea() {
        return length * width;
    }

    @Override
    void show() {
        System.out.println();
        System.out.printf("""
                
                矩形 -> 长: %d 宽: %d
                周长: %f 面积: %f
                
            """.trim(), length, width, getPerimeter(), getArea());
    }
}