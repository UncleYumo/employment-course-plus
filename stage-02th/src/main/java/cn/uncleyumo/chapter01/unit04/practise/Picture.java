package cn.uncleyumo.chapter01.unit04.practise;

import lombok.Getter;
import lombok.Setter;

/**
 * @author uncle_yumo
 * @fileName Picture
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public abstract class Picture {
    private Double sideLength;
    private Integer sideCount;
    public abstract double getPerimeter();
    public abstract double getArea();
    public abstract void show();
}

@Getter
@Setter
class Circle extends Picture {
    private Double centerX;
    private Double centerY;
    private Double radius;

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;  // 圆形周长为2πr
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;  // 圆形面积为πr^2
    }

    @Override
    public void show() {
        System.out.println("圆形：" + radius + " 半径，周长：" + getPerimeter() + " 面积：" + getArea() + ", 坐标：" + centerX + "," + centerY);
    }
}

@Getter
@Setter
class Rect extends Picture {
    private Double width;
    private Double height;

    @Override
    public double getPerimeter() {
        return 2 * (width + height);  // 矩形周长为2(w+h)
    }

    @Override
    public double getArea() {
        return width * height;  // 矩形面积为wh
    }

    @Override
    public void show() {
        System.out.println("矩形：" + width + " x " + height + " 宽高，周长：" + getPerimeter() + " 面积：" + getArea());
    }
}

class PictureTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(5.0);
        circle.setCenterX(1.0);
        circle.setCenterY(2.0);
        circle.show();

        Rect rect = new Rect();
        rect.setWidth(3.0);
        rect.setHeight(4.0);
        rect.show();
    }
}