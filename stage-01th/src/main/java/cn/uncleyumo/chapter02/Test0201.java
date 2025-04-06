package cn.uncleyumo.chapter02;

import java.util.Scanner;

/**
 * @author uncle_yumo
 * @fileName Test0201
 * @createDate 2025/4/5 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Test0201 {
    public static void main(String[] args) {
        Test03.start();
    }
}

/*4. 题干
    小明去超市购买 牙膏(12元)、牙刷(2元)、洗头膏(32元)、毛巾(5元)、香皂(8元)这几款日用品，
    收银员需要手动在收银系统中录入这几款商品的价格，并在订单列表中求出它们的总价。
    请使用代码，完成收银系统的功能。*/
class Test01 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("用户购买了：牙膏(12元)、牙刷(2元)、洗头膏(32元)、毛巾(5元)、香皂(8元)");
        System.out.print("请输入牙膏的价格：");
        double price1 = scanner.nextDouble();
        System.out.print("请输入牙刷的价格：");
        double price2 = scanner.nextDouble();
        System.out.print("请输入洗头膏的价格：");
        double price3 = scanner.nextDouble();
        System.out.print("请输入毛巾的价格：");
        double price4 = scanner.nextDouble();
        System.out.print("请输入香皂的价格：");
        double price5 = scanner.nextDouble();
        double totalPrice = price1 + price2 + price3 + price4 + price5;
        System.out.println("总价为：" + totalPrice);
    }
}

/*设计一个程序，实现数组元素出现次数统计功能，具体如下：
    ① 定义一个长度为10的数组，里面存放0-5之间的随机数，并输出显示数组内容到控制台
    ② 统计任务①的数组每个元素出现的次数，并输出到控制台显示，格式为：“x出现了:x次”*/
class Test02 {
    public static void start() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 6);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int k : arr) {
            int count = 0;
            for (int i : arr) {
                if (k == i) {
                    count++;
                }
            }
            System.out.println(k + "出现了：" + count + "次");
        }
    }
}

/*某地出租车收费标准如下
    ① 起步价：10元，起步里程：3公里
    ② 车公里单价：1.8元/公里。
    ③ 加收燃油附加费1元

    假如乘客行驶的里程是4公里。
    请设计一个方法用来计算乘客乘坐出租车应付的费用。*/
class Test03 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入乘客行驶的里程：");
        double distance = scanner.nextDouble();
        double startPrice = 10;
        double kmPrice = 1.8;
        double fuelPrice = 1;
        double totalPrice = startPrice + distance * kmPrice + fuelPrice;
        System.out.println("应付费用：" + totalPrice);
    }
}