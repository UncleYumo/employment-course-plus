package cn.uncleyumo.chapter02.unit02;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uncle_yumo
 * @fileName Test04
 * @createDate 2025/4/19 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 * 设计一个购物车系统，其中涉及到以下两个类：
 * Product类，表示一个商品，包含商品的编号（id）、名称（name）、价格（price）等属性；
 * ShoppingCart类，表示一个购物车，包含多个商品（Product对象）。
 * 请完成以下任务：
 * ①在Product类中重写equals方法，判断两个商品是否相同时，只需要比较它们的编号id。
 * ②在Product类中重写toString方法，使得打印出一个Product对象时，输出该商品的编号、名称、价格等信息。
 * ③在Product类中实现Cloneable接口，并重写clone方法，使得可以复制一个Product对象。
 * ④在ShoppingCart类中实现以下方法：
 * void addProduct(Product product)：向购物车中添加一个商品；
 * void removeProduct(Product product)：从购物车中移除一个商品；
 * double calculateTotalPrice()：计算购物车中所有商品的总价。
 * ⑤新建一个测试类
 * 1.测试自定义equals方法
 * 2.测试自定义toString方法
 * 3.测试clone方法
 * 4.测试添加方法
 * 5.测试删除方法
 */

public class Test04 {
    public static void main(String[] args) {
        Product p1 = new Product(1, "apple", 1.5);
        Product p2 = new Product(2, "banana", 2.5);
        Product p3 = new Product(1, "apple", 1.5);

        System.out.println("预期结果：p1.equals(p2) = false" + "\t实际结果：" + p1.equals(p2)); // false
        System.out.println("预期结果：p1.equals(p3) = true" + "\t实际结果：" + p1.equals(p3)); // true
        System.out.println("预期结果：p1.toString() = Product{id=1, name='apple', price=1.5}" + "\t实际结果：" + p1.toString());
        System.out.println("预期结果：p1.clone().toString() = Product{id=1, name='apple', price=1.5}" + "\t实际结果：" + p1.clone().toString());
        int i = p1.hashCode();
        int i1 = p1.clone().hashCode();
        System.out.println("p1.hashCode() = " + i + "\tp1.clone().hashCode() = " + i1);
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        System.out.println("预期结果：cart.calculateTotalPrice() = 4.0" + "\t实际结果：" + cart.calculateTotalPrice()); // 4.0
        cart.removeProduct(p1);
        System.out.println("预期结果：cart.calculateTotalPrice() = 2.5" + "\t实际结果：" + cart.calculateTotalPrice()); // 2.5
    }
}

@Getter
@Setter
@AllArgsConstructor
class Product implements Cloneable {
    private int id;
    private String name;
    private double price;
    private Product() {}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Product product) {
            return this.id == product.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @SneakyThrows  // 防止clone方法抛出异常
    @Override
    public Product clone() {
        Object clone = super.clone();
        return new Product(id, name, price);
    }
}

@Data
class ShoppingCart {
    final private List<Product> products = new ArrayList<>();
    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
