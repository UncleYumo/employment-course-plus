package cn.uncleyumo.chapter10.unit01.practise;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TestRectangle
 * @createDate 5/20/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 编写一个JUnit测试用例，测试一个计算矩形面积的方法
 * ①编写一个JUnit测试类RectangleTest，使用JUnit的注解和断言测试Rectangle类的getArea方法。
 * ②使用@Test注解标记测试方法。使用@BeforeClass注解修饰静态的初始化方法设置长方形的长和宽。
 * ③使用assertEquals断言验证计算结果是否正确。
 */

public class TestRectangle {
    private static Rectangle rectangle;
    @Test
    public void testGetArea() {
        long area = rectangle.getArea().longValue();
        Assert.assertEquals("Error: ", 200L, area);
    }
    @BeforeClass
    public static void init() {
        rectangle = new Rectangle(10, 20);
    }
}
