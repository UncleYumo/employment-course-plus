package cn.uncleyumo.chapter04.practise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dev.uncleyumo.cn
 * @fileName ShoppingCart
 * @createDate 4/25/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 需要实现一个购物车功能。请设计一个Java程序，使用Map集合作为购物车的数据结构，并实现以下功能：
 *  ①使用HashMap作为购物车的实现类。
 *  ②封装一个商品类，包含商品的名称、价格和数量等属性。
 *  ③提供添加商品到购物车的方法，根据商品名称作为键，商品对象作为值存储到Map中。
 *  ④提供展示购物车所有商品的方法，遍历Map集合，输出每个商品的名称、价格和数量。
 *  ⑤提供计算购物车总价的方法，遍历Map集合，累加每个商品的价格乘以数量，并返回总价。
 */

public class ShoppingCart {
    private final Map<String, Commodity> cart = new HashMap<>(Map.of(
            "apple", new Commodity("apple", 1.5, 2),
            "banana", new Commodity("banana", 2.0, 3),
            "orange", new Commodity("orange", 1.8, 4)
    ));

    public void addCommodity(Commodity commodity) {
        cart.put(commodity.getName(), commodity);
    }

    public void showCommodity() {
        System.out.println("------------------------------------------------");
        cart.forEach((name, commodity) -> {
            System.out.println("name: " + name + " | price: " + commodity.getPrice() + " | count: " + commodity.getCount());
        });
        System.out.println("------------------------------------------------");
    }

    public void showAllPrice() {
        double totalPrice =
                cart.values()
                        .stream()
                        .mapToDouble(item -> item.getPrice() * item.getCount())
                        .sum();
        System.out.println("The total value of the shopping cart is " + totalPrice);
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.showCommodity();
        shoppingCart.addCommodity(new Commodity("apple", 1.5, 2));
        shoppingCart.showCommodity();
        shoppingCart.addCommodity(new Commodity("grape", 1.5, 2));
        shoppingCart.showCommodity();
        shoppingCart.showAllPrice();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Commodity {
    private String name;
    private double price;
    private int count;
}