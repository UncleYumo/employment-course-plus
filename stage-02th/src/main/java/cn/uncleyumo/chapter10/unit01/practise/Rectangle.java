package cn.uncleyumo.chapter10.unit01.practise;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName RecTangle
 * @createDate 5/20/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Rectangle {
    private Integer width;
    private Integer height;

    public Rectangle(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public Integer getArea() {
        return width * height;
    }
}