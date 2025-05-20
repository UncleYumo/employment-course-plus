package cn.uncleyumo.chapter10.unit01.practise;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TestShoppingCart
 * @createDate 5/20/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 开发了一个购物车类ShoppingCart ，现在需要编写一个测试方法来检查添加商品到购物车的功能是否按预期工作。
 * ①使用JUnit框架来编写测试方法，
 * ②使用@BeforeEach注释来初始化购物车对象，
 * ③使用@AfterEach注释来清除购物车对象。
 * ④在测试方法中，使用assert语句来检查添加商品到购物车的数量和价格功能是否按预期工作。
 */

@SuppressWarnings("JUnit5AssertionsConverter")
public class TestShoppingCart {
    private static ShoppingCart cart;
    @BeforeEach
    public void init() {
        cart = new ShoppingCart();
    }
    @AfterEach
    public void clear() {
        cart = null;
    }
    @Test
    public void testAddItem() {
        Assert.assertEquals("Test addItem failed", 0, cart.getItemCount());
        cart.addItem(new Item("apple", 1.99));
        Assert.assertEquals("Test addItem failed", 1, cart.getItemCount());
    }
    @SuppressWarnings("deprecation")
    @Test
    public void testGetTotalPrice() {
        Assert.assertEquals("Test getTotalPrice failed", 0.0, cart.getTotalPrice());
        cart.addItem(new Item("apple", 1.99));
        Assert.assertEquals("Test getTotalPrice failed", 1.99, cart.getTotalPrice());
    }
    @Test
    public void testRemoveItem() {
        Assert.assertEquals("Test removeItem failed", 0, cart.getItemCount());
        cart.addItem(new Item("apple", 1.99));
        Assert.assertEquals("Test removeItem failed", 1, cart.getItemCount());
        cart.removeItem(new Item("apple", 1.99));
        Assert.assertEquals("Test removeItem failed", 0, cart.getItemCount());
    }
}
