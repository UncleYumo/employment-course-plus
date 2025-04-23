package cn.uncleyumo.chapter05.unit01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test
 * @createDate 4/23/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static void main(String[] args) {
        practise02();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Product {
        private String name;
        private double price;
        private int quantity;
    }

    static class ShoppingList {
        private ArrayList<Product> products = new ArrayList<>();

        public void addProduct(Product product) {
            products.add(product);
        }

        public void calculateTotal() {
            int totalQuantity = 0;
            double totalPrice = 0.0;
            for (Product product : products) {
                totalQuantity += product.getQuantity();
                totalPrice += product.getPrice() * product.getQuantity();
            }
            System.out.println("总数量: " + totalQuantity);
            System.out.println("总价格: " + totalPrice);
        }

        public void findProductByName(String name) {
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    System.out.println("找到商品: " + product);
                    return;
                }
            }
            System.out.println("未找到商品: " + name);
        }

        public void printSortedProducts() {
            Product[] productArray = products.toArray(new Product[0]);
            Arrays.sort(productArray, Comparator.comparingDouble(Product::getPrice).reversed());
            System.out.println("按价格从高到低排序的商品列表:");
            for (Product product : productArray) {
                System.out.println(product);
            }
        }
    }

    /**
     * 测试方法
     */
    private static void practise02() {
        ShoppingList shoppingList = new ShoppingList();

        shoppingList.addProduct(new Product("苹果", 5.0, 10));
        shoppingList.addProduct(new Product("香蕉", 3.0, 20));
        shoppingList.addProduct(new Product("橙子", 4.0, 15));

        shoppingList.calculateTotal();

        shoppingList.findProductByName("香蕉");
        shoppingList.findProductByName("葡萄");

        shoppingList.printSortedProducts();
    }

    /**
     * 编写一个程序，创建一个ArrayList集合，完成以下功能
     * ①向其中添加一些字符串元素
     * ②使用迭代器遍历集合并输出其中所有元素
     * ③使用lambda表达式遍历集合并输出其中所有元素。
     */
    private static void practise01() {
        ArrayList<String> str = new ArrayList<>();
        str.add("hello");
        str.add("world");
        Iterator<String> iterator = str.iterator();
        iterator.forEachRemaining(System.out::println);

        // 使用 lambda 表达式遍历
        str.forEach(s -> System.out.println(s));
    }
}
