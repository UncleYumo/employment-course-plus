package cn.uncleyumo.chapter02.unit05.practise;

/**
 * @author uncle_yumo
 * @fileName A
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 * 按如下要求编写Java程序：：
 * ① 定义接口A，里面包含值为3.14的常量PI和 抽象方法double area()；计算面积
 * ② 定义接口B，里面包含 抽象方法void setColor(String c)；设置颜色
 * ③ 定义接口C，该接口继承了接口A和B，里面包含 抽象方法 double volume()；计算体积
 * ④ 定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、圆柱体的高height、颜色color，并进行方法重写
 * （area方法计算圆柱体的侧面积，setColor方法设置颜色，volume方法计算圆柱体的体积）
 * ⑤定义测试类及测试方法，创建Cylinder对象，打印该圆柱体对象的侧面积、体积及颜色
 * 提示：圆柱体的侧面积计算公式为：S侧=2πrh 圆柱体的体积计算公式为：V=πr²h
 */

public class Test01 {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        cylinder.radius = 5;
        cylinder.height = 10;
        cylinder.setColor("red");
        System.out.println("面积：" + cylinder.area());
        System.out.println("体积：" + cylinder.volume());
        System.out.println(cylinder);
    }
}

class Cylinder implements C {
    public double radius;
    public double height;
    public String color;
    @Override
    public double area() {
        return radius * radius * A.PI;  // 侧面积计算公式：S=2πrh
    }

    @Override
    public void setColor(String c) {
        this.color = c;
    }

    @Override
    public double volume() {
        return A.PI * radius * radius * height;  // 体积计算公式：V=πr²h
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + radius +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }
}

interface A {
    double PI = 3.14;
    double area();
}

interface B {
    void setColor(String c);
}

interface C extends A, B {
    double volume();
}


