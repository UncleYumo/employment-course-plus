package cn.uncleyumo.chapter05.unit02.practise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author dev.uncleyumo.cn
 * @fileName ShoppingCart
 * @createDate 4/25/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 实现电商平台的用户购物车。购物车中存储了用户选购的商品信息（字符串表示），您需要实现以下功能：
 * ①将用户的购物车中的商品信息存储在一个Set集合中，确保每个商品只出现一次。
 * ②实现添加商品到购物车的功能，确保同一商品不会重复添加。
 * ③实现从购物车中移除商品的功能，用户可以选择要移除的商品。
 * ④实现展示购物车中的所有商品的功能，以便用户可以查看他们已选择的商品。
 * ⑤创建main方法测试以上方法
 */

public class ShoppingCartSystem {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCommodity(new Commodity("Apple", 10.0));
        shoppingCart.addCommodity(new Commodity("Banana", 5.0));
        shoppingCart.addCommodity(new Commodity("Apple", 10.0));
        shoppingCart.addCommodity(new Commodity("Orange", 8.0));
        shoppingCart.showCommodity();
        shoppingCart.addCommodity(new Commodity("Orange", 8.0));
        shoppingCart.showCommodity();
        shoppingCart.removeCommodity(new Commodity("Apple", 10.0));
        shoppingCart.showCommodity();
        shoppingCart.removeCommodity(new Commodity("Banana", 5.0));
        shoppingCart.showCommodity();
    }
}

class ShoppingCart {
    private final Set<Commodity> commoditySet;
    public ShoppingCart() {
        this.commoditySet = new HashSet<>();
    }
    public void addCommodity(Commodity commodity) {
        commoditySet.add(commodity);
        System.out.println(commodity.getName() + " have been added to your shopping cart!");
    }
    public void removeCommodity(Commodity commodity) {
        commoditySet.remove(commodity);
        System.out.println(commodity.getName() + " have been removed from your shopping cart!");
    }
    public void showCommodity() {
        Iterator<Commodity> iterator = commoditySet.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Commodity commodity = iterator.next();
            System.out.println(commodity.toString(index++));
        }
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Commodity {
    private String name;
    private double price;

    public String toString(int index) {
        return index + " - Name: " + getName() + " | Price: " + getPrice();
    }
}