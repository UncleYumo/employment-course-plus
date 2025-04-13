package cn.uncleyumo.chapter01.unit04.practise;

import java.util.Scanner;

/**
 * @author uncle_yumo
 * @fileName Drink
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public abstract class Drink {
    public abstract void taste();
}

class Coco extends Drink {
    @Override
    public void taste() {
        System.out.println("我是可口可乐，我是甜汽水");
    }
}

class SaltDrink extends Drink {
    @Override
    public void taste() {
        System.out.println("我是盐汽水，我是咸的");
    }
}

class DrinkTest {
    public static void main(String[] args) {
        sell();
    }

    public static void sell() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("甜的还是咸的：");
        String choice = scanner.nextLine();
        switch (choice) {
            case "甜" -> new Coco().taste();
            case "咸" -> new SaltDrink().taste();
            default -> {
                System.out.println("输入错误，请重新输入");
                sell();
            }
        }
    }
}