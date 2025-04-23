package cn.uncleyumo.chapter03.unit02.practise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/23/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 给一家超市管理系统编写一个程序
 * 1.要求能够统计每种商品销售量的前N名，并输出其销售数量及商品名称
 * 2.商品信息存储在一个数组中，每个元素包含商品名称和销售数量两个属性。
 * 3.编写一个方法，能够接收一个商品信息数组和一个整数N，返回销售量前N名的商品信息。
 * 提示：可以使用Arrays类的sort方法进行排序，使用Comparator接口自定义排序规则，然后使用Arrays类的copyOf方法进行结果拷贝
 */
public class Test01 {
    public static void main(String[] args) {
        Product p1 = new Product("A", 10);
        Product p2 = new Product("B", 30);
        Product p3 = new Product("C", 30);
        Product p4 = new Product("D", 100);
        Product p5 = new Product("E", 50);
        Product[] products = new Product[]{p1, p2, p3, p4, p5};
        printTopN(products, 3);
    }
    public static void printTopN(Product[] products, int n) {
        Arrays.sort(products, Product::compareTo);
        Arrays.stream(Arrays.copyOf(products, n)).forEach(System.out::println);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Product {
    private String name;
    private int sales;

    public static int compareTo(Product p1, Product p2) {
        return p2.getSales() - p1.getSales();
    }
}