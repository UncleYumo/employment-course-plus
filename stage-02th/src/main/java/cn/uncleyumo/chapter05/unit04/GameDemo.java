package cn.uncleyumo.chapter05.unit04;

import cn.uncleyumo.chapter01.unit02.practise.Car;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author dev.uncleyumo.cn
 * @fileName GameDemo
 * @createDate 4/24/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */
public class GameDemo {
    public static void main(String[] args) {
        Room room = new Room();
        room.start();
    }
}

class Room {
    private final List<Card> allCards = new ArrayList<>();
    public Room() {
        // 1. 创建54张牌，存入集合中
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = {"♥", "♦", "♣", "♠"};
        // 组合并创建牌
        int size = 0;
        for (String number : numbers) {
            size++;
            for (String color : colors) {
                allCards.add(new Card(number, color, size));
            }
        }
        allCards.add(new Card("", "joker", ++size));
        allCards.add(new Card("", "king", ++size));
    }
    public void printAllCards() {
        for (Card card : allCards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
    public void start() {
        Collections.shuffle(allCards);
        // 打印洗牌后牌序：
//        printAllCards();
        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();
        List<Card> player3 = new ArrayList<>();
        for (int i = 0; i < allCards.size() - 3; i++) {
            Card card = allCards.get(i);
            switch (i % 3) {
                case 0: player1.add(card); break;
                case 1: player2.add(card); break;
                case 2: player3.add(card); break;
                default: break;
            }
        }
        List<Card> subCards = allCards.subList(allCards.size() - 3, allCards.size());
        System.out.println("底牌：" + subCards);
        System.out.println("-------------------------------------");
        // 选择地主
        switch (new Random().nextInt(3) + 1) {
            case 1:
                player1.addAll(subCards);
                System.out.println("player1成为地主");
                break;
            case 2:
                player2.addAll(subCards);
                System.out.println("player2成为地主");
                break;
            case 3:
                player3.addAll(subCards);
                System.out.println("player3成为地主");
                break;
            default: break;
        }
        // 对牌进行排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        System.out.println("玩家1：" + player1);
        System.out.println("玩家2：" + player2);
        System.out.println("玩家3：" + player3);
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Card implements Comparable<Card> {
    private String number;
    private String color;
    private int size;  // 0 1 2 3...

    @Override
    public String toString() {
        return color + number + "(" + size + ")";
    }

    @Override
    public int compareTo(@NotNull Card o) {
        return this.size - o.size;
    }
}