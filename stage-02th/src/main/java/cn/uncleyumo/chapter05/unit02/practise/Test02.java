package cn.uncleyumo.chapter05.unit02.practise;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test02
 * @createDate 4/25/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 小超市的进货单Inventory类，需要记录每种商品的名称、数量和单价，使用List集合存储这些信息。并编写测试类测试以下功能：
 * ①创建product类属性包含 名称、数量、单价
 * ②创建Inventory类里面包含方法如下
 * ③添加新的商品到进货单中
 * ④查找进货单中某种商品的信息，并打印出来
 * ⑤统计进货单中所有商品的数量和总价
 * ⑥打印进货单中所有商品的信息
 * 提示，①要在product类中定义获取单个商品总价的方法，②product的toString方法要打印商品信息和总价
 */

public class Test02 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product("apple", 10, 2.5));
        inventory.addAllProduct(
                new Product("peach", 20, 3.5),
                new Product("banana", 30, 4.5),
                new Product("orange", 40, 5.5)
        );
        inventory.findProduct("apple");
        System.out.println("-----------------------");
        inventory.countTotal();
    }
}

class Inventory {
    private final List<Product> products;
    public Inventory() {
        products = new ArrayList<>();
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void addAllProduct(Product...products) {
        this.products.addAll(List.of(products));
    }
    public void findProduct(String name) {
        Optional<Product> first = products.stream().filter(it -> it.getName().equals(name)).findFirst();
        if (first.isPresent()) {
            System.out.println(first.get());
        } else {
            System.out.println("未查找到相关记录");
        }
    }
    public void countTotal() {
        products.forEach(System.out::println);
        System.out.println("总数量: " + products.stream().mapToInt(Product::getCount).sum());
        System.out.println("总价格: " + products.stream().mapToDouble(Product::getPrice).sum());
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Product {
    private String name;
    private Integer count;
    private Double price;

    @Override
    public String toString() {
        return "商品名: " + getName() + " | 数量: " + getCount() + " | 单价: " + getPrice() + " | 总价: " + getPrice() * getCount();
    }
}