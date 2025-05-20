package cn.uncleyumo.chapter10.unit01.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName ShoppingCart.java
 * @createDate 5/20/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int getItemCount() {
        return items.size();
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}